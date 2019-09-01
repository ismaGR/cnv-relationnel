package CNV_Relationnel.cnv.repository;

import CNV_Relationnel.cnv.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BatchRepository extends JpaRepository<Batch, Long> {

    public Batch findByBatchId(Long batchId);


}

