package hibernate.entity.component.references;

import lombok.*;

import javax.persistence.*;

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
    private double id;
    @NonNull
    @Column(name = "group_ref")
    private String GroupRef;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "component_ref_id")
    @ToString.Exclude
    private ComponentRef componentRef;
}
