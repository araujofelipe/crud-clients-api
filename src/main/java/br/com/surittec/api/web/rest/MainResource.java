package br.com.surittec.api.web.rest;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.surittec.api.repository.entity.domain.UserAuth;
import br.com.surittec.api.util.JWTUtil;

@RestController
@RequestMapping("/api/auth")
public class MainResource {
	
	
	private final AuthenticationManager authenticationManager;
	private final JWTUtil jwtUtil;
	
	public MainResource(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
   }
	
	@PostMapping
	public String generateJWTToken(@RequestBody UserAuth userAuth) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userAuth.getLogin(), userAuth.getPassword()));
		}catch (Exception e) {
			throw new Exception("Login ou senhas inválido");
		}
		return jwtUtil.generateToken(userAuth.getLogin());
	}
	
}
