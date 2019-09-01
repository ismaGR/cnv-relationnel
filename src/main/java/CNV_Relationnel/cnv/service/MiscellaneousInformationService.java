package CNV_Relationnel.cnv.service;

import CNV_Relationnel.cnv.model.Batch;
import CNV_Relationnel.cnv.model.MiscellaneousInformation;
import CNV_Relationnel.cnv.model.SampleAnalysis;

import java.io.File;
import java.io.IOException;

public interface MiscellaneousInformationService {
    void deleteAll();
    public MiscellaneousInformation save(MiscellaneousInformation entity);

    public MiscellaneousInformation findBySampleAnalysis(SampleAnalysis sampleAnalysisId);

    void insertMiscellaneousInfo(File filePath, SampleAnalysis sampleAnalysis, Batch batch) throws IOException;
}
