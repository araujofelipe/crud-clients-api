package br.com.surittec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.surittec.api.repository.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByLogin(String login);
	
}
