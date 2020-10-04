package br.com.surittec.api.repository.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "address" )
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends AbstractEntity {
	
	public enum State {
		AC,
		AL,
		AM,
		AP,
		BA,
		CE,
		DF,
		ES,
		GO,
		MA,
		MG,
		MS,
		MT,
		PA,
		PB,
		PE,
		PI,
		PR,
		RJ,
		RN,
		RO,
		RR,
		RS,
		SC,
		SE,
		SP,
		TO,
	}
	
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@JsonAlias({"cep"})
	@NotEmpty(message= "O CEP é obrigatório")
	@NotNull(message= "O CEP é obrigatório")
	private String zipCode;
	
	@JsonAlias({"logradouro"})
	@NotEmpty(message = "O logradouro é obrigatório")
	@NotNull(message = "O logradouro é obrigatório")
	private String publicPlace;
	
	@JsonAlias({"complement"})
	private String complement;
	
	@JsonAlias({"bairro"})
	@NotEmpty(message = "O bairro é obrigatório")
	@NotNull(message = "O bairro é obrigatório")
	private String neighborhood;
	
	@JsonAlias({"uf"})
	@NotEmpty(message = "A UF é obrigatória")
	@NotNull(message = "A UF é obrigatória")
	@Enumerated(EnumType.STRING)
	private State state;

	public Address() {}

	public Address(Client client, String zipCode, String publicPlace, String complement, String neighborhood,
			State state) {
		super();
		this.client = client;
		this.zipCode = zipCode;
		this.publicPlace = publicPlace;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.state = state;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
}
