package ResortProject.RentalEquipment;

import java.util.InputMismatchException;

/**
 * Snowboard extended from Equipment
 * 
 * @see Equipment
 */
public class Snowboard extends Equipment {

    private RideType rideType; // All mountain / freeride / park / on piste

    /**
     * 
     * @param size      the size of the snowboard in centimeters as an integer
     * @param available available quantity
     * @param rideType  ride type
     * @see RideType
     */
    public Snowboard(String size, int available, RideType rideType) {
        super(rideType.toString() + " Snowboard", size, available, "snowboard");
        this.rideType = rideType;
    }

    /**
     * 
     * @return the size of the snowboard in centimeters as an integer
     */
    public int getIntSize() {
        try {
            return Integer.parseInt(getSize());
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    /**
     * @return the rideType
     */
    public RideType getRideType() {
        return rideType;
    }
}
