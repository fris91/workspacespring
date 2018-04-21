package services;

import javax.jws.WebService;

@WebService
public class Servizio {

	public int somma(int a, int b) {
		return a+b;
	}
	
	public int sottrazione(int a, int b) {
		return a-b;
	}
	
}
