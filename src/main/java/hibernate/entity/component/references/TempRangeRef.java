package hibernate.entity.component.references;

import hibernate.entity.component.SpecificComponent;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "temp_range_ref")
public class TempRangeRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "min_temp")
    private int minTemp;

    @NonNull
    @Column(name = "max_temp")
    private int maxTemp;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "tempRangeRef", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<SpecificComponent> scl;

    public void addSpecificComponent(SpecificComponent sc){
        if(scl == null) {
            scl = new ArrayList<>();
        }
        scl.add(sc);
        sc.setTempRangeRef(this);
    }
}
