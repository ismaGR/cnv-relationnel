package CNV_Relationnel.cnv.model;

/*import lombok.*;*/

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
public class AffymetrixParameter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long affymetrixParameterId;

    @OneToMany
    @JoinColumn(name ="affymetrixParameterId")
    private Collection<LineAffymetrixParameter> affymetrixParameterLines;


    public Long getAffymetrixParameterId() {
        return affymetrixParameterId;
    }

    public Collection<LineAffymetrixParameter> getAffymetrixParameterLines() {
        return affymetrixParameterLines;
    }

    public void setAffymetrixParameterLines(Collection<LineAffymetrixParameter> affymetrixParameterLines) {
        this.affymetrixParameterLines = affymetrixParameterLines;
    }

    public AffymetrixParameter() {
    }

    public AffymetrixParameter(Collection<LineAffymetrixParameter> affymetrixParameterLines) {
        this.affymetrixParameterLines = affymetrixParameterLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AffymetrixParameter that = (AffymetrixParameter) o;
        return Objects.equals(affymetrixParameterId, that.affymetrixParameterId) &&
                Objects.equals(affymetrixParameterLines, that.affymetrixParameterLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(affymetrixParameterId, affymetrixParameterLines);
    }
}
