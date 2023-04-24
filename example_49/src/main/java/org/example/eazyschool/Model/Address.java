package org.example.eazyschool.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Address extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @NotBlank(message = "address1 must not be blank")
    @Size(min=3,message = "address must be at least 3 character long")
    private String address1;
    private String address2;
    @NotBlank(message = "city must not be blank")
    @Size(min=3,message = "city name be atleast 3 character long")
    private String city;
    @NotBlank(message = "state name must not be blank")
    @Size(min=3,message = "state name must be atleast 3 character long")
    private String state;

    @NotBlank(message = "zip code must not be blank")
    private String zipCode;

}
