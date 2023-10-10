package com.group20.resortproject.lifts;

import java.time.LocalTime;

public class Lift {

    private int id;
    private String name;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String liftStatus;
    private String liftType;
    private int length;
    private int capacity;

    public Lift(int id, String name, LocalTime openingTime, LocalTime closingTime, String liftStatus, String liftType,
            int length, int capacity) {

        this.id = id;
        this.name = name;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.liftStatus = liftStatus;
        this.liftType = liftType;
        this.length = length;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public LocalTime getClosingTime() {
        return closingTime;
    }

    public String getLiftStatus() {
        return liftStatus;
    }

    public String getLiftType() {
        return liftType;
    }

    public int getLength() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }

}
