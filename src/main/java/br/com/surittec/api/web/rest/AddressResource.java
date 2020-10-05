package br.com.surittec.api.web.rest;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.surittec.api.repository.entity.Address;
import br.com.surittec.api.service.AddressService;


@RestController
@RequestMapping("/api/address")
public class AddressResource {
	
	
	private final AddressService service;
	
	public AddressResource(AddressService service) {
		this.service = service;
	}
	
	@GetMapping("/{zipCode}")
	public ResponseEntity<Address> fetch(@PathVariable(name = "zipCode") String zipCode) throws ClientProtocolException, IOException {
		return ResponseEntity.ok(service.fetch(zipCode));
	}
}	
