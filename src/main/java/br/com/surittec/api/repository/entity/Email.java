package br.com.surittec.api.repository.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "email")
public class Email extends AbstractEntity {

	
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	private String account;
	
	
	public Email() {}


	public Email(Client client, String account) {
		super();
		this.client = client;
		this.account = account;
	}

	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public String getAccount() {
		return account;
	}


	public void setAccount(String account) {
		this.account = account;
	}
	
}
