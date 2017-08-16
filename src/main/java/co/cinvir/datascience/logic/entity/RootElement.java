/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.cinvir.datascience.logic.entity;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "DecisionTree")
@XmlAccessorType(XmlAccessType.FIELD)
public class RootElement {
    
    @XmlElement(name = "Test")
    private List<TestNode> tests;

    public List<TestNode> getTests() {
        return tests;
    }
    
}
