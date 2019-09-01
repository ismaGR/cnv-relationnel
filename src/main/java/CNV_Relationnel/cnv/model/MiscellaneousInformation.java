package CNV_Relationnel.cnv.model;


//import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Miscellaneous_Information")
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString*/
public class MiscellaneousInformation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long miscellaneousInfoId;

    @OneToOne
    @JoinColumn(name = "sampleAnalysisId")
    private SampleAnalysis sampleAnalysis;

    @OneToOne
    @JoinColumn(name = "dataSummaryId")
    private DataSummary dataSummary;

    @OneToOne
    @JoinColumn(name = "affymetrixParameterId")
    private AffymetrixParameter affymetrixParameter;

    @OneToOne
    @JoinColumn(name = "eaconParameterId")
    private EaCoNParameter eaCoNParameter;

    public SampleAnalysis getSampleAnalysis() {
        return sampleAnalysis;
    }

    public void setSampleAnalysis(SampleAnalysis sampleAnalysis) {
        this.sampleAnalysis = sampleAnalysis;
    }

    public DataSummary getDataSummary() {
        return dataSummary;
    }

    public void setDataSummary(DataSummary dataSummary) {
        this.dataSummary = dataSummary;
    }

    public AffymetrixParameter getAffymetrixParameter() {
        return affymetrixParameter;
    }

    public void setAffymetrixParameter(AffymetrixParameter affymetrixParameter) {
        this.affymetrixParameter = affymetrixParameter;
    }

    public EaCoNParameter getEaCoNParameter() {
        return eaCoNParameter;
    }

    public void setEaCoNParameter(EaCoNParameter eaCoNParameter) {
        this.eaCoNParameter = eaCoNParameter;
    }

    public MiscellaneousInformation() {
    }

    public Long getMiscellaneousInfoId() {
        return miscellaneousInfoId;
    }

    public MiscellaneousInformation(SampleAnalysis sampleAnalysis, DataSummary dataSummary, AffymetrixParameter affymetrixParameter, EaCoNParameter eaCoNParameter) {
        this.sampleAnalysis = sampleAnalysis;
        this.dataSummary = dataSummary;
        this.affymetrixParameter = affymetrixParameter;
        this.eaCoNParameter = eaCoNParameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MiscellaneousInformation that = (MiscellaneousInformation) o;
        return Objects.equals(miscellaneousInfoId, that.miscellaneousInfoId) &&
                Objects.equals(sampleAnalysis, that.sampleAnalysis) &&
                Objects.equals(dataSummary, that.dataSummary) &&
                Objects.equals(affymetrixParameter, that.affymetrixParameter) &&
                Objects.equals(eaCoNParameter, that.eaCoNParameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(miscellaneousInfoId, sampleAnalysis, dataSummary, affymetrixParameter, eaCoNParameter);
    }
}
