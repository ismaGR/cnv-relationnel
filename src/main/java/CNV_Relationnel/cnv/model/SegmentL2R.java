package CNV_Relationnel.cnv.model;


/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;*/

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "SegmentL2R")
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
public class SegmentL2R implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long segmentL2RId;

    @Column(name = "chrom")
    private String chrom;

    @Column(name = "chr")
    private String chr;

    @Column(name = "sample_name")
    private String sampleName;

    /* @Column(name = "sample_analysis_id")*/
    @OneToOne
    @JoinColumn(name = "sample_analysis_id")
    private SampleAnalysis sampleAnalysis;

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

    @Column(name = "segment_L2R_status")
    private String segmentL2RStatus;

    @Column(name = "segment_L2R_value")
    private Float segmentL2RValue;

    @Column(name = "segment_L2R_ratio")
    private Float segmentL2RRatio;

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

    public SegmentL2R() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SegmentL2R that = (SegmentL2R) o;
        return Objects.equals(segmentL2RId, that.segmentL2RId) &&
                Objects.equals(chrom, that.chrom) &&
                Objects.equals(chr, that.chr) &&
                Objects.equals(sampleName, that.sampleName) &&
                Objects.equals(sampleAnalysis, that.sampleAnalysis) &&
                Objects.equals(segmentStart, that.segmentStart) &&
                Objects.equals(segmentEnd, that.segmentEnd) &&
                Objects.equals(segmentWidth, that.segmentWidth) &&
                Objects.equals(segmentStartCytoband, that.segmentStartCytoband) &&
                Objects.equals(segmentEndCytoband, that.segmentEndCytoband) &&
                Objects.equals(segmentL2RStatus, that.segmentL2RStatus) &&
                Objects.equals(segmentL2RValue, that.segmentL2RValue) &&
                Objects.equals(segmentL2RRatio, that.segmentL2RRatio) &&
                Objects.equals(nbMarkers, that.nbMarkers) &&
                Objects.equals(nbGenes, that.nbGenes) &&
                Objects.equals(isInClinicalReport, that.isInClinicalReport) &&
                Objects.equals(segmentFocality, that.segmentFocality) &&
                Objects.equals(segmentPloidy, that.segmentPloidy) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segmentL2RId, chrom, chr, sampleName, sampleAnalysis, segmentStart, segmentEnd, segmentWidth, segmentStartCytoband, segmentEndCytoband, segmentL2RStatus, segmentL2RValue, segmentL2RRatio, nbMarkers, nbGenes, isInClinicalReport, segmentFocality, segmentPloidy, comments);
    }



    public SegmentL2R(String chrom, String chr, String sampleName, SampleAnalysis sampleAnalysis, Integer segmentStart, Integer segmentEnd, Integer segmentWidth, String segmentStartCytoband, String segmentEndCytoband, String segmentL2RStatus, Float segmentL2RValue, Float segmentL2RRatio, Integer nbMarkers, Integer nbGenes, Boolean isInClinicalReport, String segmentFocality, String segmentPloidy, Comments comments) {
        this.chrom = chrom;
        this.chr = chr;
        this.sampleName = sampleName;
        this.sampleAnalysis = sampleAnalysis;
        this.segmentStart = segmentStart;
        this.segmentEnd = segmentEnd;
        this.segmentWidth = segmentWidth;
        this.segmentStartCytoband = segmentStartCytoband;
        this.segmentEndCytoband = segmentEndCytoband;
        this.segmentL2RStatus = segmentL2RStatus;
        this.segmentL2RValue = segmentL2RValue;
        this.segmentL2RRatio = segmentL2RRatio;
        this.nbMarkers = nbMarkers;
        this.nbGenes = nbGenes;
        this.isInClinicalReport = isInClinicalReport;
        this.segmentFocality = segmentFocality;
        this.segmentPloidy = segmentPloidy;
        this.comments = comments;
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

    public Integer getSegmentStart() {
        return segmentStart;
    }

    public void setSegmentStart(Integer segmentStart) {
        this.segmentStart = segmentStart;
    }

    public Boolean getIsInClinicalReport() {
		return isInClinicalReport;
	}

	public void setIsInClinicalReport(Boolean isInClinicalReport) {
		this.isInClinicalReport = isInClinicalReport;
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

    public Long getSegmentL2RId() {
        return segmentL2RId;
    }

    public String getSegmentEndCytoband() {
        return segmentEndCytoband;
    }

    public void setSegmentEndCytoband(String segmentEndCytoband) {
        this.segmentEndCytoband = segmentEndCytoband;
    }

    public String getSegmentL2RStatus() {
        return segmentL2RStatus;
    }

    public void setSegmentL2RStatus(String segmentL2RStatus) {
        this.segmentL2RStatus = segmentL2RStatus;
    }

    public Float getSegmentL2RValue() {
        return segmentL2RValue;
    }

    public void setSegmentL2RValue(Float segmentL2RValue) {
        this.segmentL2RValue = segmentL2RValue;
    }

    public Float getSegmentL2RRatio() {
        return segmentL2RRatio;
    }

    public void setSegmentL2RRatio(Float segmentL2RRatio) {
        this.segmentL2RRatio = segmentL2RRatio;
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
}
