package com.example.ojmproject.dto.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
public class EventBase {


    private String type;
    private ArrayList<Object> elements;


}
