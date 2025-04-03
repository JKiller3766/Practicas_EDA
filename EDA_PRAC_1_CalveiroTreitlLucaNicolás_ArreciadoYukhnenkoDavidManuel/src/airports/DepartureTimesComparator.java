package airports;

import java.util.Comparator;
import java.util.Date;

public class DepartureTimesComparator implements Comparator<ScheduledTravel> {

    /*TODO: Make sure that it implements interface Comparator based on ScheduledTravel*/

    /*COMPLETE with compare method*/


    @Override
    public int compare(ScheduledTravel o1, ScheduledTravel o2) {
        return o1.getDepartureTime().compareTo(o2.getDepartureTime());
    }
}
