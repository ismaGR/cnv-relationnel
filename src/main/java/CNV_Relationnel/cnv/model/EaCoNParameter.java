package CNV_Relationnel.cnv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EaCoNParameter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long eaconParameterId;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "eaconParameterId")
    private Collection<LineEaconParameter> eaconParameters = new ArrayList<>() ;


}
