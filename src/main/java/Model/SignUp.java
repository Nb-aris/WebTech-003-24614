package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
@Entity
public class SignUp implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stud_id;
    private String fullname;
    private String email;
    private String password;
    private String type_of_user;

    public SignUp() {

    }

    public SignUp(Integer stud_id) {
        this.stud_id = stud_id;
    }

    public SignUp(Integer stud_id, String fullname, String email, String password, String type_of_user) {
        this.stud_id = stud_id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.type_of_user = type_of_user;
    }

    public Integer getStud_id() {
        return stud_id;
    }

    public void setStud_id(Integer stud_id) {
        this.stud_id = stud_id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType_of_user() {
        return type_of_user;
    }

    public void setType_of_user(String type_of_user) {
        this.type_of_user = type_of_user;
    }
}
