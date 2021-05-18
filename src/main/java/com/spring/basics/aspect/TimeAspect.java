package com.spring.basics.aspect;

import com.spring.basics.dto.WrapperResponseDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TimeAspect {
    @Around(value = "execution(* com.spring.basics.services.impletentations.SignInServiceImpl.*(..))")
    public ResponseEntity<WrapperResponseDto> addTimeResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        long before = System.currentTimeMillis();
        Object responseEntity = joinPoint.proceed();
        long after = System.currentTimeMillis();
        ResponseEntity response = (ResponseEntity)responseEntity;
        return ResponseEntity.ok(WrapperResponseDto.builder()
                .time(after - before)
                .data(response.getBody())
                .build());
    }
}
