package aopdemo;

import aopdemo.config.JavaAOPConfig;
import aopdemo.dao.AccountDAO;
import aopdemo.entity.Account;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaAOPConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        //MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        //membershipDAO.addMember();

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("name", "finest"));
        accounts.add(new Account("na", "na"));

        accountDAO.setAccounts(accounts);

        accountDAO.addAccount(new Account("la", "la"));
        accountDAO.setName("Name");
        accountDAO.getName();

        List<Account> accounts1 = null;
        try {
            boolean tripWire = true;
            accounts1 = accountDAO.getAccounts(tripWire);

        } catch (Exception e){
            System.out.println("Main app: caught exception -> " + e);
            e.printStackTrace();
        }
        System.out.println("accounts1 = " + accounts1);

        context.close();
    }
}
