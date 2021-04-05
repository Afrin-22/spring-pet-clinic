package org.springframework.springpetclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="visits")
public class Visit extends BaseEntity{
	
	@Column(name="local_date")
	private LocalDate localDate;
	
	@Column(name="description")
	private String description;

	@ManyToOne
	@JoinColumn(name="pet_id")
	private Pet pet;
	
	public LocalDate getLocalDate() {
		return localDate;
	}
	public String getDescription() {
		return description;
	}
	public Pet getPet() {
		return pet;
	}
	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
}
