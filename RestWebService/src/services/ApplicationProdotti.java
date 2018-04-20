package services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/services")
public class ApplicationProdotti extends Application{
	@Override
	public Set<Class<?>> getClasses() {
		final Set<Class<?>> classes = new HashSet<>();
		classes.add(ProdottiContainer.class);
		classes.add(ProdottoResources.class);
		return classes;
	}
	
}
