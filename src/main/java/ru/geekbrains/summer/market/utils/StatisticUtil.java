package ru.geekbrains.summer.market.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Aspect
@Service
public class StatisticUtil {

    @Around("execution(public * ru.geekbrains.summer.market.services.*.*(..))")
    public Object calculatingExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        String message = proceedingJoinPoint.getTarget().getClass().getName() + " - " + duration + "ms";
        System.out.println(message);
        return out;
    }
}
