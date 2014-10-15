package jfxpojobinding;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Mario
 */
public class PojoA_JFX_Model implements PojoJFXModel<PojoA> {

    private StringProperty text;
    private DoubleProperty number;
    private BooleanProperty certain;
    private ObjectProperty<PojoB_JFX_Model> object;
    private ObservableList<String> simpleList;
    private ObservableList<PojoB_JFX_Model> objectList;
    private PojoA pojo;

    public PojoA_JFX_Model(PojoA pojo) {
        setPojo(pojo);
    }

    public String getText() {
        return text.get();
    }

    public void setText(String name) {
        this.text.set(name);
    }

    public double getNumber() {
        return number.get();
    }

    public void setNumber(double number) {
        this.number.set(number);
    }

    public boolean isCertain() {
        return certain.get();
    }

    public void setCertain(boolean certain) {
        this.certain.set(certain);
    }

    public BooleanProperty certainProperty() {
        return certain;
    }

    public PojoB_JFX_Model getObject() {
        return this.object.get();
    }

    public void setObject(PojoB_JFX_Model object) {
        this.object.set(object);
    }

    public StringProperty textProperty() {
        return text;
    }

    public DoubleProperty numberProperty() {
        return number;
    }

    public ObjectProperty<PojoB_JFX_Model> objectProperty() {
        return object;
    }

    public ObservableList<String> getSimpleList() {
        return simpleList;
    }

    public ObservableList<PojoB_JFX_Model> getObjectList() {
        return objectList;
    }

    @Override
    public PojoA unwrapp() {
        pojo = new PojoA();
        pojo.setText(getText());
        pojo.setNumber(getNumber());
        pojo.setObject(getObject().unwrapp());
        pojo.getSimpleList().addAll(simpleList);
        objectList.stream().forEach((pojoWrapper) -> {
            pojo.getObjectList().add(pojoWrapper.unwrapp());
        });
        return pojo;
    }

    @Override
    public void setPojo(PojoA pojo) {
        this.pojo = pojo;
        text = new SimpleStringProperty(pojo.getText());
        number = new SimpleDoubleProperty(pojo.getNumber());
        certain = new SimpleBooleanProperty(pojo.isCertain());
        this.object = new SimpleObjectProperty<>(new PojoB_JFX_Model(pojo.getObject()));
        this.simpleList = FXCollections.observableArrayList(pojo.getSimpleList());
        this.objectList = FXCollections.observableArrayList();
        pojo.getObjectList().stream().forEach((simplePojo) -> {
            objectList.add(new PojoB_JFX_Model(simplePojo));
        });
    }

    @Override
    public PojoA getPojo() {
        return pojo;
    }

    @Override
    public String toString() {
        return "PojoA-Model{" + "\n text=" + text.get() + ", \n number=" + number.get() + ", \n certain=" + certain.get()
                + ", \n object=" + object.get() + ", \n simpleList=" + simpleList + ", \n objectList=" + objectList + '}';
    }
}
