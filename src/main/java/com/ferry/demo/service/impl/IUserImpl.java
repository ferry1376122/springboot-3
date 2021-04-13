package com.ferry.demo.service.impl;

import com.ferry.demo.bean.User;
import com.ferry.demo.mapper.UserDAO;
import com.ferry.demo.service.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IUserImpl implements IUser {

    @Autowired
    private UserDAO userDao;

    @Override
    public User getById(Integer id) {
        return userDao.selectByPrimaryKey(id);
    }
}
