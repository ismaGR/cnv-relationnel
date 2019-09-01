package CNV_Relationnel.cnv.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class LineComment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lineCommentId;


    @Column(name = "author")
    private String author;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "content")
    private String content;



    /*@ManyToOne
    @JoinColumn (name="sampleAnalysisId")
    private SampleAnalysis sampleAnalysis;*/
}

