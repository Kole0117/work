package com.access.services;

import com.access.entity.PermissionEntity;
import com.access.entity.ResultEntity;

import java.util.List;

public interface IPermissionService {

    ResultEntity findPermissionByRole(String roleId);
    List<PermissionEntity> findAllPermission();
//    List<PermissionEntity> savePermission(PermissionEntity permissionEntity);
//    List<PermissionEntity> updatePermission(PermissionEntity permissionEntity);
//    List<PermissionEntity> deletePermissionInRole(String permissionId,String roleId);

}
