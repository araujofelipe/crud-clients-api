package br.com.surittec.api.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import br.com.surittec.api.repository.AddressRepository;
import br.com.surittec.api.repository.entity.Address;

@Service
public class AddressService {
    
    private final AddressRepository repository;
    
    public AddressService(AddressRepository repository) {
		this.repository = repository;
	}
    
    public Address fetch(String zipCode) throws ClientProtocolException, IOException {
    	return repository.fetch(zipCode);
    }
}
