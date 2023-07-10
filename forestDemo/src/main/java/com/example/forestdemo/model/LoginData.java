package com.example.forestdemo.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class LoginData implements Serializable {

    private String userId;
    private String msg;
}
