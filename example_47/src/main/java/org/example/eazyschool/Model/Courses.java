package org.example.eazyschool.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
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
    private List<Person> personSet;


/*    @Override
    public int hashCode() {
        return Objects.hash(courseId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Courses other = (Courses) obj;
        return Objects.equals(courseId, other.courseId);
    }*/
}
