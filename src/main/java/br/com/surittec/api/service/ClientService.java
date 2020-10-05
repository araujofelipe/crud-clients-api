package br.com.surittec.api.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.surittec.api.repository.ClientRepository;
import br.com.surittec.api.repository.UserRepository;
import br.com.surittec.api.repository.entity.Client;
import br.com.surittec.api.repository.entity.User;

@Service
@Transactional
public class ClientService {
	
	private final ClientRepository repository;
	private final UserRepository userRepository;
	public ClientService(ClientRepository repository, UserRepository userRepository) {
		this.repository = repository;
		this.userRepository = userRepository;
	}
	
	public List<Client> listAll() {
		return repository.findAll();
	}

	public Client create(Client client, Authentication authentication) {
		// User user = userRepository.findByLogin(authentication.getName());
		// client.setCreatedBy(user);
		client.associatePhones();
		client.associateEmails();
		client.associateAddress();
		return repository.save(client);
	}

	public Client update(Long id, Client client) {
		Client client_ = getOne(id);
		client_.merge(client);
		return repository.save(client_);
	}

	public Long delete(Long id) {
		Client client_ = getOne(id);
		client_.setActive(false);
		repository.save(client_);
		return id;
	}

	public Client getBy(Long id) {
		return getOne(id);
	}
	
	private Client getOne(Long id) {
		try {
			return repository.getOne(id);
		} catch (EntityNotFoundException e) {
			throw(e);
		}
	}
}
