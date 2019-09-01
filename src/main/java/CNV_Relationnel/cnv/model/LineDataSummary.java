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
public class LineDataSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineDataSummaryId;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "value")
    private String paramValue;

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    public LineDataSummary() {
    }

    public LineDataSummary(String parameter, String paramValue) {
        this.parameter = parameter;
        this.paramValue = paramValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineDataSummary that = (LineDataSummary) o;
        return Objects.equals(lineDataSummaryId, that.lineDataSummaryId) &&
                Objects.equals(parameter, that.parameter) &&
                Objects.equals(paramValue, that.paramValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineDataSummaryId, parameter, paramValue);
    }
}
