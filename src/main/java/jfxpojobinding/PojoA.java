package jfxpojobinding;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mario
 */
public class PojoA {
    private String text;
    private double number;
    private boolean certain;
    private PojoB object;
    private List<String> simpleList;
    private List<PojoB> objectList;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public boolean isCertain() {
        return certain;
    }

    public void setCertain(boolean certain) {
        this.certain = certain;
    }

    public PojoB getObject() {
        return object;
    }

    public void setObject(PojoB object) {
        this.object = object;
    }
   
    public List<String> getSimpleList() {
        if (simpleList == null) simpleList = new ArrayList<>();
        return simpleList;
    }

    public void setSimpleList(List<String> simpleList) {
        this.simpleList = simpleList;
    }

    public List<PojoB> getObjectList() {
        if (objectList == null) objectList = new ArrayList<>();
        return objectList;
    }

    public void setObjectList(List<PojoB> objectList) {
        this.objectList = objectList;
    }

    @Override
    public String toString() {
        return "PojoA{" + "\n text=" + text + ", \n number=" + number + ", \n certain=" + certain
                + ", \n object=" + object + ", \n simpleList=" + simpleList + ", \n objectList=" + objectList + '}';
    }
    
    
    
}
