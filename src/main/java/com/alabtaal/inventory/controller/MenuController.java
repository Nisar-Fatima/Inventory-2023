package com.alabtaal.inventory.controller;

import com.alabtaal.inventory.config.SpringFXMLLoader;
import com.alabtaal.inventory.config.StageManager;
import com.alabtaal.inventory.enums.FxmlView;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class MenuController implements Initializable {
    private final StageManager stageManager;
    private final SpringFXMLLoader fxmlLoader;
    @FXML
  private BorderPane rootBorderPane;
    @FXML
    public void onItemsMenuItemSelected(){
        try {
            switchView(FxmlView.ITEMS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onPage2MenuItemSelected(){
        try {
            switchView(FxmlView.ITEMSALE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onCloseMenuItemSelected(){
        Platform.exit();
    }

    public MenuController(@Lazy StageManager stageManager, SpringFXMLLoader fxmlLoader) {
        this.stageManager = stageManager;
        this.fxmlLoader = fxmlLoader;
    }


    private void switchView(FxmlView fxmlView) throws IOException {
final Parent view=fxmlLoader.load(fxmlView.getFxmlFile());
stageManager.getStage().setTitle(fxmlView.getTitle());
rootBorderPane.setCenter(view);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            switchView(FxmlView.HOME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
