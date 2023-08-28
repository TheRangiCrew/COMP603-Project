package ResortProject.RentalEquipment;

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

public class Equipment implements Comparable<Equipment> {

    private String name;
    private String size;
    private int available;

    /**
     * @param name
     * @param size
     * @param available
     */
    public Equipment(String name, String size, int available) {

        this.name = name;
        this.size = size;
        this.available = available;
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
    public int getAvailable() {
        return available;
    }
    
    public boolean isAvailable() {
        return this.available > 0;
    }

    /**
     * @param available
     */
    public void setAvailable(int available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return this.name + "  " + this.size + "  " + (this.isAvailable() ? "Available" : "Unavailable");
    }
    
    @Override
    public int compareTo(Equipment equipment) {
        try {
            return Integer.compare(Integer.parseInt(this.size), Integer.parseInt(equipment.size));
        } catch(NumberFormatException e) {
            return 404;
        }  
    }
}

class Skis extends Equipment {

    private RideType rideType; // all mountain / freeride / park / On piste

    /**
     * 
     * @param size
     * @param available
     * @param rideType
     */
    public Skis(String size, int available, RideType rideType) {
        super(rideType.toString() + " Skis", size, available); // e.g. All Mountain Skis, Freeride Skis
        this.rideType = rideType;
    }

    /**
     * @return the rideType
     */
    public RideType getRideType() {
        return rideType;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Snowboard extends Equipment {

    private RideType rideType; // All mountain / freeride / park / on piste

    public Snowboard(String size, int available, RideType rideType) {
        super(rideType.toString() + " Snowboard", size, available);
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

    public Boots(String size, int available, BootType bootType) {
        super(bootType.equals(BootType.SKI) ? "Ski Boot" : "Snowboard Boot", size, available);
        this.bootType = bootType;
    }

    /**
     * @return the bootType
     */
    public BootType getBootType() {
        return bootType;
    }
}

class Clothing extends Equipment {

    private String gender; // male or female style/fit

    public Clothing(String name, String size, int available, String gender) {
        super(name, size, available);
        this.gender = gender;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
}
