package com.example.ojmproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Blocks {
    private String type;

    public Blocks(String type) {
        this.type = type;
    }
}
