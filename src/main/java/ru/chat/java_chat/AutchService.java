package ru.chat.java_chat;

public interface AutchService {

    void addUser(String name, String pass);

    boolean autch(String name, String pass);

}
