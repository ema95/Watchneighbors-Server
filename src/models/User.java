package models;

import java.io.Serializable;


/**
 * Class used to manipulate user objects
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1;
    private String userID;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String birthDate;
    private District district;
    private double latitude;
    private double longitude;

    public User(String userID, String name, String surname, String birthDate, District district, String email, String password, double latitude, double longitude) {
        this.userID = userID;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.district = district;
        this.email = email;
        this.password = password;
        this.latitude = latitude;
        this.longitude = longitude;

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

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDistrict(District district){ this.district = district; }


}
