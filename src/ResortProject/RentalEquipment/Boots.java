package ResortProject.RentalEquipment;

import java.util.InputMismatchException;

/**
 * Boots extended from Equipment
 * 
 * @see Equipment
 */
public class Boots extends Equipment {

    private BootType bootType; // Ski boots or board boots

    /**
     * 
     * @param size      the size in show sizes
     * @param available available quantity
     * @param bootType  boot type
     * @see BootType
     */
    public Boots(String size, int available, BootType bootType) {
        super(bootType.equals(BootType.SKI) ? "Ski Boot" : "Snowboard Boot", size, available, "boot");
        this.bootType = bootType;
    }

    /**
     * @return the bootType
     */
    public BootType getBootType() {
        return bootType;
    }

    /**
     * 
     * @return boot size as an integer
     */
    public int getIntSize() {
        try {
            return Integer.parseInt(getSize());
        } catch (InputMismatchException e) {
            return 0;
        }
    }
}
