package CNV_Relationnel.cnv.model;


/*import lombok.*;*/

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "Batch")
/*@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode*/
public class Batch implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long batchId;

    @Column(name = "batch_name")
    public String batchName;

    @Column(name = "batch_date")
    @Temporal(TemporalType.TIMESTAMP)
    public Date batchDate;

    @Column(name = "batch_instrument")
    public String batchInstrument;

    @Column(name = "batch_technology")
    public String batchTechnology;

    @Column(name = "batch_detail")
    public String batchDetail;

    @Column(name = "is_valid")
    public boolean isValid;

    @OneToOne
    @JoinColumn(name = "commentId")
    private Comments comments;


    @OneToMany(mappedBy = "batch", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private Collection<SampleAnalysis> sampleAnalysisList ;

    public Long getBatchId() {
        return batchId;
    }

    public String getBatchName() {
        return batchName;
    }

    public void setBatchName(String batchName) {
        this.batchName = batchName;
    }

    public Date getBatchDate() {
        return batchDate;
    }

    public void setBatchDate(Date batchDate) {
        this.batchDate = batchDate;
    }

    public String getBatchInstrument() {
        return batchInstrument;
    }

    public void setBatchInstrument(String batchInstrument) {
        this.batchInstrument = batchInstrument;
    }

    public String getBatchTechnology() {
        return batchTechnology;
    }

    public void setBatchTechnology(String batchTechnology) {
        this.batchTechnology = batchTechnology;
    }

    public String getBatchDetail() {
        return batchDetail;
    }

    public void setBatchDetail(String batchDetail) {
        this.batchDetail = batchDetail;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Collection<SampleAnalysis> getSampleAnalysisList() {
        return sampleAnalysisList;
    }

    public void setSampleAnalysisList(Collection<SampleAnalysis> sampleAnalysisList) {
        this.sampleAnalysisList = sampleAnalysisList;
    }

    public Batch() {
    }

    public Batch(String batchName, Date batchDate, String batchInstrument, String batchTechnology, String batchDetail, boolean isValid, Comments comments, Collection<SampleAnalysis> sampleAnalysisList) {
        this.batchName = batchName;
        this.batchDate = batchDate;
        this.batchInstrument = batchInstrument;
        this.batchTechnology = batchTechnology;
        this.batchDetail = batchDetail;
        this.isValid = isValid;
        this.comments = comments;
        this.sampleAnalysisList = sampleAnalysisList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return isValid == batch.isValid &&
                Objects.equals(batchId, batch.batchId) &&
                Objects.equals(batchName, batch.batchName) &&
                Objects.equals(batchDate, batch.batchDate) &&
                Objects.equals(batchInstrument, batch.batchInstrument) &&
                Objects.equals(batchTechnology, batch.batchTechnology) &&
                Objects.equals(batchDetail, batch.batchDetail) &&
                Objects.equals(comments, batch.comments) &&
                Objects.equals(sampleAnalysisList, batch.sampleAnalysisList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batchId, batchName, batchDate, batchInstrument, batchTechnology, batchDetail, isValid, comments, sampleAnalysisList);
    }

    /**
     * @param batchId
     * @param batchName
     * @param batchDate
     * @param batchInstrument
     * @param batchTechnology
     * @param batchDetail
     * @param sampleName
     * @param isValid
     * @param comments
     * @param sampleAnalysisList
     */
}

