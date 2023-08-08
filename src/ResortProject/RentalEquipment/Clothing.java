package ResortProject.RentalEquipment;

import java.util.UUID;

/**
 *
 * @author ryanz
 */
class Clothing extends Equipment {
    private String gender; // male or female style/fit

    public Clothing( String name, String size, boolean available, String gender) {
        super(name, size, available);
        this.gender = gender;
    }
    
    public Clothing( UUID id, String name, String size, boolean available, String gender) {
        super(id, name, size, available);
        this.gender = gender;
    }
    
    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }
}

class SnowJacket extends Clothing{

    public SnowJacket( String size, boolean available, String gender) {
        super("Snow Jacket", size, available, gender);
    }
    
    public SnowJacket( UUID id, String size, boolean available, String gender) {
        super(id, "Snow Jacket", size, available, gender);
    }
}

class SnowPants extends Clothing {

    public SnowPants(String size, boolean available, String gender) {
        super("Snow Pants", size, available, gender);
    }

    public SnowPants(UUID id, String size, boolean available, String gender) {
        super(id, "Snow Pants", size, available, gender);
    }
}

class ChildSnowSuit extends Clothing {

    public ChildSnowSuit(String size, boolean available, String gender) {
        super("Child Snow Suit", size, available, gender);
    }

    public ChildSnowSuit(UUID id, String size, boolean available, String gender) {
        super(id, "Child Snow Suit", size, available, gender);
    }
}