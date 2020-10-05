package br.com.surittec.api.repository;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.surittec.api.repository.entity.Address;

@Component
public class AddressRepository {
    
	public static final String uri = "http://viacep.com.br/ws/%s/json/";
	ObjectMapper mapper = new ObjectMapper();
	
	public AddressRepository() {}
	
	public Address fetch(String zipCode) throws ClientProtocolException, IOException {
		String address_ = Request.Get(String.format(uri, zipCode))
        .connectTimeout(1000)
        .socketTimeout(1000)
        .execute().returnContent().asString();
		return mapper.readValue(address_, Address.class);
	}
}
