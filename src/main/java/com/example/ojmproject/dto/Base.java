package com.example.ojmproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class Base {
    private String response_type;

    private String type;
    private String callback_id;
    private ArrayList<Object> blocks;





}
