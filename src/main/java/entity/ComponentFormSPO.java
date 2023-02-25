package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "elements_view")
public class ComponentFormSPO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private double id;
    @Column(name = "component_reg")
    private String componentReg;
    @Column(name = "group_ref")
    private String groupRef;
    @Column(name = "category_ref")
    private String categoryRef;
    @Column(name = "manufacturer_ref")
    private String manufacturerRef;
    @Column(name = "part_status")
    private String partStatus;
    @Column(name = "library_ref")
    private String libraryRef;
    @Column(name = "part_number")
    private String partNumber;
    @Column(name = "component_name")
    private String componentName;
    @Column(name = "footprint_ref1")
    private String footprintRef1;
    @Column(name = "footprint_ref2")
    private String footprintRef2;
    @Column(name = "footprint_ref3")
    private String footprintRef3;
    @Column(name = "temp_range")
    private String tempRange;
    @Column(name = "comment")
    private String comment;
    @Column(name = "help_url")
    private String helpURL;
    @Column(name = "stock_id")
    private double stockID;
    @Column(name = "stock_barcode")
    private double stockBarcode;
    @Column(name = "stock_title")
    private String stockTitle;
    @Column(name = "stock_count")
    private double stockCount;
}
