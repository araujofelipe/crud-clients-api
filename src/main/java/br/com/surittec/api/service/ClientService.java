package br.com.surittec.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.surittec.api.repository.ClientRepository;
import br.com.surittec.api.repository.entity.Client;

@Service
public class ClientService {
	
	private final ClientRepository repository;
	
	public ClientService(ClientRepository repository) {
		this.repository = repository;
	}
	
	public List<Client> listAll() {
		return repository.findAll();
	}

	public Client create(Client client) {
		return repository.save(client);
	}

	public Client update(Long id, Client client) {
		Client client_ = repository.getOne(id);
		client_.merge(client);
		return repository.save(client_);
	}

	public Long delete(Long id) {
		Client client_ =  repository.getOne(id);
		client_.setActive(false);
		repository.save(client_);
		return id;
	}
}
