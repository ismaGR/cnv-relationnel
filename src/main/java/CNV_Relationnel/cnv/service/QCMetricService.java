package CNV_Relationnel.cnv.service;

import CNV_Relationnel.cnv.model.Batch;
import CNV_Relationnel.cnv.model.QCMetric;
import CNV_Relationnel.cnv.model.SampleAnalysis;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public interface QCMetricService {
    Collection<QCMetric> getAllQCMetric();

    void deleteAll();
    public QCMetric save(QCMetric entity);

    void insertQCMetric(File filePath, SampleAnalysis sampleAnalysis, Batch batch) throws IOException;
}
