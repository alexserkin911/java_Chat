package ru.chat.java_chat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FileHistoryService implements HistoryService {

    private static FileHistoryService instance;
    private String patch = "history.txt";

    private FileHistoryService(){

    }

    public static FileHistoryService getInstance(){
        return instance == null ?
                new FileHistoryService() : instance;
    }

    @Override
    public void save(List<String> chat){
        try {
            Files.write(Paths.get(patch), chat, StandardOpenOption.CREATE);
        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<String> load() throws IOException {
        if (Files.exists(Paths.get(patch))){
            return Files.newBufferedReader(Paths.get(patch))
                    .lines()
                    .collect(Collectors.toList());

        } else {
            return List.of();
        }
    }
}
