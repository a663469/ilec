package hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Data
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "elements_view")
public class ComponentFormSPO {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NonNull
    @Column(name = "component_ref")
    private String componentRef;
    @NonNull
    @Column(name = "group_ref")
    private String groupRef;
    @NonNull
    @Column(name = "category_ref")
    private String categoryRef;
//    @NonNull
//    @Column(name = "manufacturer_ref")
//    private String manufacturerRef;
//    @NonNull
//    @Column(name = "part_status")
//    private String partStatus;
//    @NonNull
//    @Column(name = "library_ref")
//    private String libraryRef;
//    @NonNull
//    @Column(name = "part_number")
//    private String partNumber;
//    @NonNull
//    @Column(name = "component_name")
//    private String componentName;
//    @NonNull
//    @Column(name = "footprint_ref1")
//    private String footprintRef1;
//    @NonNull
//    @Column(name = "footprint_ref2")
//    private String footprintRef2;
//    @NonNull
//    @Column(name = "footprint_ref3")
//    private String footprintRef3;
//    @NonNull
//    @Column(name = "temp_range")
//    private String tempRange;
//    @NonNull
//    @Column(name = "comment")
//    private String comment;
//    @NonNull
//    @Column(name = "help_url")
//    private String helpURL;
//    @NonNull
//    @Column(name = "stock_id")
//    private double stockID;
//    @NonNull
//    @Column(name = "stock_barcode")
//    private double stockBarcode;
//    @NonNull
//    @Column(name = "stock_title")
//    private String stockTitle;
//    @NonNull
//    @Column(name = "stock_count")
//    private double stockCount;
}
