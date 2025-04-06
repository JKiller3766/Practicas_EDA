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
        if (id == null) {
            throw new IllegalArgumentException("id is null");
        } else {
            this.id = id;
        }

        if (aircraft == null) {
            throw new IllegalArgumentException("aircraft is null");
        } else {
            this.aircraft = aircraft;
        }

        if (departure == null || arrival == null) {
            throw new FlightScheduleException("departure or arrival (or both) are null");
        } else {
            this.departure = departure;
            this.arrival = arrival;
        }

        if (origin == null || destination == null) {
            throw new FlightScheduleException("origin or destination (or both) are null");
        } else {
            this.origin = origin;
            this.destination = destination;

        }

        if (departure.after(arrival) || departure.equals(arrival)) {
            throw new FlightScheduleException(" departure date is later than or equal to arrival date");
        }
    }
    /*COMPLETE*/
        public String getID() {
            return  id;
        }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public String getDestination() {
        return destination;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public Date getDepartureTime() {
        return departure;
    }

    @Override
    public Date getArrivalTime() {
        return arrival;
    }

    /**
     * Two flights are equal if their id is the same (case insensitive).
     * @param o
     * @return true if both flights have the same id, false otherwise
     */
    @Override
    public boolean equals(Object o){
        /*COMPLETE*/
        return id.equalsIgnoreCase( ((Flight)o).getID() );
    }


}


