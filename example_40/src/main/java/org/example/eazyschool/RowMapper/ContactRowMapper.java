package org.example.eazyschool.RowMapper;

import org.example.eazyschool.Model.Contact;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactRowMapper implements RowMapper<Contact> {


    @Override
    public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
        Contact contact=new Contact();
        contact.setName(rs.getString("name"));
        contact.setContactId(rs.getInt("contactId"));
        contact.setEmail(rs.getString("email"));
        contact.setMessage(rs.getString("message"));
        contact.setSubject(rs.getString("subject"));
        contact.setMobileNum(rs.getString("mobileNum"));
        contact.setCreatedAt(rs.getTimestamp("createdAt").toLocalDateTime());
        contact.setCreatedBy(rs.getString("createdBy"));
        contact.setStatus(rs.getString("status"));

        if(rs.getTimestamp("updatedAt") !=null){
            contact.setUpdatedAt(rs.getTimestamp("updatedAt").toLocalDateTime());

        }
        contact.setUpdatedBy(rs.getString("updatedBy"));
        return contact;
    }
}
