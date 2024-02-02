package com.alabtaal.inventory.controller;
import com.alabtaal.inventory.entity.ItemEntity;
import com.alabtaal.inventory.service.ItemService;
import com.alabtaal.inventory.util.FXUtils;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.*;


import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
@Controller
public class ItemController implements Initializable {
    private final ItemService itemService;

@FXML
    private ChoiceBox<String > itemTypeChoiceBox;
    @FXML
    private TextField idTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField brandTextField;
    @FXML
    private TextField priceTextField;
    @FXML
    private TableView<ItemEntity> itemsTables;
    @FXML
    private TableColumn<ItemEntity,String> brandColumn;
    @FXML
    private TableColumn<ItemEntity,String>  nameColumn;
    @FXML
    private TableColumn<ItemEntity,String>  priceColumn;
    private String oldValue="";


    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        itemTypeChoiceBox.setItems(FXCollections.observableList(getItemTypes()));
        setupListeners();
        setUpItemTable();
    }

    private List<ItemEntity> findAll(){
 return itemService.findAll();
    }
    private  void setUpItemTable(){
        nameColumn.setCellValueFactory(
                (cellData) -> new SimpleStringProperty(cellData.getValue().getName())
        );

        brandColumn.setCellValueFactory(
                (cellData) -> new SimpleStringProperty(cellData.getValue().getBrand())
        );
        priceColumn.setCellValueFactory(
                (cellData) -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice()))
        );
itemsTables.setItems(FXCollections.observableList(findAll()));
itemsTables.getSelectionModel().selectedItemProperty().addListener(
        (observable,oldSelection,newSelection)-> {
            if (newSelection != null) {
                idTextField.setText(String.valueOf(newSelection.getItemId()));
                nameTextField.setText(newSelection.getName());
                brandTextField.setText(newSelection.getBrand());
                priceTextField.setText(String.valueOf(newSelection.getPrice()));
                if (newSelection.getItemType()!= null) {
                    itemTypeChoiceBox.setValue(newSelection.getItemType());
                }else {
                    itemTypeChoiceBox.setValue("");
                }
            }
        }
);
        }
    private void setupListeners(){
        idTextField.textProperty().addListener((observable, oldValue, newValue) -> onIDTextFieldChanges(oldValue,newValue));
    }

    @FXML
    public void onIDTextFieldChanges(String oldValue, String newValue) {
//        try {
//            System.out.println(idTextField.getText());
//            Double.parseDouble(idTextField.getText());
//            oldValue=idTextField.getText();
//        }catch (Exception e){
//            idTextField.setText(oldValue);
//        }
        try {
            System.out.println("New value="+newValue);

            System.out.println("old value="+oldValue);
            Double.parseDouble(newValue);
        }catch (Exception e){
            idTextField.setText(oldValue);
        }

    }

    @FXML
    public void onNameTextFieldChanges() {

    }

    @FXML
    public void onBrandTextFieldChanges() {

    }

    @FXML
    public void onPriceTextFieldChanges() {
    }

    @FXML
    public void onSaveButtonPressed() {
try {
    final ItemEntity itemEntity=new ItemEntity();
    if(!idTextField.getText().isEmpty()) {
        itemEntity.setItemId(Long.parseLong(idTextField.getText()));
    }
    itemEntity.setName(nameTextField.getText());
    itemEntity.setBrand(brandTextField.getText());
    if(priceTextField.getText().isEmpty()){
        FXUtils.showMessage(Alert.AlertType.ERROR,"price must be entered");
        return;
    }
    itemEntity.setPrice(Double.parseDouble(priceTextField.getText()));
    itemEntity.setItemType(itemTypeChoiceBox.getValue());
    itemService.save(itemEntity);
    FXUtils.showMessage(Alert.AlertType.INFORMATION,"item save successfully");
    itemsTables.setItems(FXCollections.observableList(findAll()));

}catch(Exception e){
    String error=e.getMessage();
    if (error.contains("items_uk1")) {
        error="Name already exist";
        FXUtils.showMessage(Alert.AlertType.ERROR, error);
    }
}
    }
        @FXML
    public void onDeleteButtonPressed() {
        if(idTextField.getText().isEmpty()){
            FXUtils.showMessage(Alert.AlertType.ERROR,"ID must be entered");
            return;
        }
            try {
                itemService.delete(Long.parseLong(idTextField.getText()));
                FXUtils.showMessage(Alert.AlertType.INFORMATION, "item deleted successfully");
                itemsTables.setItems(FXCollections.observableList(findAll()));

            } catch (Exception e){
             FXUtils.showMessage(Alert.AlertType.ERROR, e.getMessage());

            }
    }
    @FXML
    public void onFindBrandButtonPressed(){
        try {


            List<ItemEntity> items= itemService.findByBrand("lux");
//            ItemEntity entity=optionalItem.orElse(new ItemEntity());
//            if (optionalItem.isPresent()){
//                entity=optionalItem.get();
                System.out.println(items);
//            }else {
//                entity=new ItemEntity();
//      }
        }catch (Exception e){
            FXUtils.showMessage(Alert.AlertType.ERROR, e.getMessage());
        }
    }
    @FXML
    public void onFindNameButtonPressed(){
        try {
            List<ItemEntity> items= itemService.getByName(n);
            System.out.println(items);
            Boolean   exists= itemService.existsByName("LUX");
            System.out.println(exists);
            Boolean   notExists= itemService.existsByName("animal");
            System.out.println(notExists);
        }catch (Exception e){
            FXUtils.showMessage(Alert.AlertType.ERROR, e.getMessage());
        }
    }
    private static  List<String>getItemTypes(){
        return List.of("Finish Goods","Raw Material","All");
    }
}





