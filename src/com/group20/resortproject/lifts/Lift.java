package com.group20.resortproject.lifts;

import java.time.LocalTime;

/**
 * A ski lift with some information about the lift
 */
public class Lift {

    private int id;
    private String name;
    private LocalTime openingTime;
    private LocalTime closingTime;
    private String liftStatus;
    private String liftType;
    private int length;
    private int capacity;

    /**
     * 
     * @param id
     * @param name
     * @param openingTime
     * @param closingTime
     * @param liftStatus  whether the lift is open or closed or on hold
     * @param liftType
     * @param length      length of the lift in meters
     * @param capacity
     */
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

    /**
     * 
     * @return the unqiue ID of the lift
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @return name of the lift
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @return the lift's opening time
     */
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    /**
     * 
     * @return the lift's closing time
     */
    public LocalTime getClosingTime() {
        return closingTime;
    }

    /**
     * 
     * @return the status of the lift
     */
    public String getLiftStatus() {
        return liftStatus;
    }

    /**
     * 
     * @return the lift's type
     */
    public String getLiftType() {
        return liftType;
    }

    /**
     * 
     * @return lenght of the lift in meters
     */
    public int getLength() {
        return length;
    }

    /**
     * 
     * @return capcity of each gondola on the lift
     */
    public int getCapacity() {
        return capacity;
    }

}
