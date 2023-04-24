package org.example.eazyschool.security;

import org.example.eazyschool.Model.Person;
import org.example.eazyschool.Model.Roles;
import org.example.eazyschool.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MyPasswordEncoder myPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email=authentication.getName();
        String password=authentication.getCredentials().toString();

        Person person=personRepository.getByEmail(email);

        if(person != null && person.getPersonId()>0 && myPasswordEncoder.verifyPassword(password,person.getPassword()) ){
            return new UsernamePasswordAuthenticationToken(person.getEmail(),
                                                           null,
                                                           getGrantedAuthorities(person.getRoles()));
        }
        else{
             throw new BadCredentialsException("Invalic Credentials");
        }

    }

    private List<GrantedAuthority> getGrantedAuthorities(Roles roles) {

        List<GrantedAuthority> grantedAuthorityList=new ArrayList<>();

        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_"+roles.getRoleName()));

        return grantedAuthorityList;

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
