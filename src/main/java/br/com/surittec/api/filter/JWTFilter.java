package br.com.surittec.api.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.surittec.api.service.CustomUserDetailService;
import br.com.surittec.api.util.JWTUtil;

@Component
public class JWTFilter extends OncePerRequestFilter {
	
	private final CustomUserDetailService service;

	private final JWTUtil jwtUtil;
	
	UserDetails userDetails;
	
	public JWTFilter(JWTUtil jwtUtil, CustomUserDetailService service) {
		this.jwtUtil = jwtUtil;
		this.service = service;	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		
		String authorizationHeader  = request.getHeader("Authorization");
		
		String login = null;
		String token = null;
				
		if(authorizationHeader != null  && authorizationHeader.startsWith("Bearer ")) {
			token = authorizationHeader.substring("Bearer".length()).trim();
			login = jwtUtil.login(token);
		}
		
		if (login != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = service.loadUserByUsername(login);

            if (jwtUtil.validateToken(token, userDetails)) {

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
		
		response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		response.addHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
		 if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
	            response.setStatus(HttpStatus.ACCEPTED.value());
	            return;
		 }

		filterChain.doFilter(request, response);
	}
}
