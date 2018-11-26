package com.itheima;

import com.itheima.dao.IuserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisTestUser {


    private InputStream rs;
    private SqlSessionFactory factory;
    private SqlSession session;
    private IuserDao iuserDao;


    @Before//测试方法前执行
    public void init() throws Exception {


        rs = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2创建SQLSessionFactory工厂
        factory = new SqlSessionFactoryBuilder().build(rs);
        //2.1把配置文件加载到工厂

        //3使用工厂生产对象
        session = factory.openSession();

        //4使用SQLSession创建DAO接口对象
        iuserDao = session.getMapper(IuserDao.class);
        //5使用DAO对象调用接口方法,完成数据库查询

    }


    @After//测试方法后执行
    public void destroy() throws Exception {
        session.commit();
        //释放资源
        session.close();
        rs.close();
    }


    @Test
    public void findTest(){
        List<User> all = iuserDao.findAll();
        for (User user : all) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }


    }







}