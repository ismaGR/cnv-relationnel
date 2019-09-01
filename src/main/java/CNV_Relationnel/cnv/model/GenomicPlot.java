package CNV_Relationnel.cnv.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class GenomicPlot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genomicPlotId;

    @OneToMany
    @JoinColumn(name ="genomicPlotId")
    private Collection<LineGenomicPlot> genomicPlotLines;

}
