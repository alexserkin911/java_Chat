package ru.chat.java_chat;

import java.io.IOException;
import java.util.List;

public interface HistoryService {


    void save(List<String> chat);

    List<String> load() throws IOException;


}
