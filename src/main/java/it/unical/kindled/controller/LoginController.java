package it.unical.kindled.controller;

import it.unical.kindled.model.User;
import it.unical.kindled.service.AuthService;
import it.unical.kindled.service.SessionManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private final AuthService authService = new AuthService();
    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private CheckBox rememberMeCheck;

    @FXML
    private TextField usernameField;

    @FXML
    void onForgotPassword(ActionEvent event) {
        errorLabel.setText("Non posso aiutarti, prova a ricordartela <3");
        errorLabel.setVisible(true);
        errorLabel.setManaged(true);
    }

    @FXML
    void onGoToRegister(ActionEvent event) {
            //Da implementare frontend registrazione
    }

    @FXML
    void onLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();
        User user = authService.login(username, password);
        if (user != null) {
            SessionManager.getInstance().setLoggedUser(user);
            errorLabel.setVisible(false);
            System.out.println("utente loggato con successo! " + user.getUsername());
            //DA IMPLEMENTARE IL CAMBIO SCENA VERSO LA LIBREARIA
        } else {
            errorLabel.setText("Username o password errati");
            errorLabel.setVisible(true);
            errorLabel.setManaged(true);
        }
    }

}
