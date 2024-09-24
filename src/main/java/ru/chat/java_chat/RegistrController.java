package ru.chat.java_chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegistrController {
    public TextField login;
    public TextField pass;

    public void enter(ActionEvent actionEvent) throws IOException {
        MockAutchService.getInstance().addUser(login.getText(), pass.getText());
        Parent chat = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chat.fxml")));
        Stage stage = new Stage();
        stage.setTitle("Сетевой чат");
        stage.setScene(new Scene(chat));
        stage.setResizable(false);
        stage.show();
        login.getScene().getWindow().hide();
    }
}
