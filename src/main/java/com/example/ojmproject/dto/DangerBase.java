package com.example.ojmproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class DangerBase {
    private boolean replace_original;
    private String text;
    private ArrayList <Object> elements;

}
