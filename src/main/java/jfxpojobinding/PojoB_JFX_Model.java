package jfxpojobinding;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mario
 */
public class PojoB_JFX_Model implements PojoJFXModel<PojoB> {
    private StringProperty name;
    private PojoB pojo;

    public PojoB_JFX_Model(PojoB pojo) {
        setPojo(pojo);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    @Override
    public PojoB unwrapp() {
        pojo = new PojoB();
        pojo.setName(getName());
        return pojo;
    }

    @Override
    public PojoB getPojo() {
        return pojo;
    }

    @Override
    public void setPojo(PojoB pojo) {
        this.pojo = pojo;
        name = new SimpleStringProperty(pojo.getName());
    }

    @Override
    public String toString() {
        return "PojoB-Model{" + name.get() + '}';
    }

}
