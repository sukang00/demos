package com.example.demo.entity;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/11/3 11:17
 */
public class UserEntity {

    private Long id;
    private String name;
    private int age;
    private String adress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
