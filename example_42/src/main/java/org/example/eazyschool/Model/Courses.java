package org.example.eazyschool.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
public class Courses extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    private String name;

    private String fees;


    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Person>personSet=new HashSet<>();


}
