package com.example.ojmproject.dto.block;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {

    private String type;
    private String text;

    public Message(String type, String text) {
        this.type = type;
        this.text = text;
    }
}
