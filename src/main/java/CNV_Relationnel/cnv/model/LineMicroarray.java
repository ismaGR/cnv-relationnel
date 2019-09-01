package CNV_Relationnel.cnv.model;




import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;
import javax.persistence.*;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode*/
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

    public Long getLineMicroarrayId() {
        return lineMicroarrayId;
    }

    public String getArrayType() {
        return arrayType;
    }

    public void setArrayType(String arrayType) {
        this.arrayType = arrayType;
    }

    public String getArrayBarcode() {
        return arrayBarcode;
    }

    public void setArrayBarcode(String arrayBarcode) {
        this.arrayBarcode = arrayBarcode;
    }

    public String getScannerId() {
        return scannerId;
    }

    public void setScannerId(String scannerId) {
        this.scannerId = scannerId;
    }

    public Date getScanDate() {
        return scanDate;
    }

    public void setScanDate(Date scanDate) {
        this.scanDate = scanDate;
    }

    public String getPathToPlot() {
        return pathToPlot;
    }

    public void setPathToPlot(String pathToPlot) {
        this.pathToPlot = pathToPlot;
    }

    public LineMicroarray() {
    }

    public LineMicroarray(String arrayType, String arrayBarcode, String scannerId, Date scanDate, String pathToPlot) {
        this.arrayType = arrayType;
        this.arrayBarcode = arrayBarcode;
        this.scannerId = scannerId;
        this.scanDate = scanDate;
        this.pathToPlot = pathToPlot;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineMicroarray that = (LineMicroarray) o;
        return Objects.equals(lineMicroarrayId, that.lineMicroarrayId) &&
                Objects.equals(arrayType, that.arrayType) &&
                Objects.equals(arrayBarcode, that.arrayBarcode) &&
                Objects.equals(scannerId, that.scannerId) &&
                Objects.equals(scanDate, that.scanDate) &&
                Objects.equals(pathToPlot, that.pathToPlot);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineMicroarrayId, arrayType, arrayBarcode, scannerId, scanDate, pathToPlot);
    }
}
