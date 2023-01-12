package org.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2023/1/10 10:32
 */
@Data
public class User implements Serializable {

    private Long id;
    private String name;
    private String email;

    private String remark;
}
