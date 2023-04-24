package org.example.eazyschool.Services;

import org.example.eazyschool.Constants.Constants;
import org.example.eazyschool.Model.Person;
import org.example.eazyschool.Model.Roles;
import org.example.eazyschool.repository.PersonRepository;
import org.example.eazyschool.repository.RolesRepository;
import org.example.eazyschool.security.MyPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    private MyPasswordEncoder myPasswordEncoder;
    public boolean createNewUser(Person person) {
        Roles role=rolesRepository.getByRoleName(Constants.STUDENT_ROLE);
        person.setRoles(role);

        person.setPassword(myPasswordEncoder.generatePassword(person.getPassword()));

        person=personRepository.save(person);
        boolean isSaved=false;
        if(person !=null && person.getPersonId()>0){
            isSaved=true;
        }
        return isSaved;
    }
}
