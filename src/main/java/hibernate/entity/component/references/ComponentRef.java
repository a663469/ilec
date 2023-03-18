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
@Table(name = "component_ref_list")

public class ComponentRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NonNull
    @Column(name = "component_ref")
    private String ComponentRef;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "componentRef", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Component> cmpList;

    public void addComponent(Component cmp) {
        if(cmpList == null) {
            cmpList = new ArrayList<>();
        }
        cmpList.add(cmp);
        cmp.setComponentRef(this);
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "groupRef", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<GroupRef> groupRefList;

    public void addGroup(GroupRef groupRef) {
        if(groupRefList == null) {
            groupRefList = new ArrayList<>();
        }
        groupRefList.add(groupRef);
        groupRef.setComponentRef(this);
    }
}