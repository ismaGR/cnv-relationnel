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
public class ChromosomePlot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long chromosomePlotId;

    @OneToMany
    @JoinColumn(name ="chromosomePlotId")
    private Collection<LineChromosomePlot> chromosomePlotLines;


}
