package org.example.eazyschool.repository;

import org.example.eazyschool.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public int saveContactMsg(Contact contact){
        String sql="INSERT INTO CONTACT_MSG (name,mobile_num,email,subject,message,status,"+
                "createdAt,createdBy)"+"values(?,?,?,?,?,?,?,?);";
        return this.jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),contact.getEmail(),
                                            contact.getSubject(),contact.getMessage(),contact.getStatus(),
                                            contact.getCreatedAt(),contact.getCreatedBy());
    }

    public List<Contact> getContactMessagesWithStatus(String status) {
        String getMessagesQuery="SELECT * FROM CONTACT_MSG WHERE status=?;";
        List<Contact>contactMsgs=this.jdbcTemplate.queryForList(getMessagesQuery,Contact.class,status);
        return contactMsgs;
    }
}