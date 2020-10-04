package br.com.surittec.api.repository.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "address" )
@JsonIgnoreProperties(ignoreUnknown = true)
public class Address extends AbstractEntity {
	
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@JsonAlias({"cep"})
	private String zipCode;
	
	@JsonAlias({"logradouro"})
	private String publicPlace;
	
	@JsonAlias({"complement"})
	private String complement;
	
	@JsonAlias({"bairro"})
	private String neighborhood;
	
	@JsonAlias({"uf"})
	private String state;

	public Address() {}

	public Address(Client client, String zipCode, String publicPlace, String complement, String neighborhood,
			String state) {
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
