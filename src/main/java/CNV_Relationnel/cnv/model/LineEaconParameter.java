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
public class LineEaconParameter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineEaconParamId;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "value")
    private String paramValue;

    public Long getLineEaconParamId() {
        return lineEaconParamId;
    }

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

    public LineEaconParameter() {
    }

    public LineEaconParameter(String parameter, String paramValue) {
        this.parameter = parameter;
        this.paramValue = paramValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineEaconParameter that = (LineEaconParameter) o;
        return Objects.equals(lineEaconParamId, that.lineEaconParamId) &&
                Objects.equals(parameter, that.parameter) &&
                Objects.equals(paramValue, that.paramValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineEaconParamId, parameter, paramValue);
    }
}
