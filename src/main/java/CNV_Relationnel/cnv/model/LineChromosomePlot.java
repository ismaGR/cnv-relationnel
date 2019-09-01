package CNV_Relationnel.cnv.model;

//import lombok.*;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
public class LineChromosomePlot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineChromosomePlotId;

    @Column(name = "chrom")
    public String chrom;

    @Column(name = "path_file_chrom")
    public String pathFileChrom;

    public Long getLineChromosomePlotId() {
        return lineChromosomePlotId;
    }

    public String getChrom() {
        return chrom;
    }

    public void setChrom(String chrom) {
        this.chrom = chrom;
    }

    public String getPathFileChrom() {
        return pathFileChrom;
    }

    public void setPathFileChrom(String pathFileChrom) {
        this.pathFileChrom = pathFileChrom;
    }

    public LineChromosomePlot(String chrom, String pathFileChrom) {
        this.chrom = chrom;
        this.pathFileChrom = pathFileChrom;
    }

    public LineChromosomePlot() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineChromosomePlot that = (LineChromosomePlot) o;
        return Objects.equals(lineChromosomePlotId, that.lineChromosomePlotId) &&
                Objects.equals(chrom, that.chrom) &&
                Objects.equals(pathFileChrom, that.pathFileChrom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineChromosomePlotId, chrom, pathFileChrom);
    }
}
