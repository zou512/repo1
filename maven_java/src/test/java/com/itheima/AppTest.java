package com.itheima;

import com.itheima.dao.IRoleDao;
import com.itheima.dao.IUserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class AppTest {
    private InputStream is;
    private SqlSession session;

    /**
     * 加载资源
     * @throws IOException
     */
    @Before
    public void resources() throws IOException {
         is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
         session = factory.openSession();
    }

    /**
     * 释放资源
     * @throws IOException
     */
    @After
    public void release() throws IOException {
        session.commit();
        session.close();
        is.close();
    }

    /**
     * 查询user表所有数据
     */
    @Test
    public void co1(){
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        List<User> list = iUserDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 根据id查询role
     */
    @Test
    public void co2(){
        IRoleDao iRoleDao = session.getMapper(IRoleDao.class);
        Role role = iRoleDao.findById(1);
        System.out.println(role);
    }
    /**
     * 查询user表关联role表所有数据
     */
    @Test
    public void co3(){
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        List<User> list = iUserDao.findAll();
        for (User user : list) {
            System.out.println("========华丽丽的分割线=========");
            System.out.println(user.getUsername());
            System.out.println(user.getRole().getRolename());
        }
    }

    /**
     * 动态sql模糊查询
     */
    @Test
    public void co4(){
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        User user1 = new User();
//        user1.setUsername("%王%");
        user1.setAddress("%金%");
        List<User> list = iUserDao.findByName(user1);
        for (User user : list) {
            System.out.println("========华丽丽的分割线=========");
//            System.out.println(user.getUsername());
//            System.out.println(user.getRole().getRolename());
            System.out.println(user);
        }
    }

    /**
     * 根据rid查询user表
     */
    @Test
    public void co5(){
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        List<User> list = iUserDao.findByRid(1);
        for (User user : list) {
            System.out.println(user);
        }
    }

    /**
     * 查询全部Role数据并关联User数据
     */
    @Test
    public void co6(){
        IRoleDao iRoleDao = session.getMapper(IRoleDao.class);
        List<Role> list = iRoleDao.findAll();
        for (Role role : list) {
            System.out.println("================华丽丽的分割线================");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }


    @Test
    public void co7(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        SqlSession seesion = (SqlSession) context.getBean("session");
        IUserDao iUserDao = seesion.getMapper(IUserDao.class);
        List<User> list = iUserDao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }

    @Test
    public void co8(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user =context.getBean("user",User.class);
        System.out.println(user);
        System.out.println(user.getRole());
    }

    @Test
    public void co9(){
    DBAssit
    }



}
