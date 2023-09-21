package com.example.ojmproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {


    private String id;
    private String username;
    private String team_id;

    public User(String id, String username, String team_id) {
        this.id = id;
        this.username = username;
        this.team_id = team_id;
    }
}