package com.fc.aop;


import com.fc.model.UserRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class TimerAop {

    // 관심을 둘 클래스나 메소드를 지정(pointcut)
    @Pointcut(value = "within(com.fc.controller.UserApiController)")
    public void timerPointCut(){

    }

    @Before(value = "timerPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("before");

    }

    @After(value = "timerPointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("after");

    }

    @AfterReturning(value = "timerPointCut()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        System.out.println("afterReturning");
    }

    @AfterThrowing(value = "timerPointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Exception ex){
        System.out.println("afterThrowing");
    }

    // 위 포인트컷을 around(메소드 실행 전후)에 적용.
    @Around(value = "timerPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("메소드 실행 이전");

        // 지정한 메소드의 매개변수를 가져올 수 있음.
        Arrays.stream(joinPoint.getArgs()).forEach(
                it -> {
                    if(it instanceof UserRequest){
                        var tempUser = (UserRequest)it;
                        var phoneNumber = tempUser.getPhoneNumber().replace("-", "");
                        tempUser.setPhoneNumber(phoneNumber);
                    }
                }
        );

        // 임의의 매개변수를 넣어서 보내서 수행할 수도 있음.
        // 암/복호화나 로깅 과정 중에 활용 가능.
        var newObjs = List.of(
                new UserRequest()
        );

        var stopWatch = new StopWatch();
        stopWatch.start();

        joinPoint.proceed(newObjs.toArray());

        stopWatch.stop();

        System.out.println("총 소요된 시간 MS: " + stopWatch.getTotalTimeMillis());

        System.out.println("메소드 실행 이후");
    }
}
