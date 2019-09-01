package CNV_Relationnel.cnv.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LineMicroarray implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineMicroarrayId;

    @Column(name = "array_type")
    public String arrayType;

    @Column(name = "array_barcode")
    public String arrayBarcode;

    @Column(name = "scanner_id")
    public String scannerId;

    @Column(name = "scan_date")
    public Date scanDate;

    @Column(name = "path_to_plot")
    public String pathToPlot;

}
