package userInterface.server.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by bishruti on 2/7/16.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class UserProcess implements Serializable {

    private int uId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String bloodGroup;
    private String address;

    @XmlElementWrapper(name = "currentHealth")
    private CurrentHealth currentHealth;
    public CurrentHealth getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(CurrentHealth currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId=" + uId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", address='" + address + '\'' +
                ", currentHealth=" + currentHealth +
                '}';
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
