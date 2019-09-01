package CNV_Relationnel.cnv.model;


/*import lombok.*;*/

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
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

    public Long getLineGenomicPlotId() {
        return lineGenomicPlotId;
    }

    public String getPathFileBAF() {
        return pathFileBAF;
    }

    public void setPathFileBAF(String pathFileBAF) {
        this.pathFileBAF = pathFileBAF;
    }

    public String getPathFileL2R() {
        return pathFileL2R;
    }

    public void setPathFileL2R(String pathFileL2R) {
        this.pathFileL2R = pathFileL2R;
    }

    public String getPathFileL2RBAF() {
        return pathFileL2RBAF;
    }

    public void setPathFileL2RBAF(String pathFileL2RBAF) {
        this.pathFileL2RBAF = pathFileL2RBAF;
    }

    public LineGenomicPlot() {
    }

    public LineGenomicPlot(String pathFileBAF, String pathFileL2R, String pathFileL2RBAF) {
        this.pathFileBAF = pathFileBAF;
        this.pathFileL2R = pathFileL2R;
        this.pathFileL2RBAF = pathFileL2RBAF;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineGenomicPlot that = (LineGenomicPlot) o;
        return Objects.equals(lineGenomicPlotId, that.lineGenomicPlotId) &&
                Objects.equals(pathFileBAF, that.pathFileBAF) &&
                Objects.equals(pathFileL2R, that.pathFileL2R) &&
                Objects.equals(pathFileL2RBAF, that.pathFileL2RBAF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineGenomicPlotId, pathFileBAF, pathFileL2R, pathFileL2RBAF);
    }


}
