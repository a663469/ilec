package hibernate.entity.component;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "specific_components")
public class SpecificComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NonNull
    @Column(name = "part_number")
    private String partNumber;
//    private String helpURL;
//    private ManufacturerRef manufacturerRef;
//    private TempRangeRef tempRangeRef;
//    private PartStatusRef partStatusRef;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "component_id")
    @ToString.Exclude
    private Component component;
}
