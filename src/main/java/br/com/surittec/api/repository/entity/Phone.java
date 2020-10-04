package br.com.surittec.api.repository.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "phone")
public class Phone extends AbstractEntity {

	
	private static final long serialVersionUID = 1L;


	public enum PhoneType {
		Residencial,
		Comercial,
		Celular, 
	}
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@NotEmpty(message = "O número de telefone é obrigatório")
	@NotNull(message = "O número de telefone é obrigatório")
	private String number;

	@NotEmpty(message = "O tipo do telefone é obrigatório")
	@NotNull(message = "O tipo do telefone é obrigatório")
	private PhoneType type;
	
	
	public Phone() {}


	public Phone(Client client, @NotEmpty @NotNull String number, PhoneType type) {
		super();
		this.client = client;
		this.number = number;
		this.type = type;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public PhoneType getType() {
		return type;
	}


	public void setType(PhoneType type) {
		this.type = type;
	}
	
	
	
	
}
