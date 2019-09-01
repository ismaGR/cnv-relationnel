package CNV_Relationnel.cnv.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SegmentL2R")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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


}
