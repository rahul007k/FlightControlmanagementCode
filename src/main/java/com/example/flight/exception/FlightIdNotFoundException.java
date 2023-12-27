package com.example.flight.exception;

public class FlightIdNotFoundException extends RuntimeException{

	
	 public FlightIdNotFoundException(Long id){
		 
		 super("Flight ID Not Found "+id);
	 }

}
