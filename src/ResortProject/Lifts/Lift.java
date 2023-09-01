package ResortProject.Lifts;

import java.time.LocalTime;
import java.util.UUID;

/**
 * Class to represent a ski lift and it's different attributes including
 * opening/closing times, status, type, capacity and name
 */
public class Lift {

    /**
     * The types of ski lifts
     */
    static enum LiftType {
        CHAIRLIFT_FIXED_GRIP, // Express lifts...
        CHAIRLIFT_DETACHABLE, // Slow regular chairlift
        T_BAR,
        J_BAR, // Poma
        CONVEYOR, // Magic Carpet
        ROPE_TOW,
        GONDOLA;
    }

    /**
     * The different statuses of ski lifts
     */
    public static enum LiftStatus {
        CLOSED("CLOSED"),
        OPEN("OPEN"),
        WIND_HOLD("WIND HOLD");

        // Name to view to status in a user friendly {@code String}
        private String name;

        /**
         * Assigns the name to the enum
         */
        private LiftStatus(String name) {
            this.name = name;
        }

        /**
         * @return a user friendly {@code String} representation of the lift status
         */
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
    private LiftStatus status; // See above (e.g. CLOSED, OPEN, WIND_HOLD)

    /**
     * Constructor
     * 
     * Given only Strings or primitive types, a Lift can be created and types
     * inferred from the provided values
     * 
     * @param id          unique lift UUID
     * @param length      lift length in metres
     * @param capacity    lift capacity per chair/gondola/bar
     * @param type        lift type
     * @param name        lift name
     * @param openingTime lift openeing time
     * @param closingTime lift closing time
     * @param status      lift status
     * 
     * @see LocalTime
     * @see LiftType
     * @see LiftStatus
     */
    public Lift(String id, int length, int capacity, String type, String name, String openingTime, String closingTime,
            String status) {
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
            // If the UUID or LocalTime fails to parse
            System.out.println("Failed to create Lift Class");
        }
    }

    /**
     * @return the UUID
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the length in metres
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

    /**
     * Compares the given lift by name, ignoring case
     * 
     * @return true if the lift has the same name, otherwise false
     */
    @Override
    public boolean equals(Object o) {
        // If Object is null, return
        if (o == null) {
            return false;
        }

        // If Object is not type Lift, return
        if (!(o instanceof Lift)) {
            return false;
        }

        // Type cast Object to lift
        Lift lift = (Lift) o;

        // Compare the names ignoring case and return the result
        return this.getName().equalsIgnoreCase(lift.getName());

    }

    /**
     * @return lift name and status
     */
    @Override
    public String toString() {
        return this.getName() + " - " + this.getStatus();
    }
}
