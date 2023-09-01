package ResortProject.RentalEquipment;

public enum BootType {
    SKI("Ski"),
    SNOWBOARD("Snowboard");

    private String name;

    BootType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}