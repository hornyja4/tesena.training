package tesena.automation.training.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private String loginNumber;
    private String password;
    private String name;

    public String getLoginNumber() {
        return loginNumber;
    }

    @XmlElement
    public void setLoginNumber(String loginNumber) {
        this.loginNumber = loginNumber;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }
}
