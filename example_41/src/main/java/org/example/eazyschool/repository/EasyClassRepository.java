package org.example.eazyschool.repository;

import org.example.eazyschool.Model.EasyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EasyClassRepository extends JpaRepository<EasyClass,Integer> {

}
