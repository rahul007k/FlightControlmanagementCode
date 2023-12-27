package com.example.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.flight.entity.Flight;
import com.example.flight.service.FlightService;

@RestController
public class FlightController {

	@Autowired
	private FlightService flightService;
	
	@PostMapping("/save")
	public Flight SaveFlight(@RequestBody Flight flight) {
		return flightService.SaveFlightDetails(flight);
		
	}
	
	@GetMapping("/getAll")
	public List<Flight> SearchFlightDetails(){
		return flightService.getAllFlightDetails();
		
	}
	
	@PutMapping("/edit/{id}")
	public Flight editFlightDetails(@RequestBody Flight newflight,@PathVariable Long id) {
		
		return flightService.updateFlightDetails(newflight, id);
	}
	
	@GetMapping("/getflight/{id}")
	public Flight getFlightId(@PathVariable Long id) {
		return flightService.getFlightById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteFlightDetails(@PathVariable Long id) {
		
		flightService.deleteFlight(id);
	}
}
