package com.access.dao;

import com.access.entity.PermissionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPermissionDao {

    List<PermissionEntity> findPermissionByRole(String roleid);

    List<PermissionEntity> findAllPermission();

//    List<PermissionEntity> savePermission(PermissionEntity permissionEntity);
//    List<PermissionEntity> updatePermission(PermissionEntity permissionEntity);
//    List<PermissionEntity> deletePermissionInRole(String permissionId,String roleId);
}
