import java.util.Properties;

import cci.cert.IOwnService;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Main x = new Main();
		x.connect();
	}

	public Main() {
		super();
	}

	private void connect() {
		try {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
			props.setProperty("org.omg.CORBA.ORBInitialHost", "192.168.0.72");
			props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

			InitialContext ctx = new InitialContext(props);
			System.out.println(ctx.getEnvironment());
			IOwnService service = (IOwnService) ctx.lookup("cci.cert.IOwnService");
			System.out.println(service.getType());

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
