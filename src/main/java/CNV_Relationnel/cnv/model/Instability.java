package CNV_Relationnel.cnv.model;

import javax.persistence.*;
//import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class Instability implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instabilityId;

    @ManyToOne
    @JoinColumn(name="sampleAnalysisId", nullable=false)
    private SampleAnalysis sampleAnalysis;

    @Column(name = "sample_name")
    private String sampleName;

    @Column(name = "CNA_status")
    private String CNAStatus;

    @Column(name = "nb_segments")
    private Integer nbSegments;

    @Column(name = "total_width")
    private Long totalWidth;

    @Column(name = "genome_fraction")
    private Double genomeFraction;

    @Column(name = "median_width")
    private Long medianWidth;

    @Column(name = "median_log2_ratio")
    private Double medianLog2Ratio;

    public Long getInstabilityId() {
        return instabilityId;
    }

    public SampleAnalysis getSampleAnalysis() {
        return sampleAnalysis;
    }

    public void setSampleAnalysis(SampleAnalysis sampleAnalysis) {
        this.sampleAnalysis = sampleAnalysis;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getCNAStatus() {
        return CNAStatus;
    }

    public void setCNAStatus(String CNAStatus) {
        this.CNAStatus = CNAStatus;
    }

    public Integer getNbSegments() {
        return nbSegments;
    }

    public void setNbSegments(Integer nbSegments) {
        this.nbSegments = nbSegments;
    }

    public Long getTotalWidth() {
        return totalWidth;
    }

    public void setTotalWidth(Long totalWidth) {
        this.totalWidth = totalWidth;
    }

    public Double getGenomeFraction() {
        return genomeFraction;
    }

    public void setGenomeFraction(Double genomeFraction) {
        this.genomeFraction = genomeFraction;
    }

    public Long getMedianWidth() {
        return medianWidth;
    }

    public void setMedianWidth(Long medianWidth) {
        this.medianWidth = medianWidth;
    }

    public Double getMedianLog2Ratio() {
        return medianLog2Ratio;
    }

    public void setMedianLog2Ratio(Double medianLog2Ratio) {
        this.medianLog2Ratio = medianLog2Ratio;
    }

    public Instability(SampleAnalysis sampleAnalysis, String sampleName, String CNAStatus, Integer nbSegments, Long totalWidth, Double genomeFraction, Long medianWidth, Double medianLog2Ratio) {
        this.sampleAnalysis = sampleAnalysis;
        this.sampleName = sampleName;
        this.CNAStatus = CNAStatus;
        this.nbSegments = nbSegments;
        this.totalWidth = totalWidth;
        this.genomeFraction = genomeFraction;
        this.medianWidth = medianWidth;
        this.medianLog2Ratio = medianLog2Ratio;
    }

    public Instability() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instability that = (Instability) o;
        return Objects.equals(instabilityId, that.instabilityId) &&
                Objects.equals(sampleAnalysis, that.sampleAnalysis) &&
                Objects.equals(sampleName, that.sampleName) &&
                Objects.equals(CNAStatus, that.CNAStatus) &&
                Objects.equals(nbSegments, that.nbSegments) &&
                Objects.equals(totalWidth, that.totalWidth) &&
                Objects.equals(genomeFraction, that.genomeFraction) &&
                Objects.equals(medianWidth, that.medianWidth) &&
                Objects.equals(medianLog2Ratio, that.medianLog2Ratio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instabilityId, sampleAnalysis, sampleName, CNAStatus, nbSegments, totalWidth, genomeFraction, medianWidth, medianLog2Ratio);
    }
}

