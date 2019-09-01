package CNV_Relationnel.cnv.model;

//import lombok.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
public class ChromosomePlot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long chromosomePlotId;

    @OneToMany
    @JoinColumn(name ="chromosomePlotId")
    @JsonIgnore
    private Collection<LineChromosomePlot> chromosomePlotLines;

    public Long getChromosomePlotId() {
        return chromosomePlotId;
    }

    public Collection<LineChromosomePlot> getChromosomePlotLines() {
        return chromosomePlotLines;
    }

    public void setChromosomePlotLines(Collection<LineChromosomePlot> chromosomePlotLines) {
        this.chromosomePlotLines = chromosomePlotLines;
    }

    public ChromosomePlot() {
    }

    public ChromosomePlot(Collection<LineChromosomePlot> chromosomePlotLines) {
        this.chromosomePlotLines = chromosomePlotLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChromosomePlot that = (ChromosomePlot) o;
        return Objects.equals(chromosomePlotId, that.chromosomePlotId) &&
                Objects.equals(chromosomePlotLines, that.chromosomePlotLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chromosomePlotId, chromosomePlotLines);
    }
}
