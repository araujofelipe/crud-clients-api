package br.com.surittec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CrudClientApiApplication {

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
		        .allowedMethods("*")
		        .exposedHeaders(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, HttpHeaders.AUTHORIZATION)
		        .allowCredentials(true);
		    }
		};
	}

}
