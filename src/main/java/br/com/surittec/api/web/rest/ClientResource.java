package br.com.surittec.api.web.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.surittec.api.repository.entity.Client;
import br.com.surittec.api.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientResource {
	
	private final ClientService service;
	
	public ClientResource(ClientService service) {
		this.service = service;}
	
	@GetMapping
	public ResponseEntity<List<Client>> all() {
		return ResponseEntity.ok(service.listAll());
	}
	
	@PostMapping
	@Secured("ROLE_ADMIN")
	public ResponseEntity<Client> add(Authentication authentication, @RequestBody @Validated Client client) {
		return ResponseEntity.ok(service.create(client));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Client> update(@PathVariable("id") Long id, @RequestBody Client client) {
		return ResponseEntity.ok(service.update(id, client));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> delete(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.delete(id));
	}
	
	@GetMapping("/{id}/detail")
	public ResponseEntity<Client> detail(@PathVariable("id") Long id) {
		return ResponseEntity.ok(service.getBy(id));
	}
}
