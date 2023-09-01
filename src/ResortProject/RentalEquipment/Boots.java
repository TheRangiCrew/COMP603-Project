package ResortProject.RentalEquipment;

import java.util.InputMismatchException;

public class Boots extends Equipment {

    private BootType bootType; // Ski boots or board boots

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

    public int getIntSize() {
        try {
            return Integer.parseInt(getSize());
        } catch (InputMismatchException e) {
            return 0;
        }
    }
}