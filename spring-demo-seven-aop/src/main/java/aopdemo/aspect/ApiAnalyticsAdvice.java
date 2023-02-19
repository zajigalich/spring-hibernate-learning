package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class ApiAnalyticsAdvice {

    @Before("aopdemo.aspect.AopExpressions.forDaoNoGetterSetter()")
    public void beforeAddAccountApiAnalyticsAdvice() {
        System.out.println(getClass().getSimpleName() + ": PERFORMING ANALYTICS (@Before advice)");
    }

}
