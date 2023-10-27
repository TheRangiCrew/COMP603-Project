package com.group20.resortproject.equipment;

public enum EquipmentType {
    SNOWBOARD("Snowboard"),
    SKI("Ski"),
    SKIPOLE("Ski Poles"),
    BOOTS("Boots"),
    CLOTHING("Clothing"),
    TABOGGAN("Taboggan");

    private String name;

    private EquipmentType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public static EquipmentType findFromString(String string) {
        return EquipmentType.valueOf(string);
    }
}
