package airports;

import airports.exceptions.FlightScheduleException;
import flyingObjects.Aircraft;

import java.util.Date;

public class Flight {
    /*TODO: Ensure that flight implements interface ScheduledTravel*/

    private String id;
    private String origin;
    private String destination;
    private Aircraft aircraft;
    private Date departure;
    private Date arrival;


    /**
     * Creates a flight with the given parameters. Throws the following exceptions:
     * - IllegalArgumentException if id is null
     * - IllegalArgumentException if aircraft is null
     * - FlightScheduleException if either departure or arrival (or both) are null
     * - FlightScheduleException if either origin or destination (or both) are null
     * - FlightScheduleException if departure date is later than or equal to arrival date
     * Ensure that the exceptions include a relevant message informing of the error
     * @param id
     * @param aircraft
     * @param origin
     * @param destination
     * @param departure
     * @param arrival
     */

    public Flight(String id, Aircraft aircraft, String origin, String destination, Date departure, Date arrival){
        /*COMPLETE*/
        if (id == null){
            throw new IllegalArgumentException("id is null");
        } else {
            this.id = id;
        }

        if (aircraft == null){
            throw new IllegalArgumentException("aircraft is null");
        } else {
            this.aircraft = aircraft;
        }

        if (departure == null || arrival == null){
            throw new FlightScheduleException("departure or arrival (or both) are null");
        } else {
            this.departure = departure;
            this.arrival = arrival;
        }

        if (origin == null || destination == null){
            throw new FlightScheduleException("origin or destination (or both) are null");
        } else {
            this.origin = origin;
            this.destination = destination;

        }

        if (departure.getDate() >= arrival.getDate()){
            throw new FlightScheduleException(" departure date is later than or equal to\n" +
                    " arrival date");
        } else {
            this.id = id;
        }
    }

    public String getAirportId(){
        return id;
    }
    public int getCapacity (){
        return -1;

    }

    public int size(){
        return -1;
    }

    public boolean isFull(){
        return false;
    }

    public boolean isEmpty(){
        return false;
    }

    public int getNumFlights(){
        return -1;
    }


    public void land (Aircraft a){
        if (a == null){
            throw new NullPointerException("the parameter is null");
        } else {
            
        }
    }
	/* When an aircraft lands, it is stored in the airport. This method throws
	   - a NullPointerException if the parameter is null
	   - an AlreadyInAirportException  if the airport already contains the same aircraft
	   - a FullAirportException if the airport is full
	 */


    public void takeOff (Aircraft a){
    }
	/* When an aircraft takes off, it is removed from the airport. This method throws
	   - NullPointerException if the parameter is null
	   - NotInAirportException if the airport does not contain the aircraft
	 */


    public void addFlight(Flight f){
    }
	/* Adds a flight to the airport. This method throws
	   - NullPointerException if the parameter is null
	   - FlightScheduleException if the flight does not depart from or arrives at the airport
	   - FlightAlreadyExistsException if the airport already contains the flight
	 */

    public void takeOff (Flight f){
    }
	/* When a flight takes off, it is removed from the airport. The flight's aircraft is also removed from the airport. This method throws:
	  - NullPointerException if the parameter is null
	  - NotInAirportException if flight has not been registered in the airport
	  - FlightScheduleException if the flight does not depart (the flight's origin) from the current airport
	  - FlightScheduleException if the aircraft cannot be removed from the airport
	 */

    public void land (Flight f){
    }
	/* When a flight lands, it is removed from the airport. The flight's aircraft is added to the airport. This method throws:
	   - a NullPointerException if the parameter is null
	   - NotInAirportException if flight has not been registered in the airport
	   - FlightScheduleException if the flight does not arrive (destination) at the current airport
	   - FlightScheduleException if the aircraft cannot be added to the airport
	 */

    public Flight [] byFlightDepartureTime(){
        return null;
    }
	/* Returns an array containing all the flights in the airport.
	   This array:
	   - has the exact length (no empty –null- positions)
	   - has length 0 if there are no flights
	   - is sorted by flight departure time
	 */

    public Aircraft [] byAircraftName(){
        return null;
    }
	/* Returns an array containing all the aircrafts in the airport.
	   This array:
	   - has the exact length (no empty –null- positions)
	   - has length 0 if there are no aircrafts
	   - is sorted by aircraft name (ascending, lexicographically, case sensitive). Aircrafts without name go first
	 */


    public Aircraft [] allAircrafts (){
        return null;
    }
	/* Returns an array containing all the aircrafts in the airport
	   This array:
	   - has the exact length (no empty –null- positions)
	   - has length 0 if the airport is empty
	   - is sorted according to the natural ordering of the aircrafts (ascending)
	 */


    /*COMPLETE*/

    /**
     * Two flights are equal if their id is the same (case insensitive).
     * @param o
     * @return true if both flights have the same id, false otherwise
     */
    @Override
    public boolean equals(Object o){
        /*COMPLETE*/
        return false; //Change as appropriate
    }


}


