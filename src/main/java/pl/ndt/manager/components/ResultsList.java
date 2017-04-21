package pl.ndt.manager.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.mysql.fabric.xmlrpc.base.Array;

import pl.ndt.manager.dto.CustomerDTO;
import pl.ndt.manager.dto.ResultOfExaminationDTO;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class ResultsList {
	private List<ResultOfExaminationDTO> results;

	public ResultsList() {
		results = new ArrayList<>();
	}

	public List<ResultOfExaminationDTO> getResults() {
		return results;
	}

	public void setResults(List<ResultOfExaminationDTO> reults) {
		this.results = reults;
	}


	
	
}
