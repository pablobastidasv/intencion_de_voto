package co.cinvir.logic.boundary;

import co.cinvir.datascience.logic.boundary.ApreciacionesProcessor;
import co.cinvir.datascience.logic.boundary.VotationProcessor;
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
        
        Optional<VotationProcessor> processorOpt = VotationProcessor.newInstance();
        
        VotationProcessor processor = processorOpt.get();
        
        Optional<OutputNode> result = processor.result(values);
        
        if(result.isPresent()){
            System.out.println("La tendencia de voto es: " + result.get().getDecision());
        } else {
            System.err.println("No se pudo determinar la tendencia de voto.");
        }
    }
    
    @Test
    public void apreciacion(){
        String input = "Si,Si,Si,Si,Si,Si,Si,'Siempre es malo','Siempre es malo',No,'Trabajo duro',NA,NA,'Manteniendo la casa',Casado,No,No,NA,2,Mujer,Ninguno,'Bastante feliz','NA'";
        
        ApreciacionesProcessor processor = new ApreciacionesProcessor();
        Optional<Integer> cluster = processor.getCluster(input);
        
        if(cluster.isPresent()){
            System.out.println("El cluster es: " + cluster.get());
        } else {
            System.err.println("No se pudo determinar a que cluster pertenece.");
        }
    }
}
