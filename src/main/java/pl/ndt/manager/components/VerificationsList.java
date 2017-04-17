package pl.ndt.manager.components;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import pl.ndt.manager.dto.VerificationDTO;

@Component
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class VerificationsList {
	
	private List<VerificationDTO> verifications;

	public VerificationsList(List<VerificationDTO> verifications) {
		super();
		this.verifications = verifications;
	}

	public List<VerificationDTO> getVerifications() {
		return verifications;
	}

	public void setVerifications(List<VerificationDTO> verifications) {
		this.verifications = verifications;
	}
	
	

}
