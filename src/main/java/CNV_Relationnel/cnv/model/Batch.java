package CNV_Relationnel.cnv.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "Batch")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Batch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long batchId;

    @Column(name = "batch_name")
    public String batchName;

    @Column(name = "batch_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date batchDate;

    @Column(name = "batch_instrument")
    public String batchInstrument;

    @Column(name = "batch_technology")
    public String batchTechnology;

    @Column(name = "batch_detail")
    public String batchDetail;

    @Column(name = "is_valid")
    public boolean isValid;

    @OneToOne
    @JoinColumn(name = "commentId")
    private Comments comments;


    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<SampleAnalysis> sampleAnalysisList ;

    /**
     * @param batchId
     * @param batchName
     * @param batchDate
     * @param batchInstrument
     * @param batchTechnology
     * @param batchDetail
     * @param sampleName
     * @param isValid
     * @param comments
     * @param sampleAnalysisList
     */
}

