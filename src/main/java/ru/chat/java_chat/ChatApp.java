package ru.chat.java_chat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ChatApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent auth = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("auth.fxml")));
        stage.setTitle("Авторизация");
        stage.setScene(new Scene(auth));
        stage.setResizable(false);
        stage.show();
    }
}
