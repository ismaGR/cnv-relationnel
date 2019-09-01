package CNV_Relationnel.cnv.service;

import CNV_Relationnel.cnv.model.Gene;
import CNV_Relationnel.cnv.model.SampleAnalysis;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface GeneService {

    public Collection<Gene> getAllGenes();
    Collection<Gene> findBySampleAnalysis(SampleAnalysis sampleAnalysis);

    void delete(Long Id);
    void deleteAll();
    void insertGene(File filePath, boolean isTruncatedGene, SampleAnalysis sampleAnalysis) throws IOException;

    List<Gene> findBySampleNameAndIsTruncatedGene(String sampleName, Boolean isTruncatedGene);

    //List<Gene> GetGenesInSegmentBAF(Long sampleAnalysisId, String chrom, Integer segmentBAFStart, Integer segmentBAFEnd);
}
