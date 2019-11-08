package tesena.automation.training.aspects;

import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import tesena.automation.training.logger.TestLogger;

import java.util.Arrays;

@Aspect
public class LoggingAspect {

    @Pointcut("execution(* *.*(..)) && this(tesena.automation.training.driver.PageObject+)")
    public void pageObjectMethods() {
    }

    @Before(value = "pageObjectMethods()")
    public void logMethod(JoinPoint joinPoint) {
        Logger logger = TestLogger.getLogger();
        Object[] args = joinPoint.getArgs();
        String className = joinPoint.getThis().getClass().getCanonicalName();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info(className + "." + methodSignature.getMethod().getName() + Arrays.toString(args));
    }
}
