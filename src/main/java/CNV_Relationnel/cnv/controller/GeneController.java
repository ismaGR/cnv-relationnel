package CNV_Relationnel.cnv.controller;

import CNV_Relationnel.cnv.model.Gene;
import CNV_Relationnel.cnv.service.GeneService;
import CNV_Relationnel.cnv.service.Impl.GeneServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/gene/*")
public class GeneController {

    private static final Logger logger = LoggerFactory.getLogger(GeneController.class);

    @Autowired
    private GeneServiceImpl geneService;

    @GetMapping(value = "/genes")
    public ResponseEntity<Collection<Gene>> getAllGenes() {
        Collection<Gene> genes = geneService.getAllGenes();
       // logger.info("liste des genes : " + genes.toString());
        return new ResponseEntity<Collection<Gene>>(genes, HttpStatus.FOUND);
    }
    // URL not working !
    @RequestMapping(value="/BySampleNameAndIsTruncated", method = RequestMethod.GET)
    public ResponseEntity<List<Gene>> findBySampleNameAndIsTruncatedGene(@RequestParam(value="sampleName",required = true) String sampleName,
                                                                         @RequestParam(value="isTruncatedGene", required = false) Boolean isTruncatedGene) {
        List<Gene> geneBySampleNameAndIsTruncatedGene = geneService.findBySampleNameAndIsTruncatedGene(sampleName, isTruncatedGene);
        return new ResponseEntity<List<Gene>>(geneBySampleNameAndIsTruncatedGene, HttpStatus.FOUND);
    }
}
