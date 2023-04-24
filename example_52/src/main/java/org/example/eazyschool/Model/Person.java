package org.example.eazyschool.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.example.eazyschool.annotations.FieldsValueMatch;
import org.example.eazyschool.annotations.PasswordValidator;
import org.hibernate.validator.constraints.ParameterScriptAssert;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;


@Getter
@Setter
@Entity
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "confirmPassword",
                message = "Password do not match !"
        ),
        @FieldsValueMatch(
                field = "email",
                fieldMatch = "confirmEmail",
                message="Email do not match"
        )
})
public class Person extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;
    @NotBlank(message = "name should not be blank")
    @Size(min=3,message = "name should be at least 3 character long")
    private String name;
    @Email
    @NotBlank(message = "email id should not be blank")
    @Column(unique = true)
    private String email;
    @Email
    @Transient
    @NotBlank(message = "confirm email id shoudl not be blank")
    @JsonIgnore
    private String confirmEmail;
    @NotBlank(message = "password should not be blank")
    @Size(message = "password should be at least 5 character long")
    @PasswordValidator
    @JsonIgnore
    private String password;

    @Transient
    @NotBlank(message = "confirm password should not be blank")
    @Size(message = "confirm password should be at least 5 character long")
    @JsonIgnore
    private String confirmPassword;

    @NotBlank(message = "mobile number should not be blank")
    @Pattern(regexp = "[6789][0-9]{9}",message = "mobile number should be of 10 digit long")
    private String mobileNum;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL,targetEntity = Address.class)
    @JoinColumn(name="address_id",referencedColumnName = "addressId",nullable = true)
    private Address address;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST,targetEntity = Roles.class)
    @JoinColumn(name="role_id",referencedColumnName = "roleId",nullable = false)
    private Roles roles;


    @ManyToOne(fetch = FetchType.LAZY,targetEntity = EasyClass.class,optional = true)
    @JoinColumn(name="class_id",referencedColumnName = "classId",nullable = true)
    private EasyClass easyClass;



    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinTable(name="person_courses",
               joinColumns = @JoinColumn(name="person_id",referencedColumnName = "personId"),
               inverseJoinColumns = @JoinColumn(name="course_id",referencedColumnName = "courseId"))
    private List<Courses> courses;

//    @Override
//    public int hashCode() {
//        return Objects.hash(personId);
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj)
//            return true;
//        if (obj == null || getClass() != obj.getClass())
//            return false;
//        Person other = (Person) obj;
//        return Objects.equals(personId, other.personId);
//    }




}
