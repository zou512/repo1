package com.itheima.domain;

import java.util.Date;

/**
 * (User)表实体类
 *
 * @author makejava
 * @since 2018-08-12 21:17:31
 */
public class User {
    
    private Integer id;
    //用户名称
    private String username;
    //生日
    private Date birthday;
    //性别
    private Object sex;
    //地址
    private String address;
    
    private Integer rid;

    private Role role;

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Object getSex() {
        return sex;
    }

    public void setSex(Object sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", rid=" + rid +
                '}';
    }
}