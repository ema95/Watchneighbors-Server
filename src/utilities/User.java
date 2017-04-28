package utilities;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User implements Serializable {
    private static final long serialVersionUID=1;
    private String userID;
    private String name;
    private String surname;
    private String birthDate;
    private District district;

    public User(String userID, String name, String surname, String birthDate, District district) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public District getDistrict() {
        return district;
    }

public void prepareStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1,this.getUserID());
        preparedStatement.setString(2,this.getName());
        preparedStatement.setString(3,this.getSurname());
        preparedStatement.setDate(4,java.sql.Date.valueOf(this.getBirthDate()));
        preparedStatement.setString(5,this.getDistrict().getName());
    }
}
