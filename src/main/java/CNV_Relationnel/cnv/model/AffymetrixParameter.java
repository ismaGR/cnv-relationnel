package CNV_Relationnel.cnv.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class AffymetrixParameter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long affymetrixParameterId;

    @OneToMany
    @JoinColumn(name ="affymetrixParameterId")
    private Collection<LineAffymetrixParameter> affymetrixParameterLines;

}
