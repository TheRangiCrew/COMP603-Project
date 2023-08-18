package ResortProject.MountainCard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author ryanz
 */
public class MountainCard {
    
    private UUID id;
    private Person owner;
    private float credit;
    private ArrayList<LiftPass> passes;
    
    public MountainCard(Person owner, LocalDate validFrom, LocalDate validTo) {
        this.owner = owner;
        this.id = UUID.randomUUID();
        this.credit = 0.0f;
    }
    
    public MountainCard(Person owner, float credit, LocalDate validFrom, LocalDate validTo) {
        this.owner = owner;
        this.id = UUID.randomUUID();
        this.credit = credit;
    }
    
    public MountainCard(Person owner, UUID id, float credit, LocalDate validFrom, LocalDate validTo) {
        this.owner = owner;
        this.id = id;
        this.credit = credit;
    }
}
