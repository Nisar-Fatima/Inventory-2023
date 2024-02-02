//package com.alabtaal.inventory.controller;
//import com.alabtaal.inventory.entity.ItemEntity;
//import com.alabtaal.inventory.entity.ItemSalesEntity;
//import com.alabtaal.inventory.repository.ItemSaleRepo;
//import com.alabtaal.inventory.service.ItemService;
//import com.alabtaal.inventory.util.FXUtils;
//import javafx.beans.property.SimpleStringProperty;
//import javafx.collections.FXCollections;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.*;
//import org.springframework.stereotype.Controller;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.ResourceBundle;
//@Controller
//public class ItemSaleController implements Initializable {
//    private final ItemService itemService;
//    private final ItemSaleRepo itemSaleRepo;
//    private DatePicker datePicker;
//
//    @FXML
//    private ChoiceBox<String> itemChoiceBox;
//    @FXML
//    private TextField quantityTextField;
//    @FXML
//    private TextField discountTextField;
//    @FXML
//    private TextField priceTextField;
//
//    @FXML
//    private TableView<ItemSalesEntity> itemsTables;
//    @FXML
//    private TableColumn<ItemSalesEntity,String> brandColumn;
//    @FXML
//    private TableColumn<ItemSalesEntity, String> quantityColumn;
//    @FXML
//    private TableColumn<ItemSalesEntity, String> nameColumn;
//    @FXML
//    private TableColumn<ItemSalesEntity, String> priceColumn;
////    private String oldValue = "";
//
//    public ItemSaleController(ItemService itemService, ItemSaleRepo itemSaleRepo) {
//        this.itemService = itemService;
//        this.itemSaleRepo = itemSaleRepo;
//    }
//
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        itemChoiceBox.setItems(FXCollections.observableList(getItem()));
//        setUpItemSaleTable();
//    }
//    private List<ItemEntity> findAll() {
//        return itemService.findAll();
//    }
//
//    private void setUpItemSaleTable() {
//        nameColumn.setCellValueFactory(
//                (cellData) -> new SimpleStringProperty(cellData.getValue().getItem().getBrand())
//        );
//        brandColumn.setCellValueFactory(
//                (cellData) -> new SimpleStringProperty(cellData.getValue().getItem().getName())
//        );
//
//        quantityColumn.setCellValueFactory(
//                (cellData) -> new SimpleStringProperty(String.valueOf(cellData.getValue().getQuantity())));
//        priceColumn.setCellValueFactory(
//                (cellData) -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPrice()))
//        );
//        itemsTables.setItems(FXCollections.observableList(itemSaleRepo.findAll()));
//        itemsTables.getSelectionModel().selectedItemProperty().addListener(
//                (observable, oldSelection, newSelection) -> {
//                    if (newSelection != null) {
//                        quantityTextField.setText(String.valueOf(newSelection.getQuantity()));
//                        discountTextField.setText(String.valueOf(newSelection.getDiscount()));
//                        priceTextField.setText(String.valueOf(newSelection.getPrice()));
//                        if (newSelection.getItem().getItemType() != null) {
//                            itemChoiceBox.setValue(newSelection.getItem().getItemType());
//                        } else {
//                            itemChoiceBox.setValue("");
//                        }
//                    }
//                }
//        );
//    }
//
//    @FXML
//    public  void onSaveButtonPressed() {
//        try {
//          final ItemEntity item= (ItemEntity)itemService.(itemChoiceBox.getValue());
//            final ItemSalesEntity itemEntity = new ItemSalesEntity();
//            itemEntity.setItem(item);
//            itemEntity.setDiscount(Long.parseLong(discountTextField.getText()));
//            if (priceTextField.getText().isEmpty()) {
//                FXUtils.showMessage(Alert.AlertType.ERROR, "price must be entered");
//                return;
//            }
//            itemEntity.setPrice(Double.parseDouble(priceTextField.getText()));
//            itemEntity.setQuantity(Long.parseLong(quantityTextField.getText()));
//           itemSaleRepo.save(itemEntity);
//            FXUtils.showMessage(Alert.AlertType.INFORMATION, "item save successfully");
//            itemsTables.setItems(FXCollections.observableList(itemSaleRepo.findAll()));
//
//        } catch (Exception e) {
//            String error = e.getMessage();
//            if (error.contains("items_uk1")) {
//                error = "Name already exist";
//                FXUtils.showMessage(Alert.AlertType.ERROR, error);
//            }
//        }
//    }
//
//    @FXML
//    public void onDeleteButtonPressed() {
////        try {
////            FXUtils.showMessage(Alert.AlertType.INFORMATION, "item deleted successfully");
////            itemsTables.setItems(FXCollections.observableList(findAll()));
////
////        } catch (Exception e) {
////            FXUtils.showMessage(Alert.AlertType.ERROR, e.getMessage());
////
////        }
//        System.out.println("Delete button disabled");
// }
//
//    @FXML
//    public void onFindBrandButtonPressed() {
//        try {
//
//
//            List<ItemEntity> items = itemService.findByBrand("lux");
//            System.out.println(items);
//        } catch (Exception e) {
//            FXUtils.showMessage(Alert.AlertType.ERROR, e.getMessage());
//        }
//    }
//    private  List<String>getItem(){
//        List<String> itemNames=new ArrayList<>();
//        List<ItemEntity> items= findAll();
//        for (ItemEntity item:items){
//            itemNames.add(item.getName());
//        }
//        return itemNames;
//    }
//}


