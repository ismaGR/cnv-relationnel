package CNV_Relationnel.cnv.service.Impl;

import CNV_Relationnel.cnv.model.Batch;
import CNV_Relationnel.cnv.repository.BatchRepository;
import CNV_Relationnel.cnv.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value="BatchService")
public class BatchServiceImpl implements BatchService {

    @Autowired
    private BatchRepository batchRepository;

    @Override
    public void deleteAll() {
        batchRepository.deleteAll();
    }

    @Override
    public void save(Batch entity) {
        batchRepository.save(entity);
    }

    @Override
    public Batch findByBatchId(Long batchId) {
        return batchRepository.findByBatchId(batchId);
    }
}
