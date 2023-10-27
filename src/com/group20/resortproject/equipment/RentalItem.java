package com.group20.resortproject.equipment;

public class RentalItem {

    private int id;
    private String name;
    private String equipmentSize;
    private String sizeUnit;
    private int availbility;
    private EquipmentType equipmentType;
    private int equipmentPrice;

    /**
     * 
     * @param id
     * @param name
     * @param equipmentSize  size of the equipment
     * @param sizeUnit       unit in which the size is measured in
     * @param availability   amount available to rent out
     * @param equipmentType  the type of equipment that is being rented
     * @param equipmentPrice the cost to rent out equipment
     */
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

    /**
     * 
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return equipmetSize
     */
    public String getEquipmentSize() {
        return equipmentSize;
    }

    /**
     * 
     * @return sizeUnit
     */
    public String getSizeUnit() {
        return sizeUnit;
    }

    /**
     * 
     * @return equioment availability
     */
    public int getAvailbility() {
        return availbility;
    }

    /**
     * 
     * @return equipmentType
     */
    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    /**
     * 
     * @return equipmentPrice
     */
    public int getEquipmentPrice() {
        return equipmentPrice;
    }
}
