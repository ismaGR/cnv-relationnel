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
public class DataSummary implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long dataSummaryId;


    @OneToMany/*(fetch = FetchType.EAGER)*/
    @JoinColumn(name = "dataSummaryId")
    private Collection<LineDataSummary> dataSummaryLines /*= new ArrayList<>()*/;

}
