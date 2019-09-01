package CNV_Relationnel.cnv.model;

/*import lombok.*;*/


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
public class MicroArray implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long microArrayId;



    @OneToMany
    @JoinColumn(name ="microArrayId")
    @JsonIgnore
    private Collection<LineMicroarray> microarrayLines ;//= new ArrayList<>();

    public Long getMicroArrayId() {
        return microArrayId;
    }

    public Collection<LineMicroarray> getMicroarrayLines() {
        return microarrayLines;
    }

    public void setMicroarrayLines(Collection<LineMicroarray> microarrayLines) {
        this.microarrayLines = microarrayLines;
    }

    public MicroArray() {
    }

    public MicroArray(Collection<LineMicroarray> microarrayLines) {
        this.microarrayLines = microarrayLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MicroArray that = (MicroArray) o;
        return Objects.equals(microArrayId, that.microArrayId) &&
                Objects.equals(microarrayLines, that.microarrayLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(microArrayId, microarrayLines);
    }
}
