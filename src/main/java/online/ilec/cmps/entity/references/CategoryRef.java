package online.ilec.cmps.entity.references;

import online.ilec.cmps.entity.Component;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category_ref_list")
public class CategoryRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NonNull
    @Column(name = "category_ref")
    private String categoryRef;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "group_ref_id")
    @ToString.Exclude
    private GroupRef groupRef;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "categoryRef", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Component> components;

    public void addComponent(Component component) {
        if(components == null) {
            components = new ArrayList<>();
        }
        components.add(component);
        component.setCategoryRef(this);
    }
}
