package com.test.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeLogger {

    private static final Logger LOG = Logger.getAnonymousLogger();

    @Pointcut("execution(* com.test.aspect.logged.LongWait.*(..))")
    public void longWaits() { }

    @Around("longWaits()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final String methodName = joinPoint.getSignature().getName();
        final String className = joinPoint.getTarget().getClass().getName();

        final long start = System.currentTimeMillis();
        final Object result = joinPoint.proceed();
        final long end = System.currentTimeMillis() - start;

        LOG.info(String.format("%s.%s() executed for %dms\n", className, methodName, end));
        return result;
    }
}
