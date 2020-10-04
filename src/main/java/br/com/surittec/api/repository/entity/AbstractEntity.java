package br.com.surittec.api.repository.entity;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	protected Instant createdAt;
	
	protected Instant updatedAt;
	
	
	protected Boolean active;
	
	protected User createdBy;
	
	
	public AbstractEntity() {}

	public AbstractEntity(Long id, Instant createdAt, Instant updatedAt, Boolean active, User createdBy) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.active = active;
		this.createdBy = createdBy;
	}



	@PrePersist
	protected void onCreate() {
		this.createdAt = Instant.now();
		this.updatedAt = Instant.now();
		this.active = Boolean.TRUE;
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = Instant.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	
}
