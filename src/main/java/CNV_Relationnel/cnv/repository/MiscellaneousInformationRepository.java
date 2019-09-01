package CNV_Relationnel.cnv.repository;

import CNV_Relationnel.cnv.model.MiscellaneousInformation;
import CNV_Relationnel.cnv.model.SampleAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MiscellaneousInformationRepository extends JpaRepository<MiscellaneousInformation, Long> {
    public MiscellaneousInformation findBySampleAnalysis(SampleAnalysis sampleAnalysis);


    /* 	//public MiscellaneousInformation save(MiscellaneousInformation entity); */
}
