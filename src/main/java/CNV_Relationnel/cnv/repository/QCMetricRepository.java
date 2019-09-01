package CNV_Relationnel.cnv.repository;

import CNV_Relationnel.cnv.model.QCMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface QCMetricRepository extends JpaRepository<QCMetric, Long> {



	/*public List<QCMetric> findBySampleName(String sampleName);

	//public List<QCMetric> findBySampleAnalysisId(Long sampleAnalysisId);

	//public QCMetric save(QCMetric entity);*/
}
