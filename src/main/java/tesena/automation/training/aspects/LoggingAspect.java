package tesena.automation.training.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;

import java.util.Arrays;

@Aspect
public class LoggingAspect {
    private Logger logger = LogManager.getLogger();

    @Pointcut("execution(* *.*(..)) && this(tesena.automation.training.driver.PageObject+)")
    public void pageObjectMethods() {
    }

    private String getMethodName(JoinPoint joinPoint) {
        CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
        return codeSignature.getName();
    }

    private String getArguments(JoinPoint joinPoint) {
        Object [] arguments = joinPoint.getArgs();
        if (arguments.length == 0) {
            return "";
        }
        return Arrays.toString(arguments);
    }

    private String getClassName(JoinPoint joinPoint) {
        return joinPoint.getThis().getClass().getCanonicalName();
    }

    @Before("pageObjectMethods()")
    public void log(JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder();
        builder
                .append(getClassName(joinPoint))
                .append(".")
                .append(getMethodName(joinPoint))
                .append("(")
                .append(getArguments(joinPoint))
                .append(")");
        logger.info(builder.toString());
    }

    @Around("pageObjectMethods()")
    public Object process(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            long startTime = System.currentTimeMillis();
            Object object = proceedingJoinPoint.proceed();
            long endTime = System.currentTimeMillis() - startTime;
            return object;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
