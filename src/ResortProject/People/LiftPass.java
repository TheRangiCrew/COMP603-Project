package ResortProject.People;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.UUID;

/**
 * Class to represent the lift passes that users can purchase
 */
public class LiftPass {

    private UUID id;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    /**
     * Create a new lift pass given dates
     * 
     * @param validFrom start of day pass is valid from
     * @param validTo   end of day pass is valid to
     */
    public LiftPass(LocalDateTime validFrom, LocalDateTime validTo) {
        this.id = UUID.randomUUID();
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

    /**
     * Create a new lift pass given a string values
     * 
     * @param id        valid UUID
     * @param validFrom string representation of pass start DateTime
     * @param validTo   string representation of pass end DateTime
     */
    public LiftPass(String id, String validFrom, String validTo) {
        try {
            this.id = UUID.fromString(id);
            this.validFrom = LocalDateTime.parse(validFrom);
            this.validTo = LocalDateTime.parse(validTo);
        } catch (IllegalArgumentException e) {
            System.out.println("UUID provided is in an incorrect format. Skipping Lift Pass...");
        } catch (DateTimeParseException e) {
            System.out.println("LocalDate provided is in an incorrect format. Skipping Lift Pass...");
        }
    }

    /**
     * @return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @return the validFrom
     */
    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    /**
     * @return the validTo
     */
    public LocalDateTime getValidTo() {
        return validTo;
    }

    /**
     * 
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
        return valid + "\n" + this.getValidFrom().format(DateTimeFormatter.ofPattern("dd MMM yy")) + " - "
                + this.getValidTo().format(DateTimeFormatter.ofPattern("dd MMM yy"));
    }
}
