package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //@Before("execution(void addAccount())")
    //    @Before("execution(void aopdemo.dao.AccountDAO.addAccount())")


    @Before("execution(* add*())") //wildcard
    public void beforeAddAccountAdvice() {
        System.out.println(getClass().getSimpleName() + ": @Before advice on add*()");
    }
}
