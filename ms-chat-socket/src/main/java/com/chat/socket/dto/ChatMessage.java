package com.chat.socket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ChatMessage {

    String message;
    String user;


    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }
}
