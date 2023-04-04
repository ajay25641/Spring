package org.example.eazyschool.Services;

import lombok.extern.slf4j.Slf4j;
import org.example.eazyschool.Constants.Constants;
import org.example.eazyschool.Model.Contact;
import org.example.eazyschool.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

        int result=contactRepository.saveContactMsg(contact);
        if(result>0){
            isSaved=true;
        }
        return isSaved;
    }

    public List<Contact> getContactMessagesWithOpenStatus() {
        List<Contact>contactMsgs=contactRepository.getContactMessagesWithStatus(Constants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy) {
        boolean isUpdated=false;
        int result=contactRepository.updateMsgStatus(contactId,Constants.CLOSE,updatedBy);
        if(result>0){
            isUpdated=true;
        }
        return isUpdated;
    }
}
