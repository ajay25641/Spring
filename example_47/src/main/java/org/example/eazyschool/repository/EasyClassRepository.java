package org.example.eazyschool.repository;

import org.example.eazyschool.Model.EasyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface EasyClassRepository extends JpaRepository<EasyClass,Integer> {

}
