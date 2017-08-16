package co.cinvir.datascience.logic.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class OutputNode extends Node{
    @XmlAttribute(name = "decision")
    private String decision;
    @XmlAttribute(name = "info")
    private String info;

    public String getDecision() {
        return decision;
    }

    public String getInfo() {
        return info;
    }
    
    
}
