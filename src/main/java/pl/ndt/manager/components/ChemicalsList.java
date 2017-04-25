package pl.ndt.manager.components;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import pl.ndt.manager.model.Chemical;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ChemicalsList {

	private List<Chemical> chemicals;

	public ChemicalsList(List<Chemical> chemicals) {
		super();
		this.chemicals = chemicals;
	}

	public List<Chemical> getChemicals() {
		return chemicals;
	}

	public void setChemicals(List<Chemical> chemicals) {
		this.chemicals = chemicals;
	}
	
	
}
