package airports;

import airports.exceptions.FlightScheduleException;
import flyingObjects.Aircraft;

import java.util.Date;

public class Flight implements  ScheduledTravel {
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
    public Flight(String id, Aircraft aircraft, String origin, String destination, Date departure, Date arrival) {
        /*COMPLETE*/
        if (id == null || aircraft == null) throw new IllegalArgumentException("id or aircraft is null");
        if(departure == null || arrival == null) throw new FlightScheduleException("departure or arrival is null");
        if(destination == null || origin == null)  throw new FlightScheduleException("destination or origin is null");
        if(departure.getTime()<=arrival.getTime()) throw new FlightScheduleException("departure time can't be later than the arrival time");

        this.id = id;
        this.aircraft = aircraft;
        this.origin = origin;
        this.destination = destination;
        this.departure = departure;
        this.arrival = arrival;
    }

    /*COMPLETE*/
    public String getId(){
        return id;
    }
    public Aircraft getAircraft(){
        return aircraft;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDestination(){
        return destination;
    }
    /**
     * Two flights are equal if their id is the same (case insensitive).
     * @param
     * @return true if both flights have the same id, false otherwise
     */
    @Override
    public boolean equals(Object o){
        /*COMPLETE*/
        return id.equalsIgnoreCase(((Flight)o).getId()); //Change as appropriate
    }


    @Override
    public Date getDepartureTime() {
        return departure;
    }

    @Override
    public Date getArrivalTime() {
        return arrival;
    }
}


