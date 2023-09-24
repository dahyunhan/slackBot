package com.example.ojmproject.dto.block;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class Actions {
    private String type;
    private String block_id;
    private ArrayList<Object> elements;
}
