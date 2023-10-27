package com.group20.resortproject.lifts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A pass granting user's access to the lifts within the resort
 */
public class LiftPass {

    private int id;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    /**
     * Creates a new Lift Pass
     * 
     * @param id        the unique ID of the lift pass
     * @param validFrom the datetime the lift pass is valid from
     * @param validTo   the datetime the lift pass is valid to
     */
    public LiftPass(int id, LocalDateTime validFrom, LocalDateTime validTo) {
        this.id = id;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    /**
     * Creates a new Lift Pass
     * 
     * @param id        the unique ID of the lift pass
     * @param validFrom the datetime the lift pass is valid from
     * @param validTo   the datetime the lift pass is valid to
     */
    public LiftPass(LocalDateTime validFrom, LocalDateTime validTo) {
        this.id = 0;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    /**
     * 
     * @return the unique ID of the pass
     */
    public int getID() {
        return this.id;
    }

    /**
     * 
     * @return the datetime the lift pass is valid from
     */
    public LocalDateTime getValidFrom() {
        return this.validFrom;
    }

    /**
     * 
     * @return the datetime the lift pass is valid to
     */
    public LocalDateTime getValidTo() {
        return this.validTo;
    }

    /**
     * @return {@code true} if the current DateTime is between the pass' validFrom
     *         and validTo DateTimes
     */
    public boolean isValid() {
        return this.getValidTo().isAfter(LocalDateTime.now()) && LocalDateTime.now().isAfter(getValidFrom());
    }

    /**
     * @return a strings representation of the lift pass showing if it is valid, the
     *         {@code validFrom} and {@code validTo} dates
     */
    @Override
    public String toString() {
        String valid = this.isValid() ? "Valid ✅" : "Invalid ❌";
        return valid + " " + this.getValidFrom().format(DateTimeFormatter.ofPattern("dd MMM yy")) + " - "
                + this.getValidTo().format(DateTimeFormatter.ofPattern("dd MMM yy"));
    }

}
