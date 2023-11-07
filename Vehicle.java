package ferry;

/**
 * A vehicle being transported on a ferry.
 */
public class Vehicle {

    private Passenger owner;
    private String size;
    private int weight;

    /**
     * Creates a new vehicle.
     * 
     * @param owner the owner of the vehicle
     * @param size the vehicle's size
     * @param weight the vehicle's weight
     */
    public Vehicle(Passenger owner, String size, int weight) {
        this.owner = owner;
        this.size = size;
        this.weight = weight;
    }

    public Passenger getOwner() {
        return owner;
    }

    public String getSize() {
        return size;
    }
    
    public int getWeight() {
        return weight;
    }

    /**
     * Creates a string of the form "Vehicle Size: ____, Weight: ____, Owner: ____"
     * 
     * @return the formatted string
     */
    @Override
    public String toString() {
        return "Vehicle Size: " + size + ", Weight: " + weight + ", Owner: " + owner.toString();
    }
            
} // end class Vehicle
