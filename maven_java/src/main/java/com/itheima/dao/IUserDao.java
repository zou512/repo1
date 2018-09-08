package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import javax.annotation.Resources;
import java.util.List;

public interface IUserDao {

    /**
     * 查询user表关联role表所有数据
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "findUser", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "address", property = "address"),
            @Result(column = "rid", property = "rid"),
            @Result(property = "role", column = "rid", one = @One(
                    select = "com.itheima.dao.IRoleDao.findById",
                    fetchType = FetchType.LAZY
            ))
    })
    List<User> findAll();

    /**
     * 根据rid查询user
     * @param rid
     * @return
     */
    @Select("select * from user where rid = #{rid}")
    @ResultMap("findUser")
    List<User> findByRid(int rid);

    /**
     * 根据姓名地址动态模糊查询
     *
     * @return
     */
    @Select("<script>" +
            "select * from user" +
              "<where>" +
            "<if test='username!=null'>" +
            "and username like #{username}" +
            "</if>" +
            "<if test='address!=null'>" +
            "and address like #{address}" +
            "</if>" +
              "</where>" +
            "</script>")
    List<User> findByName(User user);
}
