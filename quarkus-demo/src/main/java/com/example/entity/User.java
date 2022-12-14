package com.example.entity;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
@Schema( description = "这是一个用户的传输实体")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;
    @NotBlank(message="用户名不能为空")
    @Column(name = "user_name")
    @Schema(title = "用户名", required = true, example = "kl")
    private String userName;
    @NotBlank(message="邮箱不能为空")
    @Column
    @Schema(title = "邮箱", required = true, example = "kl@163.com")
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
