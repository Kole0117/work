package com.access.advices;

import com.access.entity.PermissionEntity;
import com.access.entity.ResultEntity;
import com.access.interfaces.AccessControl;
import com.access.services.IPermissionService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;


@Aspect
@Component
@ResponseBody
public class AccessControlAdvices{

    @Autowired
    private IPermissionService iPermissionService;

    /**
     * 自定义切面 在自定义的注解下的服务都会进入advice中 在advice中来进行权限的认证管理
     * @param accessControl 自定义的注解 其中会带有自己设置的参数 根据参数在权限表中的有无来控制是否通过权限认证
     * @return ResultEntity 返回的数据信息
     * @throws Throwable
     */
    @Around(value = "@annotation(accessControl)")
    public void Around(ProceedingJoinPoint proceedingJoinPoint,AccessControl accessControl) throws Throwable{
        ResultEntity resultEntity = new ResultEntity();
        // 获取权限（此处只进行了简单的权限查询，正确的流程应该是从Session中获取登陆的用户信息，在通过用户的角色来查询权限）
        List<PermissionEntity> list = iPermissionService.findAllPermission();
        // 定义权限认证是否通过的标识（默认false 不通过）
        boolean isAccess = false;
        // 判断是否存在该权限
        for(PermissionEntity permissionEntity:list){
            if(permissionEntity.getAccessCode().equals(accessControl.accessCode())){
                isAccess = true;
                break;
            }
        }
        //根据是否拥有权限返回将信息放入返回的对象中。
        if(isAccess){
            resultEntity.setResultCode("200");
            resultEntity.setResuleMsg("success");
            //获取类的字节码对象，通过字节码对象获取方法信息
            Class<?> targetCls = proceedingJoinPoint.getTarget().getClass();
            //获取方法签名(通过此签名获取目标方法信息)
            MethodSignature ms=(MethodSignature)proceedingJoinPoint.getSignature();
            Method targetMethod=
                    targetCls.getDeclaredMethod(
                            ms.getName(),
                            ms.getParameterTypes());
            // 获取目标方法名(目标类型+方法名)
            String targetClsName=targetCls.getName();
            String targetObjectMethodName=targetClsName+"."+ms.getName();
            //获取请求参数
            String targetMethodParams= Arrays.toString(proceedingJoinPoint.getArgs());
            Object[] objects = new Object[]{resultEntity};
            // 权限认证通过 方法继续执行
            proceedingJoinPoint.proceed(objects);
        }else {
            resultEntity.setResultCode("403");
            resultEntity.setResuleMsg("no permission");
            Object[] objects = new Object[]{resultEntity};
            proceedingJoinPoint.proceed(objects);
        }
    }
}
