package br.com.surittec.api.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Component
public class CustomUserDetails extends User {
	
	private static final long serialVersionUID = 7781005001789692481L;
	
	public CustomUserDetails() {
		super("unlogged","secret", new ArrayList<>());
	}
	
	public CustomUserDetails(String login, String password, Collection<? extends GrantedAuthority> authorities) {
		super(login, password, true, true, true, true, authorities);
	}
	
	public CustomUserDetails(String login, String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(login, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}
		
	public String toJson() throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(this);
		return json;
	}

}
