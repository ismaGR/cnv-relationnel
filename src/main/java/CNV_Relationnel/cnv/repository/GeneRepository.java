package CNV_Relationnel.cnv.repository;

import CNV_Relationnel.cnv.model.Gene;
import CNV_Relationnel.cnv.model.SampleAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface GeneRepository extends JpaRepository<Gene, Long> {

    public List<Gene> findBySampleNameAndIsTruncatedGene(String sampleName, Boolean IsTruncatedGene);
    public Gene findByGeneId(Long geneId);
    public Gene findByGeneSymbol(String GeneSymbol);
    public List<Gene> findBySampleName(String string);

    public List<Gene> findBySampleAnalysis( SampleAnalysis sampleAnalysis);

}
