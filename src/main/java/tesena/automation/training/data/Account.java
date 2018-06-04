package tesena.automation.training.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account implements IAccount {
    private String id;
    private String accountName;
    private String accountNickName;
    private String accountNumber;
    private String bankCode;
    private String currency;

    public String getAccountName() {
        return accountName;
    }

    @XmlElement
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @XmlElement
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankCode() {
        return bankCode;
    }

    @XmlElement
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getId() {
        return id;
    }

    @XmlAttribute(required = true)
    public void setId(String id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlElement
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountNickName() {
        return accountNickName;
    }

    @XmlElement
    public void setAccountNickName(String accountNickName) {
        this.accountNickName = accountNickName;
    }

    @Override
    public String toString() {
        return "IAccount{" +
                "id='" + id + '\'' +
                ", accountName='" + accountName + '\'' +
                ", accountNickName='" + accountNickName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", bankCode='" + bankCode + '\'' +
                ", currency='" + currency + '\'' +
                '}';
    }

    public String accountNumberWithBankCode(){
        return accountNumber + "/" + bankCode;
    }
}
