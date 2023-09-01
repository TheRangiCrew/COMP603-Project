package ResortProject.People;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.UUID;

public class LiftPass {

    private UUID id;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;

    public LiftPass(LocalDateTime validFrom, LocalDateTime validTo) {
        this.id = UUID.randomUUID();
        this.validFrom = validFrom;
        this.validTo = validTo;
    }

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

    public boolean isValid() {
        return this.getValidTo().isAfter(LocalDateTime.now()) && LocalDateTime.now().isAfter(getValidFrom());
    }

    @Override
    public String toString() {
        String valid = this.isValid() ? "Valid ✅" : "Invalid ❌";
        return valid + "\n" + this.getValidFrom().format(DateTimeFormatter.ofPattern("dd MMM yy")) + " - "
                + this.getValidTo().format(DateTimeFormatter.ofPattern("dd MMM yy"));
    }
}
