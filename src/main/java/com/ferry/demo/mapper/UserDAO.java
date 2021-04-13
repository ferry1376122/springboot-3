package com.ferry.demo.mapper;

import com.ferry.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * UserDAO继承基类
 */
@Mapper
public interface UserDAO extends MyBatisBaseDao<User, Integer> {

}