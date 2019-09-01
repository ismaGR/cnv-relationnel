package CNV_Relationnel.cnv.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/*import lombok.*;*/
import java.util.Collection;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "Sample_Analysis")
/*@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode*/
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
    @JsonIgnore
    private Collection<Instability> instability /*= new ArrayList<>()*/;


    @OneToMany(mappedBy="sampleAnalysis",fetch=FetchType.LAZY)
    @JsonIgnore
    private List<QCMetric> qcMetric /*= new ArrayList<>()*/;


    public Long getSampleAnalysisId() {
        return sampleAnalysisId;
    }




    public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public GenomicPlot getGenomicPlot() {
        return genomicPlot;
    }

    public void setGenomicPlot(GenomicPlot genomicPlot) {
        this.genomicPlot = genomicPlot;
    }

    public MicroArray getMicroArray() {
        return microArray;
    }

    public void setMicroArray(MicroArray microArray) {
        this.microArray = microArray;
    }

    public ChromosomePlot getChromosomePlot() {
        return chromosomePlot;
    }

    public void setChromosomePlot(ChromosomePlot chromosomePlot) {
        this.chromosomePlot = chromosomePlot;
    }

    public Collection<Instability> getInstability() {
        return instability;
    }

    public void setInstability(Collection<Instability> instability) {
        this.instability = instability;
    }

    public List<QCMetric> getQcMetric() {
        return qcMetric;
    }

    public void setQcMetric(List<QCMetric> qcMetric) {
        this.qcMetric = qcMetric;
    }

    public SampleAnalysis() {
    }

    public SampleAnalysis(Batch batch, String sampleName, Comments comments, GenomicPlot genomicPlot, MicroArray microArray, ChromosomePlot chromosomePlot, Collection<Instability> instability, List<QCMetric> qcMetric) {
        this.batch = batch;
        this.sampleName = sampleName;
        this.comments = comments;
        this.genomicPlot = genomicPlot;
        this.microArray = microArray;
        this.chromosomePlot = chromosomePlot;
        this.instability = instability;
        this.qcMetric = qcMetric;
    }

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
