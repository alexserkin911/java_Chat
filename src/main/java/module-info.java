module ru.chat.java_chat {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.chat.java_chat to javafx.fxml;
    exports ru.chat.java_chat;
}