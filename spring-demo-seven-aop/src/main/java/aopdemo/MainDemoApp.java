package aopdemo;

import aopdemo.config.JavaAOPConfig;
import aopdemo.dao.AccountDAO;
import aopdemo.dao.MembershipDAO;
import aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaAOPConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        //membershipDAO.addMember();

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("name", "finest"));
        accounts.add(new Account("na", "na"));

        accountDAO.setAccounts(accounts);

        accountDAO.addAccount(new Account("la", "la"));
        accountDAO.setName("Name");
        accountDAO.getName();

        accountDAO.getAccounts();

        context.close();
    }
}
