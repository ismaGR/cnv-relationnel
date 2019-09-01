package CNV_Relationnel.cnv.model;

/*import lombok.*;*/

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
public class GenomicPlot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genomicPlotId;

    @OneToMany
    @JoinColumn(name ="genomicPlotId")
    @JsonIgnore
    private Collection<LineGenomicPlot> genomicPlotLines;

    public Long getGenomicPlotId() {
        return genomicPlotId;
    }

    public Collection<LineGenomicPlot> getGenomicPlotLines() {
        return genomicPlotLines;
    }

    public void setGenomicPlotLines(Collection<LineGenomicPlot> genomicPlotLines) {
        this.genomicPlotLines = genomicPlotLines;
    }

    public GenomicPlot(Collection<LineGenomicPlot> genomicPlotLines) {
        this.genomicPlotLines = genomicPlotLines;
    }

    public GenomicPlot() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenomicPlot that = (GenomicPlot) o;
        return Objects.equals(genomicPlotId, that.genomicPlotId) &&
                Objects.equals(genomicPlotLines, that.genomicPlotLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genomicPlotId, genomicPlotLines);
    }
}
