package com.itheima.domain;


import java.util.List;

/**
 * (Role)表实体类
 *
 * @author makejava
 * @since 2018-08-12 21:17:48
 */
public class Role {
    //编号
    private Integer id;
    //角色名称
    private String rolename;
    //角色描述
    private String roledesc;

    private List<User> users;

    public Role() {
    }

    public Role(Integer id, String rolename, String roledesc) {
        this.id = id;
        this.rolename = rolename;
        this.roledesc = roledesc;
    }

    public Role(Integer id, String rolename, String roledesc, List<User> users) {
        this.id = id;
        this.rolename = rolename;
        this.roledesc = roledesc;
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", roledesc='" + roledesc + '\'' +
                '}';
    }
}