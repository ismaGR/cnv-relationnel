package CNV_Relationnel.cnv.model;


/*import lombok.*;*/

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Gene")
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
public class Gene implements Serializable {

    public Long getGeneId() {
		return geneId;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long geneId;

    @Column(name = "sample_name")
    private String sampleName;

     @OneToOne
     @JoinColumn(name = "sampleAnalysisId")
     private SampleAnalysis sampleAnalysis;

    @OneToOne
    @JoinColumn(name = "commentId")
    private Comments comments;

    @Column(name = "gene_symbol")
    private String geneSymbol;

    @Column(name = "gene_start")
    private Integer geneStart;

    @Column(name = "gene_end")
    private Integer geneEnd;

    @Column(name = "gene_width")
    private Integer geneWidth;

    @Column(name = "gene_chromosome")
    private String geneChromosome;

    @Column(name = "gene_strand")
    private String geneStrand;

    @Column(name = "gene_cytoband")
    private String geneCytoband;

    @Column(name = "match_start")
    private Integer matchStart;

    @Column(name = "match_end")
    private Integer matchEnd;

    @Column(name = "match_width")
    private Integer matchWidth;

    @Column(name = "gene_L2R_status")
    private String geneL2RStatus;

    @Column(name = "gene_L2R_value")
    private Float geneL2RValue;

    @Column(name = "L2R_segment_width")
    private Integer L2RSegmentWidth;

    @Column(name = "gene_BAF_status")
    private String geneBAFStatus;

    @Column(name = "gene_BAF_value")
    private Float geneBAFValue;

    @Column(name = "BAF_segment_width")
    private Integer BAFSegmentWidth;

    @Column(name = "is_truncated_gene")
    private boolean isTruncatedGene;

    @Column(name = "is_in_clinical_report")
    private boolean isInClinicalReport;

  

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

	public Comments getComments() {
		return comments;
	}

	public void setComments(Comments comments) {
		this.comments = comments;
	}

	public String getGeneSymbol() {
		return geneSymbol;
	}

	public void setGeneSymbol(String geneSymbol) {
		this.geneSymbol = geneSymbol;
	}

	public Integer getGeneStart() {
		return geneStart;
	}

	public void setGeneStart(Integer geneStart) {
		this.geneStart = geneStart;
	}

	public Integer getGeneEnd() {
		return geneEnd;
	}

	public void setGeneEnd(Integer geneEnd) {
		this.geneEnd = geneEnd;
	}

	public Integer getGeneWidth() {
		return geneWidth;
	}

	public void setGeneWidth(Integer geneWidth) {
		this.geneWidth = geneWidth;
	}

	public String getGeneChromosome() {
		return geneChromosome;
	}

	public void setGeneChromosome(String geneChromosome) {
		this.geneChromosome = geneChromosome;
	}

	public String getGeneStrand() {
		return geneStrand;
	}

	public void setGeneStrand(String geneStrand) {
		this.geneStrand = geneStrand;
	}

	public String getGeneCytoband() {
		return geneCytoband;
	}

	public void setGeneCytoband(String geneCytoband) {
		this.geneCytoband = geneCytoband;
	}

	public Integer getMatchStart() {
		return matchStart;
	}

	public void setMatchStart(Integer matchStart) {
		this.matchStart = matchStart;
	}

	public Integer getMatchEnd() {
		return matchEnd;
	}

	public void setMatchEnd(Integer matchEnd) {
		this.matchEnd = matchEnd;
	}

	public Integer getMatchWidth() {
		return matchWidth;
	}

	public void setMatchWidth(Integer matchWidth) {
		this.matchWidth = matchWidth;
	}

	public String getGeneL2RStatus() {
		return geneL2RStatus;
	}

	public void setGeneL2RStatus(String geneL2RStatus) {
		this.geneL2RStatus = geneL2RStatus;
	}

	public Float getGeneL2RValue() {
		return geneL2RValue;
	}

	public void setGeneL2RValue(Float geneL2RValue) {
		this.geneL2RValue = geneL2RValue;
	}

	public Integer getL2RSegmentWidth() {
		return L2RSegmentWidth;
	}

	public void setL2RSegmentWidth(Integer l2rSegmentWidth) {
		L2RSegmentWidth = l2rSegmentWidth;
	}

	public String getGeneBAFStatus() {
		return geneBAFStatus;
	}

	public void setGeneBAFStatus(String geneBAFStatus) {
		this.geneBAFStatus = geneBAFStatus;
	}

	public Float getGeneBAFValue() {
		return geneBAFValue;
	}

	public void setGeneBAFValue(Float geneBAFValue) {
		this.geneBAFValue = geneBAFValue;
	}

	public Integer getBAFSegmentWidth() {
		return BAFSegmentWidth;
	}

	public void setBAFSegmentWidth(Integer bAFSegmentWidth) {
		BAFSegmentWidth = bAFSegmentWidth;
	}

	public boolean isTruncatedGene() {
		return isTruncatedGene;
	}

	public void setTruncatedGene(boolean isTruncatedGene) {
		this.isTruncatedGene = isTruncatedGene;
	}

	public boolean isInClinicalReport() {
		return isInClinicalReport;
	}

	public void setInClinicalReport(boolean isInClinicalReport) {
		this.isInClinicalReport = isInClinicalReport;
	}

	public Gene() {
    }

    public Gene(String sampleName, SampleAnalysis sampleAnalysis, Comments comments, String geneSymbol, Integer geneStart, Integer geneEnd, Integer geneWidth, String geneChromosome, String geneStrand, String geneCytoband, Integer matchStart, Integer matchEnd, Integer matchWidth, String geneL2RStatus, Float geneL2RValue, Integer l2RSegmentWidth, String geneBAFStatus, Float geneBAFValue, Integer BAFSegmentWidth, boolean isTruncatedGene, boolean isInClinicalReport) {
        this.sampleName = sampleName;
        this.sampleAnalysis = sampleAnalysis;
        this.comments = comments;
        this.geneSymbol = geneSymbol;
        this.geneStart = geneStart;
        this.geneEnd = geneEnd;
        this.geneWidth = geneWidth;
        this.geneChromosome = geneChromosome;
        this.geneStrand = geneStrand;
        this.geneCytoband = geneCytoband;
        this.matchStart = matchStart;
        this.matchEnd = matchEnd;
        this.matchWidth = matchWidth;
        this.geneL2RStatus = geneL2RStatus;
        this.geneL2RValue = geneL2RValue;
        L2RSegmentWidth = l2RSegmentWidth;
        this.geneBAFStatus = geneBAFStatus;
        this.geneBAFValue = geneBAFValue;
        this.BAFSegmentWidth = BAFSegmentWidth;
        this.isTruncatedGene = isTruncatedGene;
        this.isInClinicalReport = isInClinicalReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gene gene = (Gene) o;
        return isTruncatedGene == gene.isTruncatedGene &&
                isInClinicalReport == gene.isInClinicalReport &&
                Objects.equals(geneId, gene.geneId) &&
                Objects.equals(sampleName, gene.sampleName) &&
                Objects.equals(sampleAnalysis, gene.sampleAnalysis) &&
                Objects.equals(comments, gene.comments) &&
                Objects.equals(geneSymbol, gene.geneSymbol) &&
                Objects.equals(geneStart, gene.geneStart) &&
                Objects.equals(geneEnd, gene.geneEnd) &&
                Objects.equals(geneWidth, gene.geneWidth) &&
                Objects.equals(geneChromosome, gene.geneChromosome) &&
                Objects.equals(geneStrand, gene.geneStrand) &&
                Objects.equals(geneCytoband, gene.geneCytoband) &&
                Objects.equals(matchStart, gene.matchStart) &&
                Objects.equals(matchEnd, gene.matchEnd) &&
                Objects.equals(matchWidth, gene.matchWidth) &&
                Objects.equals(geneL2RStatus, gene.geneL2RStatus) &&
                Objects.equals(geneL2RValue, gene.geneL2RValue) &&
                Objects.equals(L2RSegmentWidth, gene.L2RSegmentWidth) &&
                Objects.equals(geneBAFStatus, gene.geneBAFStatus) &&
                Objects.equals(geneBAFValue, gene.geneBAFValue) &&
                Objects.equals(BAFSegmentWidth, gene.BAFSegmentWidth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(geneId, sampleName, sampleAnalysis, comments, geneSymbol, geneStart, geneEnd, geneWidth, geneChromosome, geneStrand, geneCytoband, matchStart, matchEnd, matchWidth, geneL2RStatus, geneL2RValue, L2RSegmentWidth, geneBAFStatus, geneBAFValue, BAFSegmentWidth, isTruncatedGene, isInClinicalReport);
    }
}
