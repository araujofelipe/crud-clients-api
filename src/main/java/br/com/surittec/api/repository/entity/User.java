package br.com.surittec.api.repository.entity;

import java.util.Collections;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
        name="USER_AUTHORITIES",
        joinColumns=@JoinColumn(name="user_id")
    )
	private List<UserAuthorities> authorities = Collections.emptyList();
	
	
	public User() {}

	public User(String login, String password, List<UserAuthorities> authorities) {
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

	public List<UserAuthorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<UserAuthorities> authorities) {
		this.authorities = authorities;
	}

	
	
}
