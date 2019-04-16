package cci.cert;

import javax.ejb.Stateless;

@Stateless
public class OwnService implements IOwnService {

	public String getType() {
		return "It's CCI Own certificate";
	}
}
