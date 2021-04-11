package org.springframework.springpetclinic.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
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
	
}
