package ResortProject.People;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.UUID;

public class Person {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;
    private String phone;
    private float credit;
    private HashSet<LiftPass> passes;

    // Formatter for credits
    private DecimalFormat decformat = new DecimalFormat("0.00");

    public Person(String firstName, String lastName, LocalDate dob, String email, String phone) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.credit = 0.0f;
        this.passes = new HashSet<>();
    }

    public Person(String id, String firstName, String lastName, String dob, String email, String phone, float credit) {
        try {
            this.id = UUID.fromString(id);
            this.firstName = firstName;
            this.lastName = lastName;
            this.dob = LocalDate.parse(dob);
            this.email = email;
            this.phone = phone;
            this.credit = credit;
            this.passes = new HashSet();
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to parse UUID. Incorrect format. Person will be skipped...");
        } catch (DateTimeParseException e) {
            System.out.println("Failed to parse DOB " + dob + ". Person will be skipped...");
        }
    }

    public Person(String id, String firstName, String lastName, String dob, String email, String phone, float credit,
            HashSet<LiftPass> passes) {
        try {
            this.id = UUID.fromString(id);
            this.firstName = firstName;
            this.lastName = lastName;
            this.dob = LocalDate.parse(dob);
            this.email = email;
            this.phone = phone;
            this.credit = credit;
            this.passes = passes;
        } catch (IllegalArgumentException e) {
            System.out.println("Failed to parse UUID. Incorrect format. Person will be skipped...");
        } catch (DateTimeParseException e) {
            System.out.println("Failed to parse DOB " + dob + ". Person will be skipped...");
        }
    }

    /**
     * @return the id
     */
    public String getId() {
        return id.toString();
    }

    /**
     * 
     * @return the name
     */
    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    /**
     * @return the dob
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return the passes
     */
    public HashSet<LiftPass> getPasses() {
        return passes;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the credit
     */
    public float getCredit() {
        return credit;
    }

    /**
     * @return the credit
     */
    public String getCreditAsString() {
        return decformat.format(this.credit);
    }

    public void addToCredit(float amount) {
        this.credit += Float.parseFloat(decformat.format(amount));
    }

    /**
     * Deducts the provided amount of credit from the persons credit
     * 
     * @param amount the amount to deduct
     * @return {@code true} if successfully deducted, otherwise {@code false}
     */
    public boolean deductFromCredit(float amount) {
        if (this.credit < amount || amount < 0.0f) {
            return false;
        }

        this.credit -= amount;
        return true;
    }

    public LiftPass getLatestLiftPass() {
        if (this.passes.size() > 0) {
            return (LiftPass) this.passes.toArray()[this.passes.size() - 1];
        }

        return null;
    }

    public void addLiftPass(LiftPass pass) {
        this.passes.add(pass);
    }

    /**
     * @return their name
     */
    @Override
    public String toString() {
        return this.getName() + " " + this.getDob().toString() + "\n"
                + this.getEmail() + " " + this.getPhone() + "\n"
                + "Credit balance: $" + this.getCreditAsString();
    }
}
