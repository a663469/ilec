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
@Table(name = "group_ref_list")
public class GroupRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NonNull
    @Column(name = "group_ref")
    private String groupRef;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "component_ref_id")
    @ToString.Exclude
    private ComponentRef componentRef;


    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "categoryRef", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<CategoryRef> categoryRefList;

    public void addCategoryRef(CategoryRef categoryRef) {
        if(categoryRefList == null) {
            categoryRefList = new ArrayList<>();
        }
        categoryRefList.add(categoryRef);
        categoryRef.setGroupRef(this);
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "groupRef", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Component> components;

    public void addComponent(Component component) {
        if(components == null) {
            components = new ArrayList<>();
        }
        components.add(component);
        component.setGroupRef(this);
    }
}
