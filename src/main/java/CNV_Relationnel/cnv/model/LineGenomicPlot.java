package CNV_Relationnel.cnv.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LineGenomicPlot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineGenomicPlotId;

    @Column(name = "path_file_BAF")
    private String pathFileBAF;

    @Column(name = "path_file_L2R")
    private String pathFileL2R;

    @Column(name = "path_file_L2R_BAF")
    private String pathFileL2RBAF;
}
