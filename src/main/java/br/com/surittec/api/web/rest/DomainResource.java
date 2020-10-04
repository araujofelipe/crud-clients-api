package br.com.surittec.api.web.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.surittec.api.repository.entity.Address.State;
import br.com.surittec.api.repository.entity.Phone.PhoneType;

@RestController
@RequestMapping("/api/domains")
public class DomainResource {
	
	@GetMapping("/states")
	public ResponseEntity<List<State>> ufs() {
		return ResponseEntity.ok(Arrays.asList(State.values()));
	}
	
	@GetMapping("/phone-types")
	public ResponseEntity<List<PhoneType>> phoneTypes () {
		return ResponseEntity.ok(Arrays.asList(PhoneType.values()));
	}

}
