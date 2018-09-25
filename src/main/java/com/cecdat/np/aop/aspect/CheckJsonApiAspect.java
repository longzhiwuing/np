package com.cecdat.np.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: chenzhongyong@cecdat.com
 * Date: 2018/3/8
 * Time: 10:29
 */
@Aspect
@Component
@Slf4j
public class CheckJsonApiAspect {

    @Pointcut("@annotation(com.cecdat.np.aop.annotations.CheckJsonApi)")
    public void checkJsonApi() {

    }

    @Around("checkJsonApi()")
    public Object check(ProceedingJoinPoint pjp) {
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();
        log.info("method:{}",targetMethod.getName());
        Object result = null;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("result:{}",result);

        return result;
    }

}
