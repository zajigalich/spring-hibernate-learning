package aopdemo.aspect;

import aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    //@Before("execution(void aopdemo.dao.AccountDAO.addAccount())")

    @Before("aopdemo.aspect.AopExpressions.forDaoNoGetterSetter()") //wildcard
    public void beforeForDaoNoSetterGetterAdvice(JoinPoint joinPoint) {

        System.out.println(getClass().getSimpleName() + ": PERFORMING LOGGING (@Before advice)");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature(); //joinPoint.getSignature()
        System.out.println("methodSignature = " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg : args) {
            if (tempArg instanceof Account) {
                ((Account) tempArg).setLevel("FINE");
            }
            System.out.println(tempArg);
        }
    }

    @AfterReturning(
            pointcut = "execution(* aopdemo.dao.AccountDAO.getAccounts(..))",
            returning = "result")
    public void afterReturningGetAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println(getClass().getSimpleName() + ": PERFORMING LOGGING (@AfterReturning advice)");
        System.out.println("method: " + joinPoint.getSignature().toShortString());

        if (result != null) {
            convertAccountsNameToUpperCase(result);
        }
        System.out.println(result);
    }

    private void convertAccountsNameToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

}
