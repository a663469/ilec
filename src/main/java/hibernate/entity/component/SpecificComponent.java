package hibernate.entity.component;

import hibernate.entity.component.references.ManufacturerRef;
import hibernate.entity.component.references.PartStatusRef;
import hibernate.entity.component.references.TempRangeRef;
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

    @NonNull
    @Column(name = "help_url")
    private String helpURL;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "manufacturer_id")
    @ToString.Exclude
    private ManufacturerRef manufacturerRef;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "temp_range_id")
    @ToString.Exclude
    private TempRangeRef tempRangeRef;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "part_status_id")
    @ToString.Exclude
    private PartStatusRef partStatusRef;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "component_id")
    @ToString.Exclude
    private Component component;
}
