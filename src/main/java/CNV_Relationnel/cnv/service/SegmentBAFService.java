package CNV_Relationnel.cnv.service;

import CNV_Relationnel.cnv.model.SampleAnalysis;
import CNV_Relationnel.cnv.model.SegmentBAF;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface SegmentBAFService {

    Collection<SegmentBAF> getAllSegmentBAFs();

    List<SegmentBAF> findBySampleName(String sampleName);

    void deleteAll();
    void insertSegmentBAF(File filePath, SampleAnalysis sampleAnalysis) throws IOException;

}
