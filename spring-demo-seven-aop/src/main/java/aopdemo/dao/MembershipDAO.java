package aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public String addMember(){
        System.out.println(getClass().getSimpleName() + ": ADDING MEMBERSHIP ACCOUNT");
        return null;
    }
}
