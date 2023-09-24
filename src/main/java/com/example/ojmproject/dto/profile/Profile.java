package com.example.ojmproject.dto.profile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Profile {
    private String type;
    private ArrayList<Object > elements;
}
