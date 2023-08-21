package ResortProject.People;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.UUID;

/**
 *
 * @author ryanz
 */
public class Person {

    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String email;
    private String phone;
    private HashSet<LiftPass> passes;

    public Person(String id, String firstName, String lastName, String dob, String email, String phone) {
        try {
            this.id = UUID.fromString(id);
            this.firstName = firstName;
            this.lastName = lastName;
            this.dob = LocalDate.parse(dob);
            this.email = email;
            this.phone = phone;
            this.passes = new HashSet();
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
    
    
}
