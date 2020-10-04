package br.com.surittec.api.repository.entity;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "client")
public class Client extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Length(min = 3, max = 100) 
	@NotNull
	//@Pattern(regexp = "^[A-Za-z0-9]*$")
	@Column(name = "name")
	private String name;
	
	@NotNull
	@NotEmpty
	@CPF
	@Column(name = "cpf")
	private String cpf;
	
	@OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"client"})
	private Set<Phone> phones = Collections.emptySet();;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	@JsonIgnoreProperties({"client"})
	private Set<Email> emails = Collections.emptySet();

	
	public Client() {}


	public Client(String name, String cpf, Address address, Set<Phone> phones, Set<Email> emails) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.address = address;
		this.phones = phones;
		this.emails = emails;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public Set<Phone> getPhones() {
		return phones;
	}


	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}


	public Set<Email> getEmails() {
		return emails;
	}


	public void setEmails(Set<Email> emails) {
		this.emails = emails;
	}
	
	public void merge(Client client) {
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.address = client.getAddress();
		this.phones = client.getPhones();
		this.emails = client.getEmails();
	}
	
	
	

}
