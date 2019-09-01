package CNV_Relationnel.cnv.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Gene")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Gene implements Serializable {

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




}
