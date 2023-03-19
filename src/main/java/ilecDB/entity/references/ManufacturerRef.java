package ilecDB.entity.references;

import ilecDB.entity.SpecificComponent;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manufacturer_ref")
public class ManufacturerRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "manufacturer")
    private String name;

    @NonNull
    @Column(name = "country")
    private String county;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "manufacturerRef", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<SpecificComponent> scl;

    public void addSpecificComponent(SpecificComponent sc){
        if(scl == null) {
            scl = new ArrayList<>();
        }
        scl.add(sc);
        sc.setManufacturerRef(this);
    }
}
