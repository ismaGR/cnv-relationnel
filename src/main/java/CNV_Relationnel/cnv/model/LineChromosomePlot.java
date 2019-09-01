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
public class LineChromosomePlot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineChromosomePlotId;

    @Column(name = "chrom")
    public String chrom;

    @Column(name = "path_file_chrom")
    public String pathFileChrom;
}
