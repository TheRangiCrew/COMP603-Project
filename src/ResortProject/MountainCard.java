package ResortProject;

import java.time.LocalDate;
import java.util.UUID;

/**
 *
 * @author ryanz
 */
public class MountainCard {
    
    private Person owner;
    private UUID id;
    private float credit;
    private LocalDate validFrom;
    private LocalDate validTo;
    
    public MountainCard(Person owner, LocalDate validFrom, LocalDate validTo) {
        this.owner = owner;
        this.id = UUID.randomUUID();
        this.credit = 0.0f;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    
    public MountainCard(Person owner, float credit, LocalDate validFrom, LocalDate validTo) {
        this.owner = owner;
        this.id = UUID.randomUUID();
        this.credit = credit;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
    
    public MountainCard(Person owner, UUID id, float credit, LocalDate validFrom, LocalDate validTo) {
        this.owner = owner;
        this.id = id;
        this.credit = credit;
        this.validFrom = validFrom;
        this.validTo = validTo;
    }
}
