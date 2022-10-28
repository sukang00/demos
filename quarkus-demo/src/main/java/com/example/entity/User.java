package com.example.entity;

import javax.persistence.*;

/**
 * @author sukang
 * @version 1.0
 * @description: TODO
 * @date 2022/10/28 13:21
 */
@Entity
@Table(name = "user")
@NamedQuery(name = "User.findAll",query = "select u from User u ORDER BY u.id desc ", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@Cacheable
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_name")
    private String userName;
    @Column
    private String email;
    @Column
    private String phonenumber;
    @Column
    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
