package CNV_Relationnel.cnv.service.Impl;


import CNV_Relationnel.cnv.model.*;
import CNV_Relationnel.cnv.repository.*;
import CNV_Relationnel.cnv.service.BatchService;
import CNV_Relationnel.cnv.service.MiscellaneousInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service(value = "MiscellaneousInformationService")
public class MiscellaneousInformationServiceImpl implements MiscellaneousInformationService {

    private static final Logger logger = LoggerFactory.getLogger(MiscellaneousInformationServiceImpl.class);

    @Autowired
    private MiscellaneousInformationRepository misInfoRepository;

    @Autowired
    private BatchService batchService;

    @Autowired
    private LineEaconParameterRespository lepDao;

    @Autowired
    private EaCoNParametetRepository epDao;

    @Autowired
    private AffymetrixParameterRepository apDao;

    @Autowired
    private DataSummaryRepository dsDao;

    @Autowired
    private LineAffymetrixParameterRepository lapDao;

    @Autowired
    private LineDataSummaryRepository ldsDao;

    @Override
    public void deleteAll() {
        misInfoRepository.deleteAll();
    }

    @Override
    public MiscellaneousInformation save(MiscellaneousInformation entity) {
        return misInfoRepository.save(entity);
    }

    @Override
    public void insertMiscellaneousInfo(File filePath, SampleAnalysis sampleAnalysis, Batch batch) throws IOException {
        this.insertMiscellaneousInfo(filePath,"\t",sampleAnalysis, batch);

    }

    /**
     * Insert Miscellaneous information files in collection MiscellaneousInformation
     *
     * @param filePath: path of Miscellaneous information file
     * @param separator: example "\t"
     * @param sampleAnalysis: specify the sample analysis object
     * @param batch: specify the batch object
     * @throws IOException*/

    private void insertMiscellaneousInfo(File filePath, String separator, SampleAnalysis sampleAnalysis, Batch batch) throws IOException {

        logger.info("---------------------------------------------");
        logger.info("--------- MISCELLANEOUS INFORMATION ---------");
        logger.info("---------------------------------------------");
        logger.info("Import miscellaneous file: "+filePath.getName());

        MiscellaneousInformation misInfo = new MiscellaneousInformation();

        List<LineDataSummary> listdataSummary = new ArrayList<>();
        DataSummary dataSum = new DataSummary();
        List<LineEaconParameter>  listEaCoNParam= new ArrayList<>();
        List<LineAffymetrixParameter> listAffymetrixParam = new ArrayList<>();
        AffymetrixParameter affyParam = new AffymetrixParameter();
        EaCoNParameter eaCoNParam = new EaCoNParameter();

        int compteur = 1;
        Integer EaCoNStart = null;
        Integer AffymetrixStart = null;

        if(filePath.exists()) {
            BufferedReader fileBR = new BufferedReader(new FileReader(filePath));
            fileBR.readLine().split(separator);
            String line;


            //Find on which line starts the parameters list of EaCon, Affymetrix and the data summary
            while((line=fileBR.readLine())!=null) {

                if(line.contains("EaCoN parameters")) {
                    EaCoNStart = compteur;

                }if(line.contains("Affymetrix Parameters")) {
                    AffymetrixStart = compteur;

                }if(EaCoNStart != null && AffymetrixStart!= null) {
                    break;
                }
                compteur ++;
            }fileBR.close();


            LineNumberReader reader =null;
            try {
                reader = new LineNumberReader(new FileReader(filePath));
                reader.readLine().split(separator);

                String line2;

                while ((line2=reader.readLine())!= null) {
                    String[] value = line2.split(separator);

                    if(reader.getLineNumber()<=EaCoNStart) {

                        LineDataSummary lds = new LineDataSummary();
                        lds.setParameter(value[0]);
                        //dataSum.setParameter(value[0]);

                        if(value.length > 1) {
                            lds.setParamValue(value[1]);
                            //dataSum.setParamValue(value[1]);

                            if(value[0].equals("source")) {
                                batch.setBatchTechnology(value[1]);
                                batchService.save(batch);

                            }if(value[0].equals("type")) {
                                batch.setBatchInstrument(value[1]);
                                batchService.save(batch);

                            }if(value[0].equals("manufacturer")) {
                                batch.setBatchDetail(value[1]);
                                batchService.save(batch);

                            }
                        }
                        //dataSum.getDataSummaryLines()
                        //dataSum.getDataSummaryLines().add(lds);
                        listdataSummary.add(lds);
                        ldsDao.save(lds);

                        dataSum.setDataSummaryLines(listdataSummary);
                        dsDao.save(dataSum);

                    }if((reader.getLineNumber()>EaCoNStart+1) && (reader.getLineNumber()<=AffymetrixStart)) {
                        //EaCoNParameter EaCoNParam = new  EaCoNParameter();
                        LineEaconParameter lep = new LineEaconParameter();
                        lep.setParameter(value[0]);
                        //EaCoNParam.setParameter(value[0]);

                        if(value.length > 1) {
                            lep.setParamValue(value[1]);
                            //EaCoNParam.setParamValue(value[1]);
                        }
                        lepDao.save(lep);
                        listEaCoNParam.add(lep);
                        eaCoNParam.setEaconParameters(listEaCoNParam);
                        epDao.save(eaCoNParam);


                    }else if(reader.getLineNumber()>AffymetrixStart+1) {

                        LineAffymetrixParameter lap = new LineAffymetrixParameter();
                        lap.setParameter(value[0]);
                        //affyParam.setParameter(value[0]);

                        if(value.length > 10) {
                            lap.setParamValue(value[1]);
                            //affyParam.setParamValue(value[1]);
                        }

                        lapDao.saveAndFlush(lap);

                        listAffymetrixParam.add(lap);
                        affyParam.setAffymetrixParameterLines(listAffymetrixParam);
                        apDao.save(affyParam);
                    }
                }

            }finally{
                if(reader != null)
                    reader.close();
            }

            misInfo.setSampleAnalysis(sampleAnalysis);
            /*misInfo.setListDataSummary(listdataSummary);*/
            misInfo.setDataSummary(dataSum);
            misInfo.setEaCoNParameter(eaCoNParam);
            misInfo.setAffymetrixParameter(affyParam);
            misInfoRepository.save(misInfo);

        }
    }

    @Override
    public MiscellaneousInformation findBySampleAnalysis(SampleAnalysis sampleAnalysis) {
        return misInfoRepository.findBySampleAnalysis(sampleAnalysis);
    }
}


