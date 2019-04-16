import java.util.Properties;

import cci.cert.IOwnService;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;

public class Main {
	@EJB(beanName="cci.cert.IOwnService")
	IOwnService service;
	
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
			
			service = (IOwnService) ctx.lookup("cci.cert.IOwnService");
			System.out.println(service.getType());

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
