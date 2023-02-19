package aopdemo.dao;

import aopdemo.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String name;

    public Account addAccount(Account account, boolean bool) {
        System.out.println(getClass().getSimpleName() + ": ADDING ACCOUNT");
        return account;
    }

    public String getName() {
        System.out.println(getClass().getSimpleName() + ": GET NAME METHOD");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass().getSimpleName() + ": SET NAME METHOD");
        this.name = name;
    }
}
