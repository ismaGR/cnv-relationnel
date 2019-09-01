package CNV_Relationnel.cnv.model;

/*import lombok.*;*/

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.*;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString*/
public class EaCoNParameter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long eaconParameterId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "eaconParameterId")
    private Collection<LineEaconParameter> eaconParameters = new ArrayList<>() ;

    public Long getEaconParameterId() {
        return eaconParameterId;
    }

    public Collection<LineEaconParameter> getEaconParameters() {
        return eaconParameters;
    }

    public void setEaconParameters(Collection<LineEaconParameter> eaconParameters) {
        this.eaconParameters = eaconParameters;
    }

    public EaCoNParameter() {

    }

    public EaCoNParameter(Collection<LineEaconParameter> eaconParameters) {
        this.eaconParameters = eaconParameters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EaCoNParameter that = (EaCoNParameter) o;
        return Objects.equals(eaconParameterId, that.eaconParameterId) &&
                Objects.equals(eaconParameters, that.eaconParameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eaconParameterId, eaconParameters);
    }
}
