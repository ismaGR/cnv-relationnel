package CNV_Relationnel.cnv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MicroArray implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long microArrayId;


    @OneToMany
    @JoinColumn(name ="microArrayId")
    private Collection<LineMicroarray> microarrayLines ;//= new ArrayList<>();


}
