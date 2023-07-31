package ResortProject;

import java.time.LocalTime;

/**
 *
 * @author ryanz
 */
enum LiftType {
    CHAIRLIFT_FIXED_GRIP,
    CHAIRLIFT_DETACHABLE,
    T_BAR,
    J_BAR,
    CONVEYOR,
    ROPE_TOW,
    GONDOLA;
} 

enum LiftStatus {
    CLOSED,
    OPEN,
    WIND_HOLD;
}

public class Lift {
    
    private int length;
    private int capacity;
    private LiftType type;
    private String name;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private LiftStatus status;
    
    /**
     *
     * @param length
     * @param capacity
     * @param type
     * @param name
     * @param openingTime
     * @param closingTime
     */
    public Lift(int length, int capacity, LiftType type, String name, String openingTime, String closingTime) {
        this.length = length;
        this.capacity = capacity;
        this.type = type;
        this.name = name;
        this.status = LiftStatus.CLOSED;
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
    public String getType() {
        return type.name().replaceAll("_", " ");
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    
    
}
