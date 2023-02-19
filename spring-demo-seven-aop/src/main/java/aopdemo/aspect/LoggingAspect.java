package aopdemo.aspect;

import aopdemo.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

    //@Before("execution(void aopdemo.dao.AccountDAO.addAccount())")

    @Before("aopdemo.aspect.AopExpressions.forDaoNoGetterSetter()") //wildcard
    public void beforeForDaoNoSetterGetterAdvice(JoinPoint joinPoint) {
        System.out.println(getClass().getSimpleName() + ": PERFORMING LOGGING (@Before advice)");

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("methodSignature = " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for (Object tempArg: args){

            if (tempArg instanceof Account){
                ((Account) tempArg).setLevel("FINE");
            }

            System.out.println(tempArg);
        }
    }

}
