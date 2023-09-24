package com.example.ojmproject.dto.events;

import com.example.ojmproject.dto.Base;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EventText {
    private String channel;
    private String text;
}
