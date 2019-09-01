package CNV_Relationnel.cnv.service.Impl;


import CNV_Relationnel.cnv.model.*;
import CNV_Relationnel.cnv.repository.*;
import CNV_Relationnel.cnv.service.SampleAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service(value="SampleAnalysisService")
public class SampleAnalysisServiceImpl implements SampleAnalysisService {

    private static final Logger logger = LoggerFactory.getLogger(SampleAnalysisServiceImpl.class);

    @Autowired
    private SampleAnalysisRepository sampleAnalysisRepository;

    @Autowired
    private MicroArrayRepository maDao;

    @Autowired
    private LineMicroarrayRepository lmDao;

    @Autowired
    private LineChromosomePlotRepository lcpDao;

    @Autowired
    private ChromosomePlotRepository cpDao;

    @Autowired
    private LineGenomicPlotRepository lgpDao;

    @Autowired
    private GenomicPlotRepository gpDao;

    @Override
    public Collection<SampleAnalysis> getAllSamplesAnalysis() {
        return sampleAnalysisRepository.findAll();
    }

    @Override
    public SampleAnalysis findBySampleName(String sampleName) {
        return sampleAnalysisRepository.findBySampleName(sampleName);
    }

    @Override
    public SampleAnalysis findBySampleAnalysisId(Long sampleAnalysisId) {
        return sampleAnalysisRepository.findBySampleAnalysisId(sampleAnalysisId);
    }

    @Override
    public void deleteAll() {
        sampleAnalysisRepository.deleteAll();
    }

    @Override
    public void save(SampleAnalysis entity) {
        sampleAnalysisRepository.save(entity);
    }

    public void insertMicroarray(File filePath, SampleAnalysis sampleAnalysis, String microarrayPlotPath) throws IOException {
        this.insertMicroarray(filePath, "\t",sampleAnalysis,microarrayPlotPath);
    }

    /*
     *
     * Insert Microarray information in embedded collection Microarray
     *
     * @param filePath: path of Miscellaneous information file
     * @param separator: example "\t"
     * @param sampleAnalysis: specify the sample analysis object
     * @param microarrayPlotPath: path of microarray plot
     * @throws IOException
     * <p>
     * Insert genomic plot file in embedded collection GenomicPlot
     * <p>
     * Only one plot for BAF, L2R and BAF+L2R
     * convert the arrayList in string with on element
     * <p>
     * Insert Chromosome plots in embedded collection ChromosomePlot
     */

    private void insertMicroarray(File filePath, String separator, SampleAnalysis sampleAnalysis,String microarrayPlotPath) throws IOException {


        logger.info("---------------------------------------------");
        logger.info("---------------- MICROARRAY -----------------");
        logger.info("---------------------------------------------");

        logger.info("Import Microarray file: "+filePath.getName());

        //final List<MicroArray> microarrays = new ArrayList<>();
        MicroArray microarray = new MicroArray();
        microarray.setMicroarrayLines(new ArrayList<>());
        // Collection<LineMicroarray> microarrayArrayList = new ArrayList<>();

        if(filePath.exists()) {

            BufferedReader fileBR = new BufferedReader(new FileReader(filePath));
            fileBR.readLine().split(separator);
            String line;

            while((line=fileBR.readLine())!=null) {

                LineMicroarray lineMicroarray = new LineMicroarray();

                String[] value = line.split(separator);
                lineMicroarray.setArrayType(value[1]);
                // lineMicroarray.setLineMicroarrayId(()value[2]);
                lineMicroarray.setArrayBarcode(value[3]);
                lineMicroarray.setScannerId(value[4]);
                /*microarray.setArrayType(value[1]); microarray.setArrayId(value[2]); microarray.setArrayBarcode(value[3]);	microarray.setScannerId(value[4]);*/
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
                String dateInString = value[5];

                Date date;
                try {
                    date = formatter.parse(dateInString.replaceAll("Z$","+0000"));
                    lineMicroarray.setScanDate(date);
                }catch(ParseException e) {
                    e.printStackTrace();
                }

                lineMicroarray.setPathToPlot(microarrayPlotPath);
                lmDao.save(lineMicroarray);

                microarray.getMicroarrayLines().add(lineMicroarray) ;
                maDao.save(microarray);

            }
            sampleAnalysis.setMicroArray(microarray);
            fileBR.close();
        }

        sampleAnalysisRepository.save(sampleAnalysis);
    }

    /**  * Insert genomic plot file in embedded collection GenomicPlot */


    public void insertGenomicPlot(String PathFileBAF, String PathFileL2R, String PathFileL2RBAF, SampleAnalysis sampleAnalysis) {

/**  * Only one plot for BAF, L2R and BAF+L2R convert the arrayList in string with on element */

        logger.info("---------------------------------------------");
        logger.info("---------------- GENOMIC PLOT ---------------");
        logger.info("---------------------------------------------");

        logger.info("Import Genomic plots.");

        GenomicPlot genomicPlot = new GenomicPlot(); List<LineGenomicPlot> lgpList = new ArrayList<>();
        LineGenomicPlot lineGenomicPlot = new LineGenomicPlot();

        lineGenomicPlot.setPathFileBAF(PathFileBAF);
        lineGenomicPlot.setPathFileL2R(PathFileL2R);
        lineGenomicPlot.setPathFileL2RBAF(PathFileL2RBAF);
        lgpDao.save(lineGenomicPlot);

        lgpList.add(lineGenomicPlot);
        genomicPlot.setGenomicPlotLines(lgpList);
        gpDao.save(genomicPlot);
        sampleAnalysis.setGenomicPlot(genomicPlot);
        sampleAnalysisRepository.save(sampleAnalysis);
    }

    /* *  * Insert Chromosome plots in embedded collection ChromosomePlot */

    public void insertChromosomePlot(List<String> ChromosomesFile, SampleAnalysis sampleAnalysis) {


        logger.info("---------------------------------------------");
        logger.info("-------------- CHROMOSOMES PLOT -------------");
        logger.info("---------------------------------------------");

        logger.info("Import Chromosomes plots.");

        ChromosomePlot chromosomePlot = new ChromosomePlot();
        List<LineChromosomePlot> lcpList = new ArrayList<>();

        for(String Chrom : ChromosomesFile ) {
            if(Chrom.contains(".png")) {

                File ChrFile= new File(Chrom);
                String[] ChrName = ChrFile.getName().split(".png");

                LineChromosomePlot lcp = new LineChromosomePlot();

                lcp.setChrom(ChrName[0]);
                lcp.setPathFileChrom(ChrFile.toString());
                lcpDao.save(lcp);
                lcpList.add(lcp);
                chromosomePlot.setChromosomePlotLines(lcpList);
            }
            cpDao.save(chromosomePlot);
            //sampleAnalysis.setListChromosomePlots(Chromosomes);
            sampleAnalysis.setChromosomePlot(chromosomePlot);
            sampleAnalysisRepository.save(sampleAnalysis);
        }
    }

}

