package br.com.surittec.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.surittec.api.repository.UserRepository;
import br.com.surittec.api.repository.entity.User;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	private final UserRepository repository;
	
	public CustomUserDetailService(UserRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByLogin(username);
		List<GrantedAuthority> authorities =
		user
			.getAuthorities()
			.stream()
			.map(authority -> new GrantedAuthority() {
				private static final long serialVersionUID = 1L;
				@Override
				public String getAuthority() {
					return authority.getAuthority().getAuthority();
				}
			})
			.collect(Collectors.toList());
		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), authorities); 
	}
}
