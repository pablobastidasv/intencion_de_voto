package co.cinvir.datascience.logic.entity;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class TestNode extends Node{
    @XmlAttribute(name = "attribute")
    private String attribute;
    @XmlAttribute(name = "operator")
    private String operator;
    @XmlAttribute(name = "value")
    private String value;
    @XmlElement(name = "Test")
    private List<TestNode> tests;
    @XmlElement(name = "Output")
    private OutputNode output;

    public String getAttribute() {
        return attribute;
    }

    public String getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }

    public List<TestNode> getTests() {
        return tests;
    }

    public OutputNode getOutput() {
        return output;
    }

    @Override
    public String toString() {
        return  "{" 
                + "attribute: " + attribute + ","
                + "operator: " + operator + ","
                + "value: " + value + ","
                + "tests: " + tests.size() + ","
                + "haveOutput: " + Objects.nonNull(output)
                + "}"
                ;
    }
    
}
