package org.example.eazyschool.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
@Entity
@Table(name="contact_msg")
public class Contact extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="contactid")
    private int contactId;
    @NotBlank(message = "Name must not be blank")
    @Size(min=3,message = "name should be of 3 character")
    private String name;

    @NotBlank(message = "mobile number should not be blank")
    @Pattern(regexp = "[6789][0-9]{9}",message = "mobile number should be of 10 digit length")
    private String mobileNum;

    @NotBlank(message = "email should not be blank")
    @Email
    private String email;

    @NotBlank(message = "subject should not be blank")
    @Size(min=3,message = "subject name should be of minimum 3 character")
    private String subject;

    @NotBlank(message = "message should not be blank")
    @Size(min=5,message = "message size should be of minimum 5 character")
    private String message;
    private String status;



    /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public void setMobileNum(String mobileNum) {
        this.mobileNum = mobileNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", mobileNum='" + mobileNum + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }*/
}
