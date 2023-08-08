package ResortProject;

import java.time.LocalTime;

/**
 *
 * @author ryanz
 */
enum LiftType {
    CHAIRLIFT_FIXED_GRIP, // Express lifts...
    CHAIRLIFT_DETACHABLE, // Slow regular chairlift
    T_BAR,
    J_BAR, // Poma
    CONVEYOR, // Magic Carpet
    ROPE_TOW, 
    GONDOLA;
} 

enum LiftStatus {
    CLOSED,
    OPEN,
    WIND_HOLD;
}

public class Lift {
    
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
    public Lift(int length, int capacity, LiftType type, String name, String openingTime, String closingTime) {
        this.length = length;
        this.capacity = capacity;
        this.type = type;
        this.name = name;
        this.status = LiftStatus.CLOSED;
    }
}
