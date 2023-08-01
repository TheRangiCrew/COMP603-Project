package ResortProject;

import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author ryanz
 */
public class Ticket {
    
    private Person owner;
    private UUID id;
    private float credit;
    private LocalDate validFrom;
    private LocalDate validTo;
    
    public Ticket(Person owner, LocalDate validFrom, LocalDate validTo) {
        this.owner = owner;
        this.id = UUID.randomUUID();
        this.credit = 0.0f;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    
    public Ticket(Person owner, float credit, LocalDate validFrom, LocalDate validTo) {
        this.owner = owner;
        this.id = UUID.randomUUID();
        this.credit = credit;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    
    public Ticket(Person owner, UUID id, float credit, LocalDate validFrom, LocalDate validTo) {
        this.owner = owner;
        this.id = id;
        this.credit = credit;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
}
