package tesena.automation.training.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class AccountMap {
    private Map<String, Account> accountMap = new HashMap<>();

    @XmlElement
    public void setAccount(Account account) {
        accountMap.put(account.getId(), account);
    }

    public Account getAccount(String accountId) {
        Account account = accountMap.get(accountId);
        if (account == null) {
            throw new RuntimeException("IAccount with id: " + accountId + " does not exist. Possible accounts to choose are [" + Arrays.toString(accountMap.keySet().toArray()) + "]");
        }
        return account;
    }
}
