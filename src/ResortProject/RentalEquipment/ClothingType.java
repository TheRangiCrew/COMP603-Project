package ResortProject.RentalEquipment;

/**
 * Types of clothing
 */
public enum ClothingType {
    JACKET("Jacket"),
    PANTS("Pants"),
    HELMET("Helmet"),
    CHILDSONEPIECE("Childs One Piece");

    private String name;

    ClothingType(String name) {
        this.name = name;
    }

    /**
     * @return string representation of enum
     */
    @Override
    public String toString() {
        return this.name;
    }
}
