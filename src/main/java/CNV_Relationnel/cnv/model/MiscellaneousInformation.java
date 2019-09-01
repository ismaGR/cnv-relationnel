package CNV_Relationnel.cnv.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Miscellaneous_Information")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
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




}
