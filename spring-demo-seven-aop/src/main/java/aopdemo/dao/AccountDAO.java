package aopdemo.dao;

import aopdemo.entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;

    private List<Account> accounts;

    public AccountDAO() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println(getClass().getSimpleName() + ": ADDING ACCOUNT");
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts(boolean tripWire) {
        if (tripWire) throw new RuntimeException("No soup for you");
        return accounts;
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
