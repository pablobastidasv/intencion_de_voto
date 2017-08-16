package co.cinvir.datascience.logic.boundary;

import co.cinvir.datascience.logic.entity.Node;
import co.cinvir.datascience.logic.entity.OutputNode;
import co.cinvir.datascience.logic.entity.RootElement;
import co.cinvir.datascience.logic.entity.TestNode;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ModelProcessor {
    
    private RootElement rootElement;
    private Map<String, String> values;
    
    public static Optional<ModelProcessor> newInstance(Map<String, String> values){
        try {
            ModelProcessor mp = new ModelProcessor();
            mp.read();
            mp.setValues(values);
            
            return Optional.of(mp);
        } catch (JAXBException ex) {
            Logger.getLogger(ModelProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Optional.empty();
    }
    
    private ModelProcessor(){
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }
    
    private void read() throws JAXBException{
        JAXBContext jaxbContext = JAXBContext.newInstance(RootElement.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        InputStream inputResource = ModelProcessor.class.getResourceAsStream("/WekaResult.xml");
        this.rootElement = (RootElement) jaxbUnmarshaller.unmarshal(inputResource);
    }
    
    public Optional<OutputNode> result(){
        Optional<TestNode> result = process(rootElement.getTests());
        
        if(result.isPresent() && Objects.nonNull(result.get().getOutput())){
            OutputNode output = result.get().getOutput();
            return Optional.of(output);
        }
        
        return Optional.empty();
    }
    
    private Optional<TestNode> process(List<TestNode> nodes){
        if(nodes.isEmpty()){
            return Optional.empty();
        }
        
        Optional<TestNode> result = nodes.stream()
                .filter(this.applyTest)
                .findFirst();

        if(Objects.isNull(result.get().getTests())
                && Objects.nonNull(result.get().getOutput())){
            return result;
        }
        
        return process(result.get().getTests());
    }

    private final Predicate<? super TestNode> applyTest = t -> {
        String userInput = values.get(t.getAttribute());
        Operator operator = Operator.getBySymbol(t.getOperator());
        return operator.getValidation().apply(userInput, t.getValue());
    };
    
    private enum Operator{
        EQUALS("=", (input, value) -> input.equals(value));
        
        private final String symbol;
        private final BiFunction<String, String, Boolean> validation;
        
        Operator(String symbol, BiFunction<String, String, Boolean> validation){
            this.symbol = symbol;
            this.validation = validation;
        }
        
        public static Operator getBySymbol(String symbol){
            return Arrays.stream(Operator.values())
                    .filter(o -> o.symbol.equals(symbol))
                    .findFirst()
                    .orElse(EQUALS);
        }

        public BiFunction<String, String, Boolean> getValidation() {
            return validation;
        }
        
        
    }
}
