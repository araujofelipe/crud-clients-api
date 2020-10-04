package br.com.surittec.api.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.surittec.api.service.CustomUserDetailService;
import br.com.surittec.api.service.CustomUserDetails;

public class JWTFilter extends OncePerRequestFilter {
	
	@Autowired
	CustomUserDetailService service;
	
	CustomUserDetails userDetails;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader  = request.getHeader("Authorization");
		if(authorizationHeader == null) {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.addHeader(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"Access to staging site\"");
			response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
			return;
		}
		
		if(authorizationHeader != null) {
			String token = authorizationHeader.substring("Basic".length()).trim();
			byte[] tokenDecodificado = Base64.getDecoder().decode(token);
			String credenciais = new String(tokenDecodificado, StandardCharsets.UTF_8);
			final String[] valores = credenciais.split(":", 2);
			userDetails = service.loadUserByUsername(valores[0]);
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}
		response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		filterChain.doFilter(request, response);
	}
}
