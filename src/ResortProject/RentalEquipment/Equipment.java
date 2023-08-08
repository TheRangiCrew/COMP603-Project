package ResortProject.RentalEquipment;

import java.util.UUID;

enum RideType {
    ALL_MOUNTAIN("All Mountain"),
    FREERIDE("Freeride"),
    PARK("Park"),
    ON_PISTE("On Piste");

    private String name;

    RideType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

enum BootType {
    SKI("Ski"),
    SNOWBOARD("Snowboard");

    private String name;

    BootType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

public class Equipment {

    private UUID id;
    private String name;
    private String size;
    private boolean available;

    /**
     * ID is randomly generated unless provided
     *
     * @param name
     * @param size
     * @param available
     */
    public Equipment(String name, String size, boolean available) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.size = size;
        this.available = available;
    }

    /**
     *
     * @param id
     * @param name
     * @param size
     * @param available
     */
    public Equipment(UUID id, String name, String size, boolean available) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.available = available;
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the size
     */
    public String getSize() {
        return this.size;
    }

    /**
     * @return the availability
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return this.name + "  " + this.size + "  " + (this.available ? "Available" : "Unavailable");
    }

}

class Skis extends Equipment {

    private RideType rideType; // all mountain / freeride / park / On piste
    private boolean skiPoles; // If poles were included

    public Skis(String size, boolean available, RideType rideType, boolean skiPoles) {
        super(rideType.toString() + " Skis", size, available); // e.g. All Mountain Skis, Freeride Skis
        this.rideType = rideType;
        this.skiPoles = skiPoles;
    }

    public Skis(UUID id, String size, boolean available, RideType rideType, boolean skiPoles) {
        super(id, rideType.toString() + " Skis", size, available);
        this.rideType = rideType;
        this.skiPoles = skiPoles;
    }

    /**
     * @return the rideType
     */
    public RideType getRideType() {
        return rideType;
    }

    /**
     * @return True if ski poles are included, false otherwise
     */
    public boolean hasSkiPoles() {
        return skiPoles;
    }

    /**
     * @param skiPoles
     */
    public void setSkiPoles(boolean skiPoles) {
        this.skiPoles = skiPoles;
    }

    @Override
    public String toString() {
        return super.toString() + "  " + (this.skiPoles ? "  w/ poles" : "");
    }

}

class Snowboard extends Equipment {

    private RideType rideType; // All mountain / freeride / park / on piste

    public Snowboard(String size, boolean available, RideType rideType) {
        super(rideType.toString() + " Snowboard", size, available);
        this.rideType = rideType;
    }

    public Snowboard(UUID id, String size, boolean available, RideType rideType) {
        super(id, rideType.toString() + " Snowboard", size, available);
        this.rideType = rideType;
    }

    /**
     * @return the rideType
     */
    public RideType getRideType() {
        return rideType;
    }

}

class Boots extends Equipment {

    private BootType bootType; // Ski boots or board boots

    public Boots(BootType bootType, String size, boolean available) {
        super(bootType.equals(BootType.SKI) ? "Ski Boot" : "Snowboard Boot", size, available);
        this.bootType = bootType;

    }

    public Boots(UUID id, BootType bootType, String size, boolean available) {
        super(id, bootType.equals(BootType.SKI) ? "Ski Boot" : "Snowboard Boot", size, available);
        this.bootType = bootType;

    }

    /**
     * @return the bootType
     */
    public BootType getBootType() {
        return bootType;
    }

}

class Tabogan extends Equipment {
    
    public Tabogan(String size, boolean available) {
        super("Tabogan", size, available);
    }
    
    public Tabogan(UUID id, String size, boolean available) {
        super(id, "Tabogan", size, available);
    }
}
