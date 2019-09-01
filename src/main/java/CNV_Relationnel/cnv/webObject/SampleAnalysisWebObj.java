package CNV_Relationnel.cnv.webObject;

import lombok.Data;

@Data
public class SampleAnalysisWebObj {

    private Long sampleAnalysisId;

    public String sampleName; //in collection sample_analysis

    public SampleAnalysisWebObj() {
        super();
    }

    public SampleAnalysisWebObj(Long sampleAnalysisId, String sampleName) {
        super();
        this.sampleAnalysisId = sampleAnalysisId;
        this.sampleName = sampleName;
    }


}
