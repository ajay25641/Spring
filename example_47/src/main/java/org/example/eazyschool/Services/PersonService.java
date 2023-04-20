package org.example.eazyschool.Services;

import org.example.eazyschool.Constants.Constants;
import org.example.eazyschool.Model.Person;
import org.example.eazyschool.Model.Roles;
import org.example.eazyschool.repository.PersonRepository;
import org.example.eazyschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    RolesRepository rolesRepository;
    public boolean createNewUser(Person person) {
        Roles role=rolesRepository.getByRoleName(Constants.STUDENT_ROLE);
        person.setRoles(role);
        //person.setCreatedAt(LocalDateTime.now());
        //person.set
        person=personRepository.save(person);
        boolean isSaved=false;
        if(person !=null && person.getPersonId()>0){
            isSaved=true;
        }
        return isSaved;
    }
}
