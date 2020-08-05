package com.access.impl;

import com.access.dao.IUserDao;
import com.access.entity.ResultEntity;
import com.access.entity.UserEntity;
import com.access.interfaces.AccessControl;
import com.access.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements IUserService {

    @Autowired
    private IUserDao IUserDao;

    @AccessControl(accessCode = "ONLYREAD",accessName = "只读")
    public ResultEntity findAllUsers(ResultEntity resultEntity){
        List<UserEntity> list = IUserDao.findAllUsers();
        resultEntity.setData(list);
        resultEntity.setResultCode("200");
        resultEntity.setResuleMsg("success");
        return resultEntity;
    }
}
