package ru.gb.market.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;;
import org.springframework.stereotype.Component;
import ru.gb.market.services.StatisticService;


import java.time.Instant;

@Aspect
@Component
@RequiredArgsConstructor
public class TimeStatisticAspect {
    private final StatisticService statisticService;

    @Around("execution(* ru.gb.market.services.*.*(..)) && !within(*..StatisticService)")
    public Object calculateTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        Instant end = Instant.now();

        long duration = end.toEpochMilli() - start.toEpochMilli();
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        String[] methodSplitInfo = ms.toString().split("\\.");
        String methodName = methodSplitInfo[methodSplitInfo.length - 1];


        String serviceName = joinPoint.getTarget().getClass().getSimpleName();
        statisticService.updateStatistic(serviceName, methodName, duration);

        return result;
    }

}





