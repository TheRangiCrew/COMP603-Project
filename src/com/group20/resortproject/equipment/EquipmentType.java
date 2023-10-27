package com.group20.resortproject.equipment;

/**
 * An EquipmentType Enum of possible rental equipments
 */
public enum EquipmentType {
    SNOWBOARD("Snowboard"),
    SKI("Ski"),
    SKIPOLE("Ski Poles"),
    BOOTS("Boots"),
    CLOTHING("Clothing"),
    TABOGGAN("Taboggan");

    private String name;

    /**
     * 
     * @param name
     */
    private EquipmentType(String name) {
        this.name = name;
    }

    /**
     * 
     * @return name of the EqupimentType
     */
    public String getName() {
        return this.name;
    }
}
