package hibernate.entity.component;

import hibernate.entity.component.references.FootprintRef;
import hibernate.entity.component.references.SchSymbolRef;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "components")
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "component_name")
    private String componentName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "component", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<SpecificComponent> specificComponentList;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "sch_symbol_id")
    @ToString.Exclude
    private SchSymbolRef schSymbolRef;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "footprint_id")
    @ToString.Exclude
    private FootprintRef footprintRef;

    public void addSpecificComponentToComponent(SpecificComponent specificComponent){
        if(specificComponentList == null) {
            specificComponentList = new ArrayList<>();
        }
        specificComponentList.add(specificComponent);
        specificComponent.setComponent(this);
    }
}