package CNV_Relationnel.cnv.model;


/*import lombok.*;*/

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "QC_metric")
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
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

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Float getMapd() {
        return mapd;
    }

    public Long getQcMetricId() {
        return qcMetricId;
    }

    public void setMapd(Float mapd) {
        this.mapd = mapd;
    }

    public Float getIqr() {
        return iqr;
    }

    public void setIqr(Float iqr) {
        this.iqr = iqr;
    }

    public Float getSnpqc() {
        return snpqc;
    }

    public void setSnpqc(Float snpqc) {
        this.snpqc = snpqc;
    }

    public Float getWavinessSD() {
        return wavinessSD;
    }

    public void setWavinessSD(Float wavinessSD) {
        this.wavinessSD = wavinessSD;
    }

    public String getPredictedGender() {
        return predictedGender;
    }

    public void setPredictedGender(String predictedGender) {
        this.predictedGender = predictedGender;
    }

    public Integer getMedRawIntensity() {
        return medRawIntensity;
    }

    public void setMedRawIntensity(Integer medRawIntensity) {
        this.medRawIntensity = medRawIntensity;
    }

    public Integer getOutlier() {
        return Outlier;
    }

    public void setOutlier(Integer outlier) {
        Outlier = outlier;
    }

    public Integer getNbBreakpoint() {
        return nbBreakpoint;
    }

    public void setNbBreakpoint(Integer nbBreakpoint) {
        this.nbBreakpoint = nbBreakpoint;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public QCMetric() {
    }

    public QCMetric(SampleAnalysis sampleAnalysis, String sampleName, String batchName, Float mapd, Float iqr, Float snpqc, Float wavinessSD, String predictedGender, Integer medRawIntensity, Integer outlier, Integer nbBreakpoint, Comments comments) {
        this.sampleAnalysis = sampleAnalysis;
        this.sampleName = sampleName;
        this.batchName = batchName;
        this.mapd = mapd;
        this.iqr = iqr;
        this.snpqc = snpqc;
        this.wavinessSD = wavinessSD;
        this.predictedGender = predictedGender;
        this.medRawIntensity = medRawIntensity;
        Outlier = outlier;
        this.nbBreakpoint = nbBreakpoint;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QCMetric qcMetric = (QCMetric) o;
        return Objects.equals(qcMetricId, qcMetric.qcMetricId) &&
                Objects.equals(sampleAnalysis, qcMetric.sampleAnalysis) &&
                Objects.equals(sampleName, qcMetric.sampleName) &&
                Objects.equals(batchName, qcMetric.batchName) &&
                Objects.equals(mapd, qcMetric.mapd) &&
                Objects.equals(iqr, qcMetric.iqr) &&
                Objects.equals(snpqc, qcMetric.snpqc) &&
                Objects.equals(wavinessSD, qcMetric.wavinessSD) &&
                Objects.equals(predictedGender, qcMetric.predictedGender) &&
                Objects.equals(medRawIntensity, qcMetric.medRawIntensity) &&
                Objects.equals(Outlier, qcMetric.Outlier) &&
                Objects.equals(nbBreakpoint, qcMetric.nbBreakpoint) &&
                Objects.equals(comments, qcMetric.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(qcMetricId, sampleAnalysis, sampleName, batchName, mapd, iqr, snpqc, wavinessSD, predictedGender, medRawIntensity, Outlier, nbBreakpoint, comments);
    }

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

