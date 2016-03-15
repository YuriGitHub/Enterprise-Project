package io.khasang.enterprise.service;

import io.khasang.enterprise.model.User;

public class ChatService {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String send(String user) {
        return "Пользователю " + user + " отправлено сообщение: " + message;
    }

    public String send() {
        return "Всем пользователям отправлено сообщение: " + message;
    }
}
