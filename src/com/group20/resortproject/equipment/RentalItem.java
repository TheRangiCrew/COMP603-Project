package com.group20.resortproject.equipment;

public class RentalItem {

    private int id;
    private String name;
    private String equipmentSize;
    private String sizeUnit;
    private int availbility;
    private EquipmentType equipmentType;
    private int equipmentPrice;

    public RentalItem(int id, String name, String equipmentSize, String sizeUnit, int availability,
            EquipmentType equipmentType, int equipmentPrice) {

        this.id = id;
        this.name = name;
        this.equipmentSize = equipmentSize;
        this.sizeUnit = sizeUnit;
        this.availbility = availability;
        this.equipmentType = equipmentType;
        this.equipmentPrice = equipmentPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEquipmentSize() {
        return equipmentSize;
    }

    public String getSizeUnit() {
        return sizeUnit;
    }

    public int getAvailbility() {
        return availbility;
    }

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public int getEquipmentPrice() {
        return equipmentPrice;
    }
}
