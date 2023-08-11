package ResortProject.Lifts;

import java.time.LocalTime;
import java.util.UUID;

/**
 *
 * @author ryanz
 */
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

    static enum LiftStatus {
        CLOSED,
        OPEN,
        WIND_HOLD;
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
    
    @Override
    public int hashCode() {
        return this.id.hashCode();
    }
}
