package CNV_Relationnel.cnv.model;


/*import lombok.*;*/

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Segment_BAF")
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
public class SegmentBAF implements Serializable {

    public Boolean getIsInClinicalReport() {
		return isInClinicalReport;
	}

	public void setIsInClinicalReport(Boolean isInClinicalReport) {
		this.isInClinicalReport = isInClinicalReport;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long segmentBAFId;

    public Long getSegmentBAFId() {
        return segmentBAFId;
    }

    @Column(name = "sample_name")
    private String sampleName;

    /* @Column(name = "sample_analysis_id")*/
    @OneToOne
    @JoinColumn(name = "sample_analysis_id")
    private SampleAnalysis sampleAnalysis;

    @Column(name = "batch_name")
    private String batchName;

    @Column(name = "chrom")
    private String chrom;

    @Column(name = "chr")
    private String chr;

    @Column(name = "segment_start")
    private Integer segmentStart;

    @Column(name = "segment_end")
    private Integer segmentEnd;

    @Column(name = "segment_width")
    private Integer segmentWidth;

    @Column(name = "segment_start_cytoband")
    private String segmentStartCytoband;

    @Column(name = "segment_end_cytoband")
    private String segmentEndCytoband;

    @Column(name = "BAF_value")
    private Float BAFValue;

    @Column(name = "BAF_status")
    private String BAFStatus;

    @Column(name = "nb_markers")
    private Integer nbMarkers;

    @Column(name = "nb_genes")
    private Integer nbGenes;

    @Column(name = "is_in_clinical_report")
    private Boolean isInClinicalReport;

    @Column(name = "segment_focality")
    private String segmentFocality;

    @Column(name = "segment_ploidy")
    private String segmentPloidy;

    @OneToOne
    @JoinColumn(name = "commentId")
    private Comments comments;

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public SampleAnalysis getSampleAnalysis() {
        return sampleAnalysis;
    }

    public void setSampleAnalysis(SampleAnalysis sampleAnalysis) {
        this.sampleAnalysis = sampleAnalysis;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public String getChrom() {
        return chrom;
    }

    public void setChrom(String chrom) {
        this.chrom = chrom;
    }

    public String getChr() {
        return chr;
    }

    public void setChr(String chr) {
        this.chr = chr;
    }

    public Integer getSegmentStart() {
        return segmentStart;
    }

    public void setSegmentStart(Integer segmentStart) {
        this.segmentStart = segmentStart;
    }

    public Integer getSegmentEnd() {
        return segmentEnd;
    }

    public void setSegmentEnd(Integer segmentEnd) {
        this.segmentEnd = segmentEnd;
    }

    public Integer getSegmentWidth() {
        return segmentWidth;
    }

    public void setSegmentWidth(Integer segmentWidth) {
        this.segmentWidth = segmentWidth;
    }

    public String getSegmentStartCytoband() {
        return segmentStartCytoband;
    }

    public void setSegmentStartCytoband(String segmentStartCytoband) {
        this.segmentStartCytoband = segmentStartCytoband;
    }

    public String getSegmentEndCytoband() {
        return segmentEndCytoband;
    }

    public void setSegmentEndCytoband(String segmentEndCytoband) {
        this.segmentEndCytoband = segmentEndCytoband;
    }

    public Float getBAFValue() {
        return BAFValue;
    }

    public void setBAFValue(Float BAFValue) {
        this.BAFValue = BAFValue;
    }

    public String getBAFStatus() {
        return BAFStatus;
    }

    public void setBAFStatus(String BAFStatus) {
        this.BAFStatus = BAFStatus;
    }

    public Integer getNbMarkers() {
        return nbMarkers;
    }

    public void setNbMarkers(Integer nbMarkers) {
        this.nbMarkers = nbMarkers;
    }

    public Integer getNbGenes() {
        return nbGenes;
    }

    public void setNbGenes(Integer nbGenes) {
        this.nbGenes = nbGenes;
    }

    public Boolean getInClinicalReport() {
        return isInClinicalReport;
    }

    public void setInClinicalReport(Boolean inClinicalReport) {
        isInClinicalReport = inClinicalReport;
    }

    public String getSegmentFocality() {
        return segmentFocality;
    }

    public void setSegmentFocality(String segmentFocality) {
        this.segmentFocality = segmentFocality;
    }

    public String getSegmentPloidy() {
        return segmentPloidy;
    }

    public void setSegmentPloidy(String segmentPloidy) {
        this.segmentPloidy = segmentPloidy;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public SegmentBAF() {
    }

    public SegmentBAF(String sampleName, SampleAnalysis sampleAnalysis, String batchName, String chrom, String chr, Integer segmentStart, Integer segmentEnd, Integer segmentWidth, String segmentStartCytoband, String segmentEndCytoband, Float BAFValue, String BAFStatus, Integer nbMarkers, Integer nbGenes, Boolean isInClinicalReport, String segmentFocality, String segmentPloidy, Comments comments) {
        this.sampleName = sampleName;
        this.sampleAnalysis = sampleAnalysis;
        this.batchName = batchName;
        this.chrom = chrom;
        this.chr = chr;
        this.segmentStart = segmentStart;
        this.segmentEnd = segmentEnd;
        this.segmentWidth = segmentWidth;
        this.segmentStartCytoband = segmentStartCytoband;
        this.segmentEndCytoband = segmentEndCytoband;
        this.BAFValue = BAFValue;
        this.BAFStatus = BAFStatus;
        this.nbMarkers = nbMarkers;
        this.nbGenes = nbGenes;
        this.isInClinicalReport = isInClinicalReport;
        this.segmentFocality = segmentFocality;
        this.segmentPloidy = segmentPloidy;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SegmentBAF that = (SegmentBAF) o;
        return Objects.equals(segmentBAFId, that.segmentBAFId) &&
                Objects.equals(sampleName, that.sampleName) &&
                Objects.equals(sampleAnalysis, that.sampleAnalysis) &&
                Objects.equals(batchName, that.batchName) &&
                Objects.equals(chrom, that.chrom) &&
                Objects.equals(chr, that.chr) &&
                Objects.equals(segmentStart, that.segmentStart) &&
                Objects.equals(segmentEnd, that.segmentEnd) &&
                Objects.equals(segmentWidth, that.segmentWidth) &&
                Objects.equals(segmentStartCytoband, that.segmentStartCytoband) &&
                Objects.equals(segmentEndCytoband, that.segmentEndCytoband) &&
                Objects.equals(BAFValue, that.BAFValue) &&
                Objects.equals(BAFStatus, that.BAFStatus) &&
                Objects.equals(nbMarkers, that.nbMarkers) &&
                Objects.equals(nbGenes, that.nbGenes) &&
                Objects.equals(isInClinicalReport, that.isInClinicalReport) &&
                Objects.equals(segmentFocality, that.segmentFocality) &&
                Objects.equals(segmentPloidy, that.segmentPloidy) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segmentBAFId, sampleName, sampleAnalysis, batchName, chrom, chr, segmentStart, segmentEnd, segmentWidth, segmentStartCytoband, segmentEndCytoband, BAFValue, BAFStatus, nbMarkers, nbGenes, isInClinicalReport, segmentFocality, segmentPloidy, comments);
    }
}

