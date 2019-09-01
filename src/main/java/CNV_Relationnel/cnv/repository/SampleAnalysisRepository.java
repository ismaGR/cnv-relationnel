package CNV_Relationnel.cnv.repository;

import CNV_Relationnel.cnv.model.SampleAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SampleAnalysisRepository extends JpaRepository<SampleAnalysis, Long> {

    public SampleAnalysis findBySampleName(String sampleName);

    public SampleAnalysis findBySampleAnalysisId(Long sampleAnalysisId);


    @SuppressWarnings("unchecked")
    public SampleAnalysis save(SampleAnalysis entity);

}
