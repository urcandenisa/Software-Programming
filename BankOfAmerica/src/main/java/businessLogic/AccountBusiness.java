package businessLogic;

import dataAccess.AccountDataAccess;
import model.Account;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AccountBusiness {

    private AccountDataAccess accountDataAccess;

    public AccountBusiness(){
        accountDataAccess = new AccountDataAccess();
    }

    public List<Account> selectAll(){
        List<Account> accounts = accountDataAccess.selectAll();
        if(accounts == null) return null;
        return accounts;
    }

    public void addAccount(Account account){
        accountDataAccess.addAccount(account);
    }

    public void updateAccount(Account account){
        accountDataAccess.updateAccount(account);
    }

    public List<Account> searchAfter(String field, String personalNumericalCode){
        List<Account> list = accountDataAccess.searchAfter(field, personalNumericalCode);
        if(list == null) return null;
        return list;
    }

    public void delete(Account account){
        accountDataAccess.deleteAfter("identificationNumber", account.getIdentificationNumber());
    }

    public static void main(String[] args) throws ParseException {
        AccountBusiness accountBusiness = new AccountBusiness();
        SimpleDateFormat dtf = new SimpleDateFormat("MM-dd-yyyy", Locale.ENGLISH);
        Date now = new Date();
        String string = dtf.format(now);
        Account account = new Account("22", "23", "1", 1, dtf.format(now));
        accountBusiness.addAccount(account);
    }
}
