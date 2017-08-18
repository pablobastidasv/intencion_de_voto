package co.cinvir.datascience.logic.boundary;

import co.cinvir.datascience.logic.entity.OutputNode;
import java.util.Map;
import java.util.Optional;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class VotationService {
    
    private Optional<VotationProcessor> processor;
    
    @PostConstruct
    public void init(){
        processor = VotationProcessor.newInstance();        
    }
    
    public OutputNode getVoteIntention(Map<String, String> values){
        return processor
                .orElseThrow(() -> new IllegalStateException("error initializing the processor"))
                .result(values)
                .orElseThrow(() -> new IllegalStateException("error processing the information"));
    }
    
}
