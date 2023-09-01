package ResortProject.RentalEquipment;

public enum RideType {
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