package ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService										//potevo anche evitare le annotazioni
public class WsSaluto {

	@WebMethod
	public String saluto(int tipoSaluto) {
		String saluto;
		switch(tipoSaluto) {
		case 1:
			saluto="Buongiorno";
			break;
		case 2:
			saluto="Buonasera";
			break;
		case 3:
			saluto="Buonanotte";
			break;
		default:
			saluto="Ciao";
			break;
		}
		return saluto;
	}

}