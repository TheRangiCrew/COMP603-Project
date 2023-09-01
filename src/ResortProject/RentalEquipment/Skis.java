package ResortProject.RentalEquipment;

import java.util.InputMismatchException;

/**
 * Skis extended from Equipment
 * 
 * @see Equipment
 */
public class Skis extends Equipment {

    private RideType rideType; // all mountain / freeride / park / On piste

    /**
     * 
     * @param size      size in centimeters
     * @param available available quantity
     * @param rideType  the ride type
     * @see RideType
     */
    public Skis(String size, int available, RideType rideType) {
        super(rideType.toString() + " Skis", size, available, "ski"); // e.g. All Mountain Skis, Freeride Skis
        this.rideType = rideType;
    }

    /**
     * @return the rideType
     * @see RideType
     */
    public RideType getRideType() {
        return rideType;
    }

    /**
     * 
     * @return size in centimeters
     */
    public int getIntSize() {
        try {
            return Integer.parseInt(getSize());
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    /**
     * @return string representation of the skis
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
