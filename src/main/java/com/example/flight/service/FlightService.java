package com.example.flight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.flight.entity.Flight;
import com.example.flight.exception.FlightIdNotFoundException;
import com.example.flight.repositories.FlightRepository;

@Service
public class FlightService  {

	@Autowired
	public FlightRepository flightRepository;
	
	
	public Flight SaveFlightDetails(Flight flight) {
		return flightRepository.save(flight);
		
	}
	
	public List<Flight> getAllFlightDetails(){
		
		return flightRepository.findAll();
	}

	public Flight getFlightById(Long id){
		return flightRepository.findById(id).orElseThrow(()-> new FlightIdNotFoundException(id));
				
	}
	
	public Flight updateFlightDetails(Flight newflight, Long id) {
		
		return flightRepository.findById(id)
				.map(flight->{
					flight.setFlightId(newflight.getFlightId());
					flight.setDestination(newflight.getDestination());
					flight.setOrigin(newflight.getOrigin());
					return flightRepository.save(flight);
				})
				.orElseGet(()->{
					newflight.setId(id);
					return flightRepository.save(newflight);
				});
	}

	public void deleteFlight(Long id) {
	
		flightRepository.deleteById(id);
		}
	
	

	
}
