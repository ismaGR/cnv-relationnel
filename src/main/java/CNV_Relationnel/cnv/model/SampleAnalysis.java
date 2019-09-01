package CNV_Relationnel.cnv.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Sample_Analysis")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SampleAnalysis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long sampleAnalysisId;

    @ManyToOne
    private Batch batch;

    @Column(name = "sample_name")
    public String sampleName;


    @OneToOne
    @JoinColumn(name = "commentId")
    private Comments comments;

    @OneToOne
    @JoinColumn(name = "genomicPlotId")
    private GenomicPlot genomicPlot;

    @OneToOne
    @JoinColumn(name = "microArrayId")
    private MicroArray microArray;


    @OneToOne
    @JoinColumn(name = "chromosomePlotId")
    private ChromosomePlot chromosomePlot;


    @OneToMany(mappedBy = "sampleAnalysis", fetch = FetchType.LAZY)
    private Collection<Instability> instability /*= new ArrayList<>()*/;


    @OneToMany(mappedBy="sampleAnalysis",fetch=FetchType.LAZY)
    private List<QCMetric> qcMetric /*= new ArrayList<>()*/;


    /**
     * @param sampleAnalysisId
     * @param sampleName
     * @param microarrays
     * @param genomicPlot
     * @param listChromosomePlots
     * @param listComments
     * @param instability
     * @param qcMetric
     */


}
