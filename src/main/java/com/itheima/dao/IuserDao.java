package com.itheima.dao;


import com.itheima.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IuserDao {
     /*查询所有用户*/
     /*注解开发*/


     @Select("select * from user")
     @Results(id = "userMap",
             value ={
                    @Result(id = true,column = "id",property = "user")


     })
     List<User> findAll();



     }