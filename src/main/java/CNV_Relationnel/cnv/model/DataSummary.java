package CNV_Relationnel.cnv.model;


//import lombok.*;

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
public class DataSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long dataSummaryId;


    @OneToMany/*(fetch = FetchType.EAGER)*/
    @JoinColumn(name = "dataSummaryId")
    private Collection<LineDataSummary> dataSummaryLines /*= new ArrayList<>()*/;

    public Long getDataSummaryId() {
        return dataSummaryId;
    }

    public Collection<LineDataSummary> getDataSummaryLines() {
        return dataSummaryLines;
    }

    public void setDataSummaryLines(Collection<LineDataSummary> dataSummaryLines) {
        this.dataSummaryLines = dataSummaryLines;
    }

    public DataSummary() {
    }

    public DataSummary(Collection<LineDataSummary> dataSummaryLines) {
        this.dataSummaryLines = dataSummaryLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataSummary that = (DataSummary) o;
        return Objects.equals(dataSummaryId, that.dataSummaryId) &&
                Objects.equals(dataSummaryLines, that.dataSummaryLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataSummaryId, dataSummaryLines);
    }
}
