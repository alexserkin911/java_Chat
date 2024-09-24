package ru.chat.java_chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AuthController {
    public TextField login;
    public TextField pass;

    public void enter(ActionEvent actionEvent) throws IOException {
       boolean autch = MockAutchService.getInstance().autch(login.getText(), pass.getText());
        if (autch){
            Parent chat = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chat.fxml")));
            Stage stage = new Stage();
            stage.setTitle("Сетевой чат");
            stage.setScene(new Scene(chat));
            stage.setResizable(false);
            stage.show();
            login.getScene().getWindow().hide();

        } else {
            System.out.println("WRONG LOGIN OR PASSWORD");
            pass.clear();
        }
    }

    public void reg(ActionEvent actionEvent) throws IOException {
        Parent reg = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registr.fxml")));
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(reg));
        stage.setResizable(false);
        stage.show();
        login.getScene().getWindow().hide();
    }
}
