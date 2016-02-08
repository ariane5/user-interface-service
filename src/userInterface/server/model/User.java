package userInterface.server.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by bishruti on 2/6/16.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class User implements Serializable {
    private int uId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String bloodGroup;
    private String address;
    private String quote;
    private ArrayList<String> goal;
    private ArrayList<String> activity;

    @XmlElementWrapper(name = "currentHealth")
    private CurrentHealth currentHealth;
    public CurrentHealth getCurrentHealth() {
        return currentHealth;
    }
    public void setCurrentHealth(CurrentHealth currentHealth) {
        this.currentHealth = currentHealth;
    }

    private FoodSuggestion foodSuggestion;
    public FoodSuggestion getFoodSuggestion() {
        return foodSuggestion;
    }

    public int getuId() {
        return uId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

/*    public Date getBirthDate(){
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//         Get the date today using Calendar object.
        return birthDate;
    }*/

/*    public void setBirthDate(Date birthDate) throws ParseException {
         DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
         Date date = format.parse(String.valueOf(birthDate));
        this.birthDate = birthDate;
    }*/

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

    public String getQuote() {
        return quote;
    }


    public ArrayList<String> getGoal() {
        return goal;
    }


    public ArrayList<String> getActivity() {
        return activity;
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
                ", quote='" + quote + '\'' +
                ", goal=" + goal +
                ", activity=" + activity +
                ", currentHealth=" + currentHealth +
                ", foodSuggestion=" + foodSuggestion +
                '}';
    }
}
