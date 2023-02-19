package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

    @Pointcut("execution(* aopdemo.dao.*.*(..))")
    public void forDAOPackage() {
    }

    @Pointcut("execution(* get*())")
    public void getter() {
    }

    @Pointcut("execution(void set*(*))")
    public void setter() {
    }

    @Pointcut("forDAOPackage() && !(setter() || getter())")
    public void forDaoNoGetterSetter() {
    }
}
