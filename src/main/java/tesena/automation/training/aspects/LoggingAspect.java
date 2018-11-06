package tesena.automation.training.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import tesena.automation.training.logger.TestLogger;

import java.util.Arrays;

@Aspect
public class LoggingAspect {
    String test = "clean test -Dtest=PageObjectsTest";

    @Pointcut("execution(* *.*(..)) && this(tesena.automation.training.driver.PageObject+)")
    public void pageObjectMethods(){
    }

    @Before("pageObjectMethods()")
    public void logPageObjectMethods(JoinPoint joinPoint) {
        Object [] arguments = joinPoint.getArgs();
        CodeSignature signature = (CodeSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        String className = joinPoint.getThis().getClass().getSimpleName();
        StringBuilder builder = new StringBuilder();
        builder
                .append(className)
                .append(".")
                .append(methodName)
                .append(Arrays.toString(arguments));

        TestLogger.getLogger().info(builder.toString());
    }
}
