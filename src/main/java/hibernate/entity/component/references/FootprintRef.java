package hibernate.entity.component.references;

import hibernate.entity.component.Component;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "footprint_ref")
public class FootprintRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NonNull
    @Column(name = "footprint_name", unique=true)
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            mappedBy = "footprintRef", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Component> components;

    public void addComponent(Component cmp){
        if(components == null) {
            components = new ArrayList<>();
        }
        components.add(cmp);
        cmp.setFootprintRef(this);
    }
}