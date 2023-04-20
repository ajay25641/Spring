package org.example.eazyschool.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Profile {


    @NotBlank(message = "name must not be blank")
    @Size(min=3,message = "name must be atleast 3 character long")
    private String name;

    @NotBlank(message = "email must not be blank")
    @Email(message = "please provide a valid email address")
    private String email;

    @NotBlank(message = "mobile number must not be blank")
    @Pattern(regexp = "[6789][0-9]{9}",message = "please enter valid mobile number")
    private String mobileNum;

    @NotBlank(message = "address1 must not be blank")
    @Size(min=3,message = "address1 must be atleast 3 character long")
    private String address1;


    private String address2;
    @NotBlank(message = "city must not be blank")
    @Size(min=3,message = "city must be atleast 3 character long")
    private String city;

    @NotBlank(message = "state must not be blank")
    @Size(min=3,message = "state must be atleast 3 character long")
    private String state;

    @NotBlank(message = "zip code must not be blank")
    @Size(min=3,message = "zip code must be atleast 3 character long")
    private String zipCode;

}
