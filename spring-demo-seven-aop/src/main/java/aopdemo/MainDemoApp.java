package aopdemo;

import aopdemo.config.JavaAOPConfig;
import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaAOPConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //membershipDAO.addMember();

        accountDAO.addAccount(new Account(), true);
        accountDAO.setName("Name");
        accountDAO.getName();

        context.close();
    }
}
