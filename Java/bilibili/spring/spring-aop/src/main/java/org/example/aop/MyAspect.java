package org.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author makun
 * @project spring
 * @description 我的切面
 * @date 2022/12/09 12:48:26
 * version 1.0
 */
// 让Spring将通知装入容器中
@Component
// 将类声明为切面，让Spring识别里面与切面相关的的注解
@Aspect
public class MyAspect {
    // 定义切入点匹配规则，表示匹配org.example.service.impl.UserServiceImpl类中所有为find前缀的public方法，不管形参有多少
    @Pointcut("execution(public * org.example.service.impl.UserServiceImpl.find*(..))")
    private void servicePointCut() {}

    // 定义切入点匹配规则，用来测试我的后置异常通知
    @Pointcut("execution(public void org.example.service.impl.UserServiceImpl.testException())")
    private void serviceExceptionPointCut() {}

    // 定义前置通知，配置设置好的切入点匹配规则
    @Before("MyAspect.servicePointCut()")
    public void before() {
        System.out.println("我是前置通知");
    }

    // 定义后置通知
    @After("MyAspect.servicePointCut()")
    public void after() {
        System.out.println("我是后置通知");
    }

    // 定义环绕通知
    @Around("MyAspect.servicePointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 用于获取切入点方法的签名
        Signature signature = proceedingJoinPoint.getSignature();
        // 获取方法的类名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取方法名
        String name = signature.getName();
        long start = System.currentTimeMillis();
        // 使用此方法执行切入点的方法
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        // 打印方法执行花费时间
        System.out.println(declaringTypeName + "." + name + "使用了" + (end - start) + "ms");
        return result;
    }

    // 定义后置返回通知，将返回结果与形参绑定，如果使用JoinPoint，那么一定要放在第一个形参
    @AfterReturning(value = "MyAspect.servicePointCut()", returning = "result")
    public Object afterReturn(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("这是" + signature.getName() + "方法");
        System.out.println(result);
        return result;
    }

    // 定义后置返回通知，将异常结果与形参绑定，如果使用JoinPoint，那么还是需要放在形参的第一个位置
    @AfterThrowing(value = "MyAspect.serviceExceptionPointCut()", throwing = "throwable")
    public void afterException(JoinPoint joinPoint, Throwable throwable) {
        System.out.println(joinPoint.getSignature().getName() + "发生了" + throwable.getMessage() + "异常");
    }
}
