package CNV_Relationnel.cnv.service;

import CNV_Relationnel.cnv.model.Batch;

public interface BatchService {
    void deleteAll();
    void save(Batch entity);

    public Batch findByBatchId(Long batchId);
}
