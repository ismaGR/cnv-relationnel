package CNV_Relationnel.cnv.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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


}

