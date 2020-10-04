package br.com.surittec.api.repository.entity;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.surittec.api.repository.entity.User.Authority;

@Embeddable
public class UserAuthorities {
	
	@Enumerated(EnumType.STRING)
	private Authority authority;
	
	public UserAuthorities() {}

	public UserAuthorities(Authority authority) {
		super();
		this.authority = authority;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
