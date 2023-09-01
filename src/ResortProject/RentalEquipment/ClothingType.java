package ResortProject.RentalEquipment;

public enum ClothingType {
    JACKET("Jacket"),
    PANTS("Pants"),
    HELMET("Helmet"),
    CHILDSONEPIECE("Childs One Piece");

    private String name;

    ClothingType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
