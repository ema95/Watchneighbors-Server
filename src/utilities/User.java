package utilities;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID=1;
    private String userID;
    private String name;
    private String surname;
    private Date birthDate;
    private District district;

    public User(String userID, String name, String surname, Date birthDate, District district) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.district = district;
    }

    public String getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public District getDistrict() {
        return district;
    }
}
