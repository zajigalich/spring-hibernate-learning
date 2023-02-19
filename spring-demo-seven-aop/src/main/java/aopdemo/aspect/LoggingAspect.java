package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //@Before("execution(void addAccount())")
    //    @Before("execution(void aopdemo.dao.AccountDAO.addAccount())")

    //@Pointcut("execution(aopdemo.entity.* aopdemo.dao.*.*(aopdemo.entity.*, boolean, ..))")

    @Pointcut("execution(* aopdemo.dao.*.*(..))")
    private void forDAOPackage(){}

    @Pointcut("execution(* get*())")
    private void getter(){}

    @Pointcut("execution(void set*(*))")
    private void setter(){}

    @Pointcut("forDAOPackage() && !(setter() || getter())")
    private void forDaoNoGetterSetter(){}

    @Before("forDaoNoGetterSetter()") //wildcard
    public void beforeForDaoNoSetterGetterAdvice() {
        System.out.println(getClass().getSimpleName() + ": @Before advice on method");
    }

    /*@Before("forDAOPackage()") //wildcard
    public void beforeAddAccountApiAnalyticsAdvice() {
        System.out.println(getClass().getSimpleName() + ": @Before advice on method");
    }*/

}
