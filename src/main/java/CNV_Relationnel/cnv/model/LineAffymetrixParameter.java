package CNV_Relationnel.cnv.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LineAffymetrixParameter implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineAffymetrixParameterId;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "value")
    private String paramValue;
}
