package models;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User implements Serializable {
    private static final long serialVersionUID=1;
    private String userID;
    private String name;
    private String surname;
    private String email;
    private String birthDate;
    private District district;

    public User(String userID, String name, String surname, String birthDate, District district, String email) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.district = district;
        this.email = email;
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

    public String getBirthDate() {
        return birthDate;
    }

    public District getDistrict() {
        return district;
    }

    public String getEmail() { return email; }

}
