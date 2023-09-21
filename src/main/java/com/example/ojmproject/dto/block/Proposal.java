package com.example.ojmproject.dto.block;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proposal {


    private String type;
    private Message text;

    public Proposal(String type, Message text) {
        this.type = type;
        this.text = text;
    }
}
