package com.access.impl;

import com.access.dao.IPermissionDao;
import com.access.entity.PermissionEntity;
import com.access.entity.ResultEntity;
import com.access.interfaces.AccessControl;
import com.access.services.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermissionDao iPermissionDao;

//    @AccessControl(accessCode = "ONLYREAD",accessName = "只读")
    public ResultEntity findPermissionByRole(String roleId){
        ResultEntity resultEntity = new ResultEntity();
        List<PermissionEntity> list = iPermissionDao.findPermissionByRole(roleId);
        resultEntity.setData(list);
        return resultEntity;
    }

    public List<PermissionEntity> findAllPermission(){
        List<PermissionEntity> list = iPermissionDao.findAllPermission();
        return  list;
    }

}
