package com.access.controller;

import com.access.entity.ResultEntity;
import com.access.services.IPermissionService;
import com.access.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IPermissionService iPermissionService;

    /**
     * 查询所有的用户信息
     * @return ResultEntity 返回的信息（200成功返回，403没有权限）
     */
    @RequestMapping("getAll")
    public ResultEntity findAllUsers(){
        ResultEntity resultEntity = new ResultEntity();
        resultEntity = userService.findAllUsers(resultEntity);
        return resultEntity;
    }
}
