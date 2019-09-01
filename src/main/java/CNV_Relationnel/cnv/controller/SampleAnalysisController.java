package CNV_Relationnel.cnv.controller;


import CNV_Relationnel.cnv.model.SampleAnalysis;
import CNV_Relationnel.cnv.service.SampleAnalysisService;
import CNV_Relationnel.cnv.webObject.SampleAnalysisWebObj;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8282")
@RequestMapping("/sampleAnalysis/*")
public class SampleAnalysisController {

    private static final Logger logger = LoggerFactory.getLogger(SampleAnalysisController.class);

    @Autowired
    private SampleAnalysisService sampleAnalysisService;


    /* * Import data from collection SampleAnalysis to SampleAnalysisWebObj without info on collections :
     * - Gene
     * - Segment BAF
     * - Segment L2R
     *
     *
     * set others methods*/


    private SampleAnalysisWebObj convertToWebObject(SampleAnalysis sa) {
        SampleAnalysisWebObj resSawb = new SampleAnalysisWebObj();
        resSawb.setSampleAnalysisId(sa.getSampleAnalysisId());
        resSawb.setSampleName(sa.getSampleName());
        return resSawb;
    }

    @GetMapping("/webSampleAnalysis")
    public ResponseEntity<List<SampleAnalysisWebObj>> getWebSampleAnalysis(){
        List<SampleAnalysisWebObj> resSampleAnalysisWebObj = new ArrayList<SampleAnalysisWebObj>();
        for(SampleAnalysis sa : sampleAnalysisService.getAllSamplesAnalysis()) {
            resSampleAnalysisWebObj.add(convertToWebObject(sa));
        }
        return new ResponseEntity<List<SampleAnalysisWebObj>>(resSampleAnalysisWebObj, HttpStatus.FOUND);

    }

    @GetMapping("/samplesAnalysis")
    public ResponseEntity<Collection<SampleAnalysis>> getAllSamplesAnalysis(){
        Collection<SampleAnalysis> samplesAnalysis = sampleAnalysisService.getAllSamplesAnalysis();
        return new ResponseEntity<Collection<SampleAnalysis>>(samplesAnalysis, HttpStatus.FOUND);
    }
//	//not working !
//	@RequestMapping(value="/samplesAnalysis/{id}", method = RequestMethod.GET )
//	public SampleAnalysis getOne(@PathVariable(value ="id") ObjectId id) {
//		return sampleAnalysisService.findBySampleAnalysisId(id);
//	}

    @RequestMapping(value="/BySampleName", method = RequestMethod.GET)
    public ResponseEntity<SampleAnalysis> findBySampleName(@RequestParam(value="sampleName",required = true) String sampleName) {
        SampleAnalysis samplesAnalysisBySampleName = sampleAnalysisService.findBySampleName(sampleName);
        return new ResponseEntity<SampleAnalysis>(samplesAnalysisBySampleName, HttpStatus.FOUND);
    }

    @RequestMapping(value="/ById", method = RequestMethod.GET)
    public ResponseEntity<SampleAnalysis> findBySampleAnalysisId(@RequestParam(value="sampleAnalysisId", required=true)Long sampleAnalysisId){
        SampleAnalysis sampleAnalysisById = sampleAnalysisService.findBySampleAnalysisId(sampleAnalysisId);
        return new ResponseEntity<SampleAnalysis>(sampleAnalysisById, HttpStatus.FOUND);
    }



}
