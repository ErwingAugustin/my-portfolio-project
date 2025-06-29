package Contact;

//ContactService.java
import java.util.HashMap;
import java.util.Map;

public class ContactService {
 private final Map<String, Contact> contactList;

 public ContactService() {
     this.contactList = new HashMap<>();
 }

 // Add a new contact
 public void addContact(Contact contact) {
     if (contact == null) {
         throw new IllegalArgumentException("Contact cannot be null.");
     }
     if (contactList.containsKey(contact.getContactId())) {
         throw new IllegalArgumentException("Contact with this ID already exists.");
     }
     contactList.put(contact.getContactId(), contact);
 }

 // Delete a contact by contact ID
 public void deleteContact(String contactId) {
     if (contactId == null || !contactList.containsKey(contactId)) {
         throw new IllegalArgumentException("Contact ID cannot be null and must exist to be deleted.");
     }
     contactList.remove(contactId);
 }

 // Update contact fields by contact ID
 public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
     if (contactId == null || !contactList.containsKey(contactId)) {
         throw new IllegalArgumentException("Contact ID cannot be null and must exist to be updated.");
     }

     Contact contact = contactList.get(contactId);

     // Only update if the new value is not null, allowing partial updates
     if (firstName != null) {
         contact.setFirstName(firstName);
     }
     if (lastName != null) {
         contact.setLastName(lastName);
     }
     if (phone != null) {
         contact.setPhone(phone);
     }
     if (address != null) {
         contact.setAddress(address);
     }
 }

 // Get a contact by ID (for testing/verification purposes)
 public Contact getContact(String contactId) {
     return contactList.get(contactId);
 }
}