package com.itheima.dao;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IRoleDao {

    /**
     * 根据id查询role表
     * @param id
     * @return
     */
    @Select("select * from role where id = #{id}")
    Role findById(int id);

    /**
     * 查询全部Role数据并关联User数据
     * @return
     */
    @Select("select * from role")
    @Results(id = "findRole",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "rolename"),
            @Result(column = "roleDesc",property = "roledesc"),
            @Result(property = "users",column = "id",
                    many = @Many(select = "com.itheima.dao.IUserDao.findByRid",fetchType = FetchType.LAZY ))
    })
    List<Role> findAll();
}
