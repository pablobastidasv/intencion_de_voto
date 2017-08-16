package co.cinvir.logic.boundary;

import co.cinvir.datascience.logic.boundary.ModelProcessor;
import co.cinvir.datascience.logic.entity.OutputNode;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.Test;

public class ModelProcessorTest {
    
    @Test
    public void hello() {
        Map<String, String> values = new HashMap<>();
        values.put("conlabor", "Mucho");
        values.put("relig", "None");
        values.put("conbus", "Poco");
        values.put("confed", "Nada");
        values.put("conclerg", "Nada");
        values.put("confinan", "Mucho");
        
        Optional<ModelProcessor> processorOpt = ModelProcessor.newInstance(values);
        
        ModelProcessor processor = processorOpt.get();
        
        Optional<OutputNode> result = processor.result();
        
        if(result.isPresent()){
            System.out.println("La tendencia de voto es: " + result.get().getDecision());
        } else {
            System.err.println("No se pudo determinar la tendencia de voto.");
        }
    }
}
