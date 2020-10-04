package br.com.surittec.api.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "app_user")
public class User extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
}
