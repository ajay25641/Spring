package org.example.eazyschool.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="Class")
public class EasyClass extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int classId;

    @NotBlank(message = "class name must not be empty")
    @Size(min=3,message="class name must be atleast 3 character long")
    private String name;

    @OneToMany(mappedBy = "easyClass",fetch = FetchType.LAZY,cascade = CascadeType.PERSIST,targetEntity = Person.class)
    private Set<Person> persons;
}