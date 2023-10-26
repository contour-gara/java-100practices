package myanswer01.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static java.util.Objects.requireNonNull;

@Component
@Aspect
@Slf4j
public class AopComponent {
    @After("within(myanswer01.presentation.MyController)")
    public void writeIp(JoinPoint joinPoint) {
        String ip = ((ServletRequestAttributes) requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest()
                .getRemoteAddr();
        log.debug("{}", ip);
    }
}
