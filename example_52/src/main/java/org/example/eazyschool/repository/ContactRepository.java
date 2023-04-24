package org.example.eazyschool.repository;

import org.example.eazyschool.Model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact,Integer> {



  //below query is native sql query. for this we have to use nativeQuery=true
  //inside @Query
  //also we have to use actual column name present inside our table
  //@Query(value = "SELECT * FROM contact_msg c WHERE c.status=:status",nativeQuery = true)


  //below query is jpql
  //we have to use actual field name present inside our entity class
  //instead of column name present inside our table

  //here we can skip @Param(value="") whenever our param name in query and param name in method are same
  @Query("SELECT c FROM Contact c WHERE c.status=:status")
  List<Contact> findByStatus(@Param(value = "status") String status);

  Page<Contact> findByStatus(String status,Pageable pageable);



  //whenever we are trying to change state of a data in our table we have to mention
  //@Transactional and @Modifying annotation
  //but this is only applicable when we are trying to change state using our custom queries
  //for default method provided by jpa we don't need to handle all this
  @Transactional
  @Modifying
  @Query("UPDATE Contact c SET c.status=?1 , c.updatedBy=?2 , c.updatedAt=?3 WHERE c.contactId=?4")
  int updateMsgStatus(String status, String updatedBy, LocalDateTime updatedAt,int contactId);


  /*

  this is for testing of namedquery defined on entity class

  List<Contact> findMsgWithOpenStatus(String status);


  @Transactional
  @Modifying
  int updateMsgStatusUsingNamedQuery(String status, String updatedBy, LocalDateTime updatedAt,int contactId);

  */


  /*
  //this is for testing of namednativequery defined on entity class

  @Query(nativeQuery = true)
  List<Contact> findMsgWithOpenStatusNative(String status);

  @Query(nativeQuery = true)
  @Transactional
  @Modifying
  int updateMsgStatusNative(String status, String updatedBy, LocalDateTime updatedAt,int contactId);

  */

}