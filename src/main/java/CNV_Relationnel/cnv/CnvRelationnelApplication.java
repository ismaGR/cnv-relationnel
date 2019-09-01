package CNV_Relationnel.cnv;

import CNV_Relationnel.cnv.model.Batch;
import CNV_Relationnel.cnv.model.Gene;
import CNV_Relationnel.cnv.model.SampleAnalysis;
import CNV_Relationnel.cnv.service.Impl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class CnvRelationnelApplication /*implements CommandLineRunner*/ {
	@Autowired
	private BatchServiceImpl batchService;

	@Autowired
	private SegmentBAFServiceImpl segmentBAFService;

	@Autowired
	private SampleAnalysisServiceImpl sampleAnalysisService;

	@Autowired
	private SegmentL2RServiceImpl segmentL2RService;

	@Autowired
	private GeneServiceImpl geneService;

	@Autowired
	private InstabilityServiceImpl instabilityService;

	@Autowired
	private QCMetricServiceImpl qcMetricService;

	@Autowired
	private MiscellaneousInformationServiceImpl misInfoService;

	private static final Logger logger = LoggerFactory.getLogger(CnvRelationnelApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CnvRelationnelApplication.class, args);

	}

	@Bean
	CommandLineRunner start(){
		logger.info("Application launchs...");
		logger.info("*********************************************");
		logger.info("***********    DROP COLLECTIONS    **********");
		logger.info("*********************************************");

		batchService.deleteAll();
		sampleAnalysisService.deleteAll();
		segmentBAFService.deleteAll();
		segmentL2RService.deleteAll();
		geneService.deleteAll();
		instabilityService.deleteAll();
		qcMetricService.deleteAll();
		misInfoService.deleteAll();
		return args -> {
			loadData();
		};
	}
	public void loadData() throws Exception{
		logger.info("Load Data...");


/** * Import batchs and samples name in collection RunInformation  Find all Batchs directory in the main directory  * For each Batch create a new Batch Object Convert file type to string for the file pathRetrieve all samples directory into a batchRegular expression to remove repeated file contains in solo and SAFIR directories         * Create and instantiated an Object Batch    Add sample in Sample_Analysis collection  * Import Miscellaneous informations  * Import BAF SEGMENTS  * Import Genomic instability file  * Import targeted/truncated genes files * Import segments L2R file  * Import chromosomes files  * Import microarray file  * Import Genomic plots  * Import QC metric informations   * Convert list of paths in list of string with the last element of a path. * @param : list of files
 * Return a list of directories found in the first level of a directory path as argument
 * Method use to find all sample directories in one batch directory
 *
 * @param mainDirPath : set a directory
 * @return Return a list of all files with a specific extension
 * @param FileExtension : the file extension
 * @param PathToFile : the directory where to find files
 * @return Return one file path
 * @param FileExtension : the file extension
 * @param PathToFile: the directory where to find files
 * @return */



		String mainDirPath = "C://Users/33753/Desktop/data_sarcomes_EaCoN_R";

		List<File> BatchFilesNames = new ArrayList<File>();


/** Find all Batchs directory in the main directory*/


		BatchFilesNames=extractDirsFromDir(mainDirPath);

		logger.info("Batchs found :");

		BatchFilesNames.stream().forEach(BatchFileName -> logger.info(BatchFileName.toString()));


/**  * For each Batch create a new Batch Object*/


		for (File f : BatchFilesNames) {
			logger.info("*******************************************************");
			logger.info("              IMPORT " + f.getName() + "");
			logger.info("*******************************************************");

			List<File> samplesDir = new ArrayList<File>();
			List<String> samplesName = new ArrayList<String>();


/**Convert file type to string for the file path*/


			String str = f.toString();


/**Retrieve all samples directory into a batch*/


			samplesDir = extractDirsFromDir(str);
			samplesName = convertPathToString(samplesDir);


/**Regular expression to remove repeated file contains in solo and SAFIR directories*/


			List<String> sampleSelect = new ArrayList<String>();
			for (String sampleName : samplesName) {
				if (!sampleName.matches("(SAFIR)|(WITH_SOLO)|(With_Solo)|(with_solo)")) {
					sampleSelect.add(sampleName);
				}
			}


/** * Create and instantiated an Object Batch*/


			Batch batch = new Batch();
			//batch.setBatchId(new Long());
			batch.setBatchName(f.getName());
			batchService.save(batch);

			logger.info("Repository root : " + f + " Sub-repository found :" + samplesDir);
			logger.info("Batch name: " + f.getName() + " sample(s) name : " + sampleSelect);


/** Add sample in Sample_Analysis collection*/


			List<SampleAnalysis> SampleAnalysisList = new ArrayList<>();

			for (File sampleDir : samplesDir) {

				if (!sampleDir.getName().matches("(SAFIR)|(WITH_SOLO)|(With_Solo)|(with_solo)|(.snakemake)|(logs)|(raw_data)")) {

					SampleAnalysis sampleAnalysis = new SampleAnalysis();

					// sampleAnalysis.setSampleAnalysisId();
					sampleAnalysis.setSampleName(sampleDir.getName());
					sampleAnalysisService.save(sampleAnalysis);

					SampleAnalysisList.add(sampleAnalysis);

					batch.setSampleAnalysisList(SampleAnalysisList);


					logger.info("*********************************************");
					logger.info("      Sample : " + sampleAnalysis.getSampleName());
					logger.info("*********************************************");
					batchService.save(batch);

/** * Import Miscellaneous informations*/


					String MisFileExtension = "_miscellaneous_info.txt";
					String MisFile = sortOneFileByExt(MisFileExtension, sampleDir.toString());

					if (!MisFile.isEmpty()) {
						misInfoService.insertMiscellaneousInfo(new File(MisFile), sampleAnalysis, batch);
					} else {
						logger.error("The file" + sampleAnalysis.getSampleName() + MisFileExtension + " doesn't exist. Pleanse run R script again.");
					}


/** * Import BAF SEGMENTS*/


					String BAFFileExtension = "CytobandSegmentedBAF.txt";
					String BAFFile = sortOneFileByExt(BAFFileExtension, sampleDir.toString());

					if (!BAFFile.isEmpty()) {
						segmentBAFService.insertSegmentBAF(new File(BAFFile), sampleAnalysis);
					} else {
						logger.error("The file " + sampleAnalysis.getSampleName() + "." + BAFFileExtension + " doesn't exist. Please run R script again.");
					}


/** * Import Genomic instability file */


					String InstabFileExtension = "Instab.txt";
					String InstabFile = sortOneFileByExt(InstabFileExtension, sampleDir.toString());

					if (!InstabFile.isEmpty()) {
						instabilityService.insertInstab(new File(InstabFile), sampleAnalysis);
					} else {
						logger.error("The file" + sampleAnalysis.getSampleName() + "." + InstabFileExtension + " is not found.");
					}


/** * Import targeted/truncated genes files*/


					String TargetGenesFileExtension = "TargetGenes.txt";
					String TruncatedGenesFileExtension = "TruncatedGenes.txt";

					String TargetGeneFile = sortOneFileByExt(TargetGenesFileExtension, sampleDir.toString());
					String TruncatedGeneFile = sortOneFileByExt(TruncatedGenesFileExtension, sampleDir.toString());

					if (!TargetGeneFile.isEmpty()) {
						geneService.insertGene(new File(TargetGeneFile), false, sampleAnalysis);
					} else {
						logger.error("The file" + sampleAnalysis.getSampleName() + "." + TargetGenesFileExtension + " is not found.");
					}

					if (!TruncatedGeneFile.isEmpty()) {
						geneService.insertGene(new File(TruncatedGeneFile), true, sampleAnalysis);
					} else {
						logger.error("The file" + sampleAnalysis.getSampleName() + "." + TruncatedGenesFileExtension + " is not found.");
					}


/** * Import segments L2R file*/


					String L2RFileExtension = "CytobandSegmentedL2R.txt";
					String L2RFile = sortOneFileByExt(L2RFileExtension, sampleDir.toString());

					if (!L2RFile.isEmpty()) {
						segmentL2RService.insertSegmentL2R(new File(L2RFile), sampleAnalysis);
					} else {
						logger.error("The file" + sampleAnalysis.getSampleName() + "." + L2RFile + " doesn't exist. Please run R script again.");
					}


/** * Import chromosomes files*/


					List<String> ChrFiles = new ArrayList<String>();
					String ChrFileExtension = "chr";

					ChrFiles = sortFilesByExt(ChrFileExtension, sampleDir.toString());
					if (!ChrFiles.isEmpty()) {
						sampleAnalysisService.insertChromosomePlot(ChrFiles, sampleAnalysis);
					} else {
						logger.error("Chromosomes plots files not found.");
					}


/** * Import microarray file*/


					String MicroarrayFileExtension = "_microarray.txt";
					String MicroarrayPlotExtension = ".INT";

					String MicroarrayFile = sortOneFileByExt(MicroarrayFileExtension, sampleDir.toString());
					String MicroarrayPlot = sortOneFileByExt(MicroarrayPlotExtension, sampleDir.toString());

					if (!MicroarrayFile.isEmpty() || !MicroarrayPlot.isEmpty()) {
						sampleAnalysisService.insertMicroarray(new File(MicroarrayFile), sampleAnalysis, MicroarrayPlot);
					} else {
						logger.error("The file " + sampleAnalysis.getSampleName() + MicroarrayFileExtension + " or the file " +
								sampleAnalysis.getSampleName() + MicroarrayPlotExtension + " are not found.");
					}


/** * Import Genomic plots*/


					String FileBAFExt = "BAF.png";
					String FileL2RExt = "L2R.G.png";
					String FileL2RBAFExt = "SEG.ASCAT.png";

					String PathFileBAF = sortOneFileByExt(FileBAFExt, sampleDir.toString());
					String PathFileL2R = sortOneFileByExt(FileL2RExt, sampleDir.toString());
					String PathFileL2RBAF = sortOneFileByExt(FileL2RBAFExt, sampleDir.toString());

					if (!PathFileBAF.isEmpty() || !PathFileL2R.isEmpty() || !PathFileL2RBAF.isEmpty()) {
						sampleAnalysisService.insertGenomicPlot(PathFileBAF, PathFileL2R, PathFileL2RBAF, sampleAnalysis);
					} else {
						logger.error("Genomic plots files not found");
					}


/** * Import QC metric informations*/


					String QCMetricFileExtension = "_qc_metric.txt";
					String QCMetricFile = sortOneFileByExt(QCMetricFileExtension, sampleDir.toString());

					if (!QCMetricFile.isEmpty()) {
						qcMetricService.insertQCMetric(new File(QCMetricFile), sampleAnalysis, batch);
					} else {
						logger.error("The file" + sampleAnalysis.getSampleName() + QCMetricFileExtension + " doesn't exist. Please run R script again.");
					}

					System.out.println("+ + + + + + + + + + + + + ");
					System.out.println("ID du sample analysis" + sampleAnalysis.getSampleAnalysisId());
					System.out.println("+ + + + + + + + + + + + + ");

					List<Gene> GeneList = new ArrayList<>();

					// GeneList = geneService.GetGenesInSegmentBAF(sampleAnalysis.getSampleAnalysisId(), "chr1",1156131,5368589);
					Integer compteur = 0;
					for (Gene gene : GeneList) {
						compteur++;
						System.out.println("Gene :" + compteur + " " + gene.getGeneSymbol() + " " + gene.getGeneStart() + " " + gene.getGeneEnd());

					}

				}
				System.out.println("+ + + + + + fin des imports + + + + + + + ");
			}
			logger.info("Succesfully import :" + batch.getBatchName());
		}
	}


	/**
	 * Convert list of paths in list of string with the last element of a path. * @param : list of files
	 */


	public List<String> convertPathToString(List<File> ListFiles) {
		List<String> NameFile = new ArrayList<String>();
		for (File f : ListFiles) {
			String pathName = f.getName();
			NameFile.add(pathName);
		}
		return NameFile;
	}


	/**
	 * Return a list of directories found in the first level of a directory path as argument
	 * Method use to find all sample directories in one batch directory
	 *
	 * @param /*mainDirPath : set a directory  * @return
	 */


	public List<String> sortFilesByExt(String FileExtension, String PathToFile) {
		List<String> List = new ArrayList<String>();
		try (Stream<Path> walk = Files.walk(Paths.get(PathToFile))) {

			List<String> allFiles = walk.map(x -> x.toString())
					.collect(Collectors.toList());

			for (String filename : allFiles) {
				if (filename.contains(FileExtension)) {
					List.add(filename);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return List;
	}


	/**  * Return one file path
	 * @param FileExtension : the file extension
	 * @param PathToFile: the directory where to find files
	 * @return*/


	public String sortOneFileByExt(String FileExtension, String PathToFile ) {
		String file = new String();
		try(Stream<Path> walk = Files.walk(Paths.get(PathToFile))){

			List<String> allFiles = walk.map(x -> x.toString())
					.collect(Collectors.toList());

			for(String filename : allFiles) {
				if(filename.contains(FileExtension)){
					file = filename;
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return file;
	}

	public 	List<File> extractDirsFromDir(String mainDirPath){
		List<File> List = new ArrayList<File>();
		File mainDir = new File(mainDirPath);
		if(mainDir.exists() && mainDir.isDirectory())
		{
			File arr[]=mainDir.listFiles();
			for(File f :arr)
			{
				if(f.isDirectory())
				{
					List.add(f);
				}
			}
		}
		return List;
	}

/**  * Return a list of all files with a specific extension
 * @param /*FileExtension : the file extension
 * @param PathToFile : the directory where to find files
 @return */


}

