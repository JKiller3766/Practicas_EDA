package airports;

import airports.exceptions.*;
import flyingObjects.Aircraft;

import java.util.*;

public class ListBasedMinimalAirport implements  MinimalAirport {

	/*COMPLETE - Ha d'implementar interface MinimalAirport*/

	private List<Aircraft> infrastructure;
	private List<Flight> scheduledFlights;
	private String airportId;
	
	public ListBasedMinimalAirport ()  {
		airportId = "BCN";
		scheduledFlights = new LinkedList<>();
		infrastructure = new ArrayList<>();
		/*COMPLETE*/
	}

	@Override
	public String getAirportId() {
		return airportId;
	}

	@Override
	public int getCapacity() {
		return Integer.MAX_VALUE;
	}

	@Override
	public int size() {
		return infrastructure.size();
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int getNumFlights() {
		return scheduledFlights.size();
	}

	@Override
	public void land(Aircraft a) {

	}

	@Override
	public void takeOff(Aircraft a) {

	}

	@Override
	public void addFlight(Flight f) {

	}

	@Override
	public void takeOff(Flight f) {

	}

	@Override
	public void land(Flight f) {

	}

	@Override
	public Flight[] byFlightDepartureTime() {
		return new Flight[0];
	}

	@Override
	public Aircraft[] byAircraftName() {
		return new Aircraft[0];
	}

	@Override
	public Aircraft[] allAircrafts() {
		return new Aircraft[0];
	}

	/* COMPLETE */

	
}

class AircraftByNameComparator implements Comparator<Aircraft> {
	
	public AircraftByNameComparator () {}

	public int compare(Aircraft a0, Aircraft a1) {
		/*COMPLETE*/
		return a0.getName().compareTo(a1.getName());
	}
}

