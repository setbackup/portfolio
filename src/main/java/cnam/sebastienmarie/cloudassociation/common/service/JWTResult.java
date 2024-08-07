package cnam.sebastienmarie.cloudassociation.common.service;

import org.springframework.stereotype.Service;

@Service
public class JWTResult {

	private String login;
	private String id;
	private boolean admin;
	private String id_association;
	private boolean ok;

	public JWTResult(){
		
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public boolean isAdmin() {
		return this.admin;
	}

	public String getIdAssociation(){
		return this.id_association;
	}

	public boolean isOk(){
		return this.ok;
	}
	
	public void buildFail() {
		this.id = null;
		this.login = null;
		this.admin = false;
		this.id_association = null;
		this.ok=false;
	}
	
	public void buildInfo(String login, boolean admin, String id, String id_association) {
		this.id = id;
		this.login = login;
		this.admin = admin;
		this.id_association = id_association;
		this.ok=true;
	}
}
