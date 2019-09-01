package CNV_Relationnel.cnv.repository;

import CNV_Relationnel.cnv.model.Instability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface InstabilityRepository extends JpaRepository<Instability, Long> {

	/*public List<Instability> findBySampleName(String sampleName);

   // public List<Instability> findBySampleAnalysisId(Long sampleAnalysisId);*/


}
