package ru.chat.java_chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChatController implements Initializable {
    public TextArea output;
    public TextField input;

    public void send(ActionEvent actionEvent) {
        output.appendText(input.getText() + "\n");
        input.clear();
    }

    public void quit(ActionEvent actionEvent) throws IOException {
        Parent reg = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("auth.fxml")));
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(reg));
        stage.setResizable(false);
        stage.show();
        input.getScene().getWindow().hide();
        try {
            FileHistoryService.getInstance().save(Arrays.asList(output.getText().split("\n").clone()));
        } catch (Exception e) {
            System.err.println("Ошибка сохранения истории: " + e.getMessage());
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        try {
            FileHistoryService.getInstance().load().forEach(historyLine -> {
                output.appendText(historyLine + "\n");
            });
        } catch (IOException e) {
            System.err.println("Ошибка загрузки истории: " + e.getMessage());
        }
    }
}
