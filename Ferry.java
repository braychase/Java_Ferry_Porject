package ferry;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * A ferry that transports vehicles and people.
 */
public class Ferry {

    private String name;
    private Passenger[] passengers;
    private Vehicle[] normalVehicles;
    private Vehicle[] largeVehicles;

    public Ferry(String name, int passengerSpaces, int normalVehicleSpaces, int largeVehicleSpaces) {

        // TODO-A1: YOUR CODE HERE
        this.name = name;
        this.passengers = new Passenger[passengerSpaces];
        this.normalVehicles = new Vehicle[normalVehicleSpaces];
        this.largeVehicles = new Vehicle[largeVehicleSpaces];
        
    }

    /**
     * Creates a string containing information about this ferry. The string has 
     * the following form:
     * 
     * ***** Status Report for Ferry ____ *****
     * Passengers: ____             Weight: ____
     * Normal-Size Vehicles: ____   Weight: ____
     * Large-Size Vehicles: ____    Weight: ____
     *                        Total Weight: ____
     * 
     * @return the reportStatus string
     */
    public String reportStatus() {
        // TODO-A2: YOUR CODE HERE
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.getDefault());
        int wPassengers = calculateTotalPassengerWeight(passengers);
        int wNormal = calculateTotalVehicleWeight(normalVehicles);
        int wLarge = calculateTotalVehicleWeight(largeVehicles);
        int totalWeight = wPassengers + wNormal + wLarge;
        
        String wPassengersFormatted = numberFormat.format(wPassengers);
        String wNormalFormatted = numberFormat.format(wNormal);
        String wLargeFormatted = numberFormat.format(wLarge);
        String totalWeightFormatted = numberFormat.format(totalWeight);
        
        String res = "***** Status Report for Ferry '" + name + "' ***** \n";
        res += "Passengers:\t\t" + passengers.length + "\tWeight:\t" + wPassengersFormatted + "\n";
        res += "Normal-Size Vehicles:\t" + normalVehicles.length + "\tWeight:\t" + wNormalFormatted + "\n";
        res += "Large-Size Vehicles:\t" + largeVehicles.length + "\tWeight:\t" + wLargeFormatted + "\n";
        res += "\t\t\tTotal Weight:\t" + totalWeightFormatted + "\n";
        return res;
    }
    private int calculateTotalPassengerWeight(Passenger[] passengers) {
        int totalWeight = 0;
        for (Passenger p : passengers) {
            if (p != null) {
                totalWeight += Constants.AVERAGE_PASSENGER_WEIGHT;
            }
        }
        return totalWeight;
    }
    private int calculateTotalVehicleWeight(Vehicle[] vehicles) {
        int totalWeight = 0;
        for (Vehicle v : vehicles) {
            if (v != null) {
                totalWeight += v.getWeight();
            }
        }
        return totalWeight;
    }
    
    public String loadPassenger(Passenger p) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {
                passengers[i] = p;
                return Constants.OK;
            }
        }
        return Constants.ERROR + ": Cannot load passenger " + p.getId() + " - no more passenger spaces!";
    }

    public String loadVehicle(Vehicle v) {
        String res = "";
        int occupiedPassengerSpaces = 0;
        for (Passenger p : passengers) {
            if (p != null) {
                occupiedPassengerSpaces++;
            }
        }

        if (occupiedPassengerSpaces >= passengers.length) {
            res = Constants.ERROR + ": Cannot load vehicle belonging to owner " + v.getOwner().getId() + " - no more passenger spaces!";
            return res;
        }
        if (loadPassenger(v.getOwner()).equals(Constants.ERROR)) {
            return Constants.ERROR;
        }

        boolean loaded = false;

        if (v.getSize().equals(Constants.NORMAL_SIZE)) {
            for (int i = 0; i < normalVehicles.length; i++) {
                if (normalVehicles[i] == null) {
                    normalVehicles[i] = v;
                    return Constants.OK;
                }
            }
        } else if (v.getSize().equals(Constants.LARGE_SIZE)) {
            for (int i = 0; i < largeVehicles.length; i++) {
                if (largeVehicles[i] == null) {
                    largeVehicles[i] = v;
                    return Constants.OK;
                }
            }
        }
        unloadPassenger(v.getOwner());
        return Constants.ERROR + ": Cannot load vehicle belonging to owner " + v.getOwner().getId() + " - no more " + v.getSize() + " vehicle spaces!";
    }
    private void unloadPassenger(Passenger p) {
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] != null && passengers[i].equals(p)) {
                passengers[i] = null;
                break;
            }
        }
    }
    
    public Passenger[] getPassengers() {
        return passengers;
    }

    public Vehicle[] getNormalVehicles() {
        return normalVehicles;
    }

    public Vehicle[] getLargeVehicles() {
        return largeVehicles;
    }
    
} // end class Ferry
