package org.example.eazyschool.repository;

import org.example.eazyschool.Model.Contact;
import org.example.eazyschool.RowMapper.ContactRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    public int saveContactMsg(Contact contact){
        String sql="INSERT INTO CONTACT_MSG (name,mobileNum,email,subject,message,status,"+
                "createdAt,createdBy)"+"values(?,?,?,?,?,?,?,?);";
        return this.jdbcTemplate.update(sql,contact.getName(),contact.getMobileNum(),contact.getEmail(),
                                            contact.getSubject(),contact.getMessage(),contact.getStatus(),
                                            contact.getCreatedAt(),contact.getCreatedBy());
    }

    public List<Contact> getContactMessagesWithStatus(String status) {
        String getMessagesQuery="SELECT * FROM CONTACT_MSG WHERE status=?;";
        return jdbcTemplate.query(getMessagesQuery, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,status);
            }
        },new ContactRowMapper());
    }

    public int updateMsgStatus(int contactId, String status, String updatedBy) {
        String sqlQuery="UPDATE CONTACT_MSG SET STATUS=? , updatedBy=? ,  updatedAt=?  WHERE CONTACTID=?;";

       return jdbcTemplate.update(sqlQuery, new PreparedStatementSetter(){

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,status);
                ps.setString(2,updatedBy);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4,contactId);
            }
        });

    }
}