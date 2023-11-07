package ferry;

/**
 * A passenger on a ferry.
 */
public class Passenger {

    private int id;
    private SimpleDate dateOfBirth;

    /**
     * Creates a new passenger.
     * 
     * @param id the ID of this passenger
     * @param dateOfBirth the date of birth of this passenger
     */
    public Passenger(int id, SimpleDate dateOfBirth) {
        this.id = id;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public SimpleDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Creates a string of the form "ID: ____, Date of Birth: ____"
     * 
     * @return the formatted string
     */
    @Override
    public String toString() {
        return "{ID: " + id + ", Date of Birth: " + dateOfBirth +"}";
    }
    
} // end class Passenger
