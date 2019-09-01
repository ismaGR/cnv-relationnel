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
public class LineDataSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineDataSummaryId;

    @Column(name = "parameter")
    private String parameter;

    @Column(name = "value")
    private String paramValue;
}
