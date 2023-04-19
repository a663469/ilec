package online.ilec.cmps.entity.references;

import online.ilec.cmps.entity.SpecificComponent;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "part_status_ref")
public class PartStatusRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "part_status")
    private String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "partStatusRef", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<SpecificComponent> scl;

    public void addSpecificComponent(SpecificComponent sc){
        if(scl == null) {
            scl = new ArrayList<>();
        }
        scl.add(sc);
        sc.setPartStatusRef(this);
    }
}
