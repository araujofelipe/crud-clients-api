package br.com.surittec.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.surittec.api.repository.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
