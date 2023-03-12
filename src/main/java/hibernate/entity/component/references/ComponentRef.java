package hibernate.entity.component.references;

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
    private double id;

    @NonNull
    @Column(name = "component_ref")
    private String ComponentRef;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH},
            mappedBy = "group_ref", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<GroupRef> groupRefList;

    public void addGroupToComponent(GroupRef groupRef) {
        if(groupRefList == null) {
            groupRefList = new ArrayList<>();
        }
        groupRefList.add(groupRef);
        groupRef.setComponentRef(this);
    }
}