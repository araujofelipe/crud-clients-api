package br.com.surittec.api.repository.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class User extends AbstractEntity {

	public enum Authority {
		Admin("ROLE_ADMIN"), 
		Common("ROLE_COMMON");
		
		private Authority(String authority) {
			this.authority = authority;
		}
		
		private String authority;

		public String getAuthority() {
			return authority;
		}

		public void setAuthority(String authority) {
			this.authority = authority;
		}
		
		
	}
	
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String password;
	private Set<Authority> authorities;
	
	public User() {}

	public User(String login, String password, Set<Authority> authorities) {
		super();
		this.login = login;
		this.password = password;
		this.authorities = authorities;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	
	
}
