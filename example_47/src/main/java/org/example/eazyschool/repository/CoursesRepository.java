package org.example.eazyschool.repository;


import org.example.eazyschool.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path="courses")
public interface CoursesRepository extends JpaRepository<Courses,Integer> {
}
