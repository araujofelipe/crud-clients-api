package br.com.surittec;

import java.util.Arrays;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.surittec.api.repository.UserRepository;
import br.com.surittec.api.repository.entity.User;
import br.com.surittec.api.repository.entity.User.Authority;
import br.com.surittec.api.repository.entity.UserAuthorities;

@SpringBootApplication
public class CrudClientApiApplication {

	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudClientApiApplication.class, args);
	}
	
	@Bean
	public  WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
		    public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
		        .allowedOrigins("*")
		        .allowedHeaders("*")
		        .allowedMethods("POST", "GET", "OPTIONS", "DELETE", "PUT")
		        .exposedHeaders(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, HttpHeaders.AUTHORIZATION)
		        .allowCredentials(true);
		    }
		};
	}
	
	@PostConstruct
	public void feedUsers() {
		
		List<User> users = Stream.of(
				new User("admin", "123456", Arrays.asList( new UserAuthorities(Authority.Admin)).stream().collect(Collectors.toList())),
				new User("comum", "123456", Arrays.asList( new UserAuthorities(Authority.Common)).stream().collect(Collectors.toList()))
				).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

}
