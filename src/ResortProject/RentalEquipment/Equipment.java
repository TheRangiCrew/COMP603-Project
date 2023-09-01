package ResortProject.RentalEquipment;

/**
 * The generic Equipment class with the common elements of Rental Equipment
 * within the resort
 */
public class Equipment implements Comparable<Equipment> {

    private String name;
    private String size;
    private int available;
    private String type;

    /**
     * @param name      name of the equipment
     * @param size      size as a string (can be parsed to other types in
     *                  sub-classes)
     * @param available available quantity
     */
    public Equipment(String name, String size, int available, String type) {
        this.name = name;
        this.size = size;
        this.available = available;
        this.type = type;
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

    /**
     * @return true if the availability > 0, else false
     */
    public boolean isAvailable() {
        return this.available > 0;
    }

    /**
     * @param available the availability
     */
    public void setAvailable(int available) {
        this.available = available;
    }

    /**
     * @return the type
     */
    public String getType() {
        return this.type;
    }

    /**
     * @return name, size, availability of equipment as string
     */
    @Override
    public String toString() {
        return this.name + "  " + this.size + "  " + (this.isAvailable() ? "Available" : "Unavailable");
    }

    /**
     * @return 0 if equipment is equal otherwise other integer
     */
    @Override
    public int compareTo(Equipment equipment) {
        try {
            return Integer.compare(Integer.parseInt(this.size), Integer.parseInt(equipment.size));
        } catch (NumberFormatException e) {
            return 404;
        }
    }
}
