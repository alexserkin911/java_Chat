package ru.chat.java_chat;

import java.util.HashMap;

public class MockAutchService implements AutchService {
    private static MockAutchService instance;
    private HashMap<String, String> userDao;

    private MockAutchService(){
        userDao = new HashMap<>();
        userDao.put("user", "pass");
    };

    public static MockAutchService getInstance() {
        if (instance == null){
            instance = new MockAutchService();
        }
        return instance;
    }

    @Override
    public void addUser(String name, String pass) {
        userDao.put(name,pass);

    }

    @Override
    public boolean autch(String name, String pass) {
        return userDao.get(name) != null;
    }
}
