package CNV_Relationnel.cnv.service;

import CNV_Relationnel.cnv.model.Instability;
import CNV_Relationnel.cnv.model.SampleAnalysis;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public interface InstabilityService {

    Collection<Instability> getAllInstability();

    void deleteAll();
    public Instability save(Instability entity);
    void insertInstab(File filePath, SampleAnalysis sampleAnalysis) throws IOException;
}
