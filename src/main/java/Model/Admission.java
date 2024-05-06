package Model;
import java.io.Serializable;

import jakarta.persistence.*;

@Entity
public class Admission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stud_id;
    private String fullname;
    private String email;
    private String gender;
    private String bd;
    private String course;
    private String status;
    @Lob
    private byte[] passportPicture;
    @Lob
    private byte[] admissionDocument;

    public Admission() {
    }

    public Admission(Integer stud_id) {
        this.stud_id = stud_id;
    }

    public Admission(Integer stud_id, String fullname, String email, String gender, String bd, String course, String status, byte[] passportPicture, byte[] admissionDocument) {
        this.stud_id = stud_id;
        this.fullname = fullname;
        this.email = email;
        this.gender = gender;
        this.bd = bd;
        this.course = course;
        this.status = status;
        this.passportPicture = passportPicture;
        this.admissionDocument = admissionDocument;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public byte[] getPassportPicture() {
        return passportPicture;
    }

    public void setPassportPicture(byte[] passportPicture) {
        this.passportPicture = passportPicture;
    }

    public byte[] getAdmissionDocument() {
        return admissionDocument;
    }

    public void setAdmissionDocument(byte[] admissionDocument) {
        this.admissionDocument = admissionDocument;
    }
}