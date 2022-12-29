package org.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/12/29 15:39
 */
@Data
public class User implements Serializable {

    private String userName;
    private String age;
    private String phone;


}
