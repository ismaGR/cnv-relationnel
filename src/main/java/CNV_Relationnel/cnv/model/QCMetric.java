package CNV_Relationnel.cnv.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "QC_metric")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class QCMetric implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long qcMetricId;

    @ManyToOne/*(name = "sample_analysis_id")*/
    public SampleAnalysis sampleAnalysis;

    @Column(name = "sample_name")
    public String sampleName;

    @Column(name = "batch_name")
    public String batchName;

    @Column(name = "MAPD")
    public Float mapd;

    @Column(name = "IQR")
    public Float iqr;

    @Column(name = "SNPQC")
    public Float snpqc;

    @Column(name = "waviness_SD")
    public Float wavinessSD;

    @Column(name = "Predicted_gender")
    public String predictedGender;

    @Column(name = "Median_raw_intensity")
    public Integer medRawIntensity;

    @Column(name = "Outliers")
    public Integer Outlier;

    @Column(name = "nb_breakpoint")
    public Integer nbBreakpoint;

    @OneToOne
    @JoinColumn(name = "commentId")
    private Comments comments;


    /**
     * @param qcMetricId
     * @param sampleAnalysisId
     * @param sampleName
     * @param batchName
     * @param mapd
     * @param iqr
     * @param snpqc
     * @param wavinessSD
     * @param predictedGender
     * @param medRawIntensity
     * @param outlier
     * @param nbBreakpoint
     * @param comments
     */


}

