package CNV_Relationnel.cnv.service;

import CNV_Relationnel.cnv.model.SampleAnalysis;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface SampleAnalysisService {

    Collection<SampleAnalysis> getAllSamplesAnalysis();

    SampleAnalysis findBySampleName(String sampleName);

    SampleAnalysis findBySampleAnalysisId(Long sampleAnalysisId);

    void deleteAll();
    void save(SampleAnalysis entity);
    void insertMicroarray(File filePath, SampleAnalysis sampleAnalysis, String microarrayPlotPath) throws IOException;
    void insertGenomicPlot(String pathFileBAF, String pathFileL2R, String pathFileL2RBAF, SampleAnalysis sampleAnalysis);
    void insertChromosomePlot(List<String> ChromosomesFile, SampleAnalysis sampleAnalysis);
}
