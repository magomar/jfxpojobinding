package jfxpojobinding;

import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;

/**
 *
 * @author Mario Gómez Martínez
 */
public class SimpleViewController implements Initializable {
    private PojoA_JFX_Model samplePojoWrapper;
    private ObjectProperty<PojoB_JFX_Model> object;
    private Random rand = new Random();
    
    @FXML
    private TextField stringTF;
    
    @FXML
    private TextField numberTF;

    @FXML
    private CheckBox checkBox;
    
    @FXML
    private TextField objectNameTF;
    
    @FXML
    private ListView<String> stringLV;
    
    @FXML
    private ComboBox<PojoB_JFX_Model> pojoCB;
    
    @FXML
    private TextArea textArea;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // First let's create some sample models and the corresponding wrapper
        PojoB spm1 = new PojoB();
        spm1.setName("Pojo-1");       
        PojoB spm2 = new PojoB();
        spm2.setName("Pojo-2");
        PojoB spm3 = new PojoB();
        spm3.setName("Pojo-3");
        PojoA pm = new PojoA();
        pm.setText("I'm a string");
        pm.setNumber(10.0);
        pm.setCertain(true);
        pm.setObject(spm1);
        pm.setSimpleList(Arrays.asList(new String[]{"str-1","str-2","str-3"}));
        pm.setObjectList(Arrays.asList(new PojoB[]{spm1, spm2, spm3}));
        
        samplePojoWrapper = new PojoA_JFX_Model(pm);
        object = new SimpleObjectProperty<>(samplePojoWrapper.getObjectList().get(0));
        object.bindBidirectional(samplePojoWrapper.objectProperty());
        
        // *** Now let's do the bindings ***//
        
        // String property binding using fluent API
        stringTF.textProperty().bindBidirectional(samplePojoWrapper.textProperty());
        //Note: alternatively, one can use the Bindings helper class to create bindings, as follows
        //Bindings.bindBidirectional(stringTF.textProperty(), samplePojoWrapper.textProperty());
        
        // Number property binding using fluent API, this requieres a converter
        StringConverter<? extends Number> converter =  new DoubleStringConverter();
        numberTF.textProperty().bindBidirectional(samplePojoWrapper.numberProperty(), (StringConverter<Number>) converter);

        // Boolean property binding using fluent API
        checkBox.selectedProperty().bindBidirectional(samplePojoWrapper.certainProperty());

        // Object binding using fluent API
        objectNameTF.textProperty().bindBidirectional(object.get().nameProperty());
        
        // String List binding
        stringLV.setItems(samplePojoWrapper.getSimpleList());
        
        // Generic Object List binding
        pojoCB.setItems(samplePojoWrapper.getObjectList());
        
        // For the sake of presentation, select first element of the combobox
        pojoCB.getSelectionModel().selectFirst();
        
    }   
    
    @FXML
    private void changeWrapperAction(ActionEvent event) {
        samplePojoWrapper.setText(UUID.randomUUID().toString());
        samplePojoWrapper.setNumber(rand.nextDouble());
        samplePojoWrapper.setCertain(!samplePojoWrapper.isCertain());
//        PojoB spm = new PojoB();
//        spm.setName("PojoB-4");
//        PojoB_JFX_Model spw = new PojoB_JFX_Model(spm);
//        samplePojoWrapper.setObject(spw);
        samplePojoWrapper.getObject().setName(UUID.randomUUID().toString());
        samplePojoWrapper.getSimpleList().remove(0);
        samplePojoWrapper.getObjectList().remove(0);
        pojoCB.getSelectionModel().selectFirst();
    }
    
    @FXML
    private void printWrapperAction(ActionEvent event) {
        textArea.appendText('\n' + samplePojoWrapper.toString());
    }
    
    @FXML
    private void printPojoAction(ActionEvent event) {
        textArea.appendText('\n' + samplePojoWrapper.getPojo().toString());
    }
      
    @FXML
    private void modelToPojoAction(ActionEvent event) {
        samplePojoWrapper.unwrapp();
    }
         
    
}
