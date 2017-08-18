package co.cinvir.datascience.logic.boundary;

import co.cinvir.datascience.logic.entity.OutputNode;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resource {
    
    @Autowired
    private VotationService service;
    
    @GetMapping("/votation")
    public OutputNode getPrediction(@RequestParam Map<String, String> params){
        return service
                .getVoteIntention(params);
    }
    
}
