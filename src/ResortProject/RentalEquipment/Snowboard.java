package ResortProject.RentalEquipment;

import java.util.InputMismatchException;

public class Snowboard extends Equipment {

    private RideType rideType; // All mountain / freeride / park / on piste

    public Snowboard(String size, int available, RideType rideType) {
        super(rideType.toString() + " Snowboard", size, available, "snowboard");
        this.rideType = rideType;
    }

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
