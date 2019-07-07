package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author wangyangkun
 * @date 2019/7/6 0006 18:01
 */
@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;


    @Around("execution(* com.itheima.ssm.controller.*.*(..)) && @annotation(anno)")
    public Object around(ProceedingJoinPoint pjp, RequestMapping anno){
        //得到类名
        String className = pjp.getTarget().getClass().getSimpleName();
        String clazz =  "SysLogController";
        Object proceed = null;
        if (clazz.equals(className)){
            try {
                proceed = pjp.proceed();
                return proceed;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                throw new RuntimeException(throwable);
            }
        }else {
            //获取开始时间
            Date visitTime = new Date();
            //获取用户名
            SecurityContext context = SecurityContextHolder.getContext();
            User principal = (User) context.getAuthentication().getPrincipal();
            String username = principal.getUsername();
            //获取ip
            String ip = request.getRemoteAddr();
            //获取请求路径url
            String url = request.getRequestURI();
            //获取请求方法名
            String methodName = pjp.getSignature().getName();

            //获取目标类和方法上的注解
            RequestMapping classAnnotation = pjp.getTarget().getClass().getAnnotation(RequestMapping.class);

            long start = System.nanoTime();
            try {
                proceed = pjp.proceed();
                return proceed;
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                throw new RuntimeException(throwable);
            }finally {
                long end = System.nanoTime();
                long executionTime = end - start;

                //将日志信息存储到对象中,调用service层,保存
                SysLog sysLog = new SysLog();
                sysLog.setExecutionTime(executionTime);
                sysLog.setIp(ip);
                sysLog.setMethod(methodName);
                sysLog.setUrl(url);
                sysLog.setUsername(username);
                sysLog.setVisitTime(visitTime);
                sysLogService.save(sysLog);

                System.out.println(visitTime);
                System.out.println(url);
                System.out.println(username);
                System.out.println(ip);
                System.out.println("类名:"+className + "  方法名:" + methodName);
                System.out.println(executionTime);
                System.out.println("方法注解:"+anno);
                System.out.println("类的注解:"+classAnnotation);
            }
        }

    }

}
