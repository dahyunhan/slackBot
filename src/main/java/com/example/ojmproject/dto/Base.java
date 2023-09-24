package com.example.ojmproject.dto;

import com.example.ojmproject.dto.events.EventBase;
import com.example.ojmproject.dto.profile.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
public class Base {
    private String response_type;
    private String response_url;
    private String type;
    private String callback_id;
    private ArrayList<Object> blocks;
    private boolean   replace_original;
    private String text;



}
