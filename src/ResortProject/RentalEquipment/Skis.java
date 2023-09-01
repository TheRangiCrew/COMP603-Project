package ResortProject.RentalEquipment;

import java.util.InputMismatchException;

public class Skis extends Equipment {

    private RideType rideType; // all mountain / freeride / park / On piste

    /**
     * 
     * @param size
     * @param available
     * @param rideType
     */
    public Skis(String size, int available, RideType rideType) {
        super(rideType.toString() + " Skis", size, available, "ski"); // e.g. All Mountain Skis, Freeride Skis
        this.rideType = rideType;
    }

    /**
     * @return the rideType
     */
    public RideType getRideType() {
        return rideType;
    }

    public int getIntSize() {
        try {
            return Integer.parseInt(getSize());
        } catch (InputMismatchException e) {
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
