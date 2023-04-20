package org.example.eazyschool.Services;

import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Constants.Constants;
import org.example.eazyschool.Model.Contact;
import org.example.eazyschool.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
public class ContactService {
    //private Logger log= LoggerFactory.getLogger(ContactService.class);

    @Autowired
    private ContactRepository contactRepository;
    public boolean saveContactDetails(Contact contact){
        boolean isSaved=false;

        contact.setStatus(Constants.OPEN);
        contact.setCreatedBy(Constants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());

        Contact savedContact=contactRepository.save(contact);
        if(savedContact!=null && savedContact.getContactId()>0){
            isSaved=true;
        }
        return isSaved;
    }

    public List<Contact> getContactMessagesWithOpenStatus() {
       List<Contact>contactList=contactRepository.findByStatus(Constants.OPEN);
       return contactList;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){

        boolean isUpdated=false;

        Optional<Contact> contact=contactRepository.findById(contactId);

        contact.ifPresent(contact1 -> {
            contact1.setStatus(Constants.CLOSE);
            contact1.setUpdatedBy(updatedBy);
            contact1.setUpdatedAt(LocalDateTime.now());
        });

        Contact updatedContact=contactRepository.save(contact.get());
        if(updatedContact!=null && updatedContact.getUpdatedBy()!=null){
            isUpdated=true;
        }

        return isUpdated;
    }


    //this method is working fine
    //we built this method only for testing custom queries
    //it do same work as the above method work

   /* public boolean updateMsgStatus(int contactId,String updatedBy){

        boolean isUpdated=false;

        String status=Constants.CLOSE;
        LocalDateTime updatedAt=LocalDateTime.now();

        int row=contactRepository.updateMsgStatusNative(status,updatedBy,updatedAt,contactId);

        if(row>0) isUpdated=true;
        return isUpdated;


    }*/

}
