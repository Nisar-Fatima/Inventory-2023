package com.alabtaal.inventory.controller;

import com.alabtaal.inventory.config.StageManager;
import com.alabtaal.inventory.enums.FxmlView;
import com.alabtaal.inventory.util.FXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class LoginController  implements Initializable {
    @FXML
    public void onUserTextFieldChange(){
        enableOrDisableLoginButton();
    }
    private final String username="nisar";
    private final String password="fatiMa";

    @FXML
    public void onUserPasswordFieldChange(){
        enableOrDisableLoginButton();
    }
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    private final StageManager stageManager;
    @FXML
    private Button loginButton;

    public LoginController(@Lazy StageManager stageManager) {
        this.stageManager = stageManager;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onLoginButtonPress() {
        if(!usernameTextField.getText().equalsIgnoreCase(username)){
            FXUtils.showMessage(Alert.AlertType.ERROR,"Username or Password is invalid");
            usernameTextField.requestFocus();
        }else if(!passwordTextField.getText().equals(password)){
            FXUtils.showMessage(Alert.AlertType.ERROR,"Username or Password is invalid ");
            passwordTextField.requestFocus();
        }else {
            stageManager.switchScene(FxmlView.MENU);
        }

        System.out.println(usernameTextField.getText());
        System.out.println(passwordTextField.getText());
    }

    private boolean isFormValid() {
        return usernameTextField.getText().length() >= 3 && passwordTextField.getText().length() >= 3;

    }
    private void enableOrDisableLoginButton(){
        loginButton.setDisable(!isFormValid());

    }
}
