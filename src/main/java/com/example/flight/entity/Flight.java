package com.example.flight.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String flightId;
	
	@Column
	private String origin;
	
	@Column
	private String destination;

	
	public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Flight))
	      return false;
	    Flight flight = (Flight) o;
	    return Objects.equals(this.id, flight.id) && Objects.equals(this.flightId, flight.flightId)
	    && Objects.equals(this.origin, flight.origin)
	     && Objects.equals(this.destination, flight.destination);
	  }
	
	
	
}
