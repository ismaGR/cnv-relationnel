package CNV_Relationnel.cnv.repository;

import CNV_Relationnel.cnv.model.SegmentBAF;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SegmentBAFRepository extends JpaRepository<SegmentBAF, Long> {
    List<SegmentBAF> findBySampleName(String sampleName);

	/*public SegmentBAF findBySegmentBAFId(Long segmentBAFId);


	public List<SegmentBAF> findBySampleAnalysisId(Long sampleAnalysisId);*/
}
