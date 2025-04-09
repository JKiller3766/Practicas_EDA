package airports;

import airports.exceptions.*;
import flyingObjects.Aircraft;

import java.util.*;
import java.util.stream.Collector;

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
		return size() == 0;
	}

	@Override
	public int getNumFlights() {
		return scheduledFlights.size();
	}

	@Override
	public void land(Aircraft a) {
		if(a == null) throw new NullPointerException("The aircraft is null");
		else if(isFull()) throw new FullAirportException("Airport is full");
		else if(infrastructure.contains(a)) throw new AlreadyInAirportException("Airplane already on the airport");
		else infrastructure.add(a);
	}

	@Override
	public void takeOff(Aircraft a) {
		if (a == null) throw new NullPointerException("Aircraft is null");
		if(!infrastructure.contains(a)) throw new NotInAirportException("Airplane is not on the airport");
		infrastructure.remove(a);
	}

	@Override
	public void addFlight(Flight f) {
		if (f == null) throw new NullPointerException("Flight is null");
		if (!(f.getOrigin().equals(airportId) || f.getDestination().equals(airportId))) throw new FlightScheduleException("Flight does not depart from or arrives at the airport");
		if(scheduledFlights.contains(f)) throw new FlightAlreadyExistsException();
		scheduledFlights.add(f);
	}

	@Override
	public void takeOff(Flight f) {
		if (f == null) throw new NullPointerException("Flight is null");
		if(!scheduledFlights.contains(f)) throw new NotInAirportException("Flight is not registered in the airport");
		if(!f.getOrigin().equals(airportId)) throw new FlightScheduleException("Flight does not depart from the current airport");
		if(!scheduledFlights.remove(f)) throw new FlightScheduleException("Flight can not be removed");
		infrastructure.remove(f.getAircraft());
	}

	@Override
	public void land(Flight f) {
		if (f == null) throw new NullPointerException("Flight is null");
		if(!scheduledFlights.contains(f)) throw new NotInAirportException("Flight is not registered in the airport");
		if(!f.getOrigin().equals(airportId)) throw new FlightScheduleException("Flight does not depart from the current airport");
		if(!scheduledFlights.add(f)) throw new FlightScheduleException("Flight is not at the airport");

	}

	@Override
	public Flight[] byFlightDepartureTime() {
		Flight[] byFlightDepartureTime = scheduledFlights.toArray(new Flight[0]);
		Arrays.sort(byFlightDepartureTime, new DepartureTimesComparator());
		return byFlightDepartureTime;
	}

	@Override
	public Aircraft[] byAircraftName() {
		Aircraft[] byAircraftName = infrastructure.toArray(new Aircraft[0]);
		Arrays.sort(byAircraftName, new AircraftByNameComparator());
		return byAircraftName;
	}

	@Override
	public Aircraft[] allAircrafts() {
		Aircraft[] allAircrafts = infrastructure.toArray(new Aircraft[0]);
		Arrays.sort(allAircrafts);
		return allAircrafts;
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

