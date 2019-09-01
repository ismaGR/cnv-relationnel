package CNV_Relationnel.cnv.service;

import CNV_Relationnel.cnv.model.SampleAnalysis;
import CNV_Relationnel.cnv.model.SegmentL2R;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface SegmentL2RService {

    Collection<SegmentL2R> getAllSegmentL2Rs();

    List<SegmentL2R> findBySampleName(String sampleName);

    void deleteAll();
    void insertSegmentL2R(File filePath, SampleAnalysis sampleAnalysis) throws IOException;

}
