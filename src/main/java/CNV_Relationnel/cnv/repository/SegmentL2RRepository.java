package CNV_Relationnel.cnv.repository;

import CNV_Relationnel.cnv.model.SegmentL2R;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SegmentL2RRepository extends JpaRepository<SegmentL2R, Long> {
    public List<SegmentL2R> findBySampleName(String sampleName);


	/*public SegmentL2R findBySegmentL2RId(Long segmentL2RId);


	public List<SegmentL2R> findBySampleAnalysisId(Long sampleAnalysisId);*/

}
