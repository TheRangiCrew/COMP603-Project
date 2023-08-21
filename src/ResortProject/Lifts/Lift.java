package ResortProject.Lifts;

import java.time.LocalTime;
import java.util.UUID;

public class Lift {

    Lift() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    static enum LiftType {
        CHAIRLIFT_FIXED_GRIP, // Express lifts...
        CHAIRLIFT_DETACHABLE, // Slow regular chairlift
        T_BAR,
        J_BAR, // Poma
        CONVEYOR, // Magic Carpet
        ROPE_TOW,
        GONDOLA;
    }

    public static enum LiftStatus {
        CLOSED("CLOSED"),
        OPEN("OPEN"),
        WIND_HOLD("WIND HOLD");
        
        private String name;
        
        private LiftStatus(String name) {
            this.name = name;
        }
        
        @Override
        public String toString() {
            return this.name;
        }
    }

    private UUID id;
    private int length; // Length in metres
    private int capacity; // Capcity per chair/gondola
    private LiftType type; // See above
    private String name; // Name
    private LocalTime openingTime; // Opening time in 24 hour time
    private LocalTime closingTime; // Closing time in 24 hour time
    private LiftStatus status; // See above (e.g. CLOSED, OPEN, WIND_HOLD

    /**
     *
     * @param length
     * @param capacity
     * @param type
     * @param name
     * @param openingTime
     * @param closingTime
     */
    public Lift(String id, int length, int capacity, String type, String name, String openingTime, String closingTime, String status) {
        try {
            this.id = UUID.fromString(id);
            this.length = length;
            this.capacity = capacity;
            this.type = LiftType.valueOf(type);
            this.name = name;
            this.openingTime = LocalTime.parse(openingTime);
            this.closingTime = LocalTime.parse(closingTime);
            this.status = LiftStatus.valueOf(status);
        } catch (Exception e) {
            System.out.println("Failed to create Lift Class");
        }
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @return the capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * @return the type
     */
    public LiftType getType() {
        return type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the openingTime
     */
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    /**
     * @return the closingTime
     */
    public LocalTime getClosingTime() {
        return closingTime;
    }

    /**
     * @return the status
     */
    public LiftStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(LiftStatus status) {
        this.status = status;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (!(o instanceof Lift)) {
            return false;
        }
        
        Lift lift = (Lift) o;
        
        if (this.getName().equalsIgnoreCase(lift.getName())) {
            return true;
        }
        
        return false;
    }
    
    @Override
    public String toString() {
        return this.getName() + " - " + this.getStatus();
    }
}
