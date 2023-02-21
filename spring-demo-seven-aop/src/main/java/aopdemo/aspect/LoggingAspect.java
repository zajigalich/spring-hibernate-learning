package aopdemo.aspect;

import aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @AfterThrowing(pointcut = "execution(* aopdemo.dao.AccountDAO.getAccounts(..))",
            throwing = "exception")
    public void afterTrowingGetAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println(getClass().getSimpleName() + ": PERFORMING LOGGING (@AfterThrowing advice)");
        System.out.println(joinPoint.getSignature());
        System.out.println(exception);
    }

    @After("execution(* aopdemo.dao.AccountDAO.getAccounts(..))")
    public void afterGetAccountsAdvice(JoinPoint joinPoint) {
        System.out.println(getClass().getSimpleName() + ": PERFORMING LOGGING (@After advice)");
        System.out.println(joinPoint.getSignature());
    }

    @Around("execution(String aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println(getClass().getSimpleName() + ": PERFORMING LOGGING (@Around advice)");
        System.out.println(joinPoint.getSignature());

        long start = System.currentTimeMillis();

        Object result = null;
        try {

            result = joinPoint.proceed();

        } catch (RuntimeException exception) {

            System.out.println(exception + ": @Around advice - we have a problem");
            //result = "Handled an exception";

            throw exception;
        }

        long end = System.currentTimeMillis();

        System.out.println("Time spent -> " + (end - start) + "ms");

        return result;
    }


    /*@AfterReturning(value = "execution(String aopdemo.service.TrafficFortuneService.getFortune())", returning = "res")
    public void afterReturningGetFortuneAdvice(JoinPoint joinPoint, StringBuilder res) {
        System.out.println(getClass().getSimpleName() + ": PERFORMING LOGGING (@AfterReturning advice)");
        System.out.println(joinPoint.getSignature());
        res.reverse();
    }*/

    private void convertAccountsNameToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

}
