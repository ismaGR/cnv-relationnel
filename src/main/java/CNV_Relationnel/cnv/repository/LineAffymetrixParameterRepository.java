package CNV_Relationnel.cnv.repository;

import CNV_Relationnel.cnv.model.LineAffymetrixParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LineAffymetrixParameterRepository extends JpaRepository<LineAffymetrixParameter, Long> {
}
