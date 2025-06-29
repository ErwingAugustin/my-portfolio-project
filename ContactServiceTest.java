package Contact;

//ContactServiceTest.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

 private ContactService contactService;

 @BeforeEach
 void setup() {
     contactService = new ContactService();
 }

 // Test adding a contact successfully
 @Test
 void testAddContact() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     Assertions.assertNotNull(contactService.getContact("ID001"));
     Assertions.assertEquals("Alice", contactService.getContact("ID001").getFirstName());
 }

 // Test adding a contact with a duplicate ID
 @Test
 void testAddDuplicateContactId() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         Contact contact2 = new Contact("ID001", "Bob", "Johnson", "4445556666", "200 Oak Ave");
         contactService.addContact(contact2);
     });
 }

 // Test adding a null contact
 @Test
 void testAddNullContact() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         contactService.addContact(null);
     });
 }

 // Test deleting an existing contact
 @Test
 void testDeleteContact() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     Assertions.assertNotNull(contactService.getContact("ID001"));

     contactService.deleteContact("ID001");
     Assertions.assertNull(contactService.getContact("ID001"));
 }

 // Test deleting a non-existent contact
 @Test
 void testDeleteNonExistentContact() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         contactService.deleteContact("NonExistentID");
     });
 }

 // Test deleting with a null contact ID
 @Test
 void testDeleteNullContactId() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         contactService.deleteContact(null);
     });
 }

 // Test updating first name
 @Test
 void testUpdateFirstName() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     contactService.updateContact("ID001", "Alicia", null, null, null);
     Assertions.assertEquals("Alicia", contactService.getContact("ID001").getFirstName());
     Assertions.assertEquals("Smith", contactService.getContact("ID001").getLastName()); // Ensure others are unchanged
 }

 // Test updating last name
 @Test
 void testUpdateLastName() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     contactService.updateContact("ID001", null, "Jones", null, null);
     Assertions.assertEquals("Jones", contactService.getContact("ID001").getLastName());
 }

 // Test updating phone number
 @Test
 void testUpdatePhone() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     contactService.updateContact("ID001", null, null, "9998887777", null);
     Assertions.assertEquals("9998887777", contactService.getContact("ID001").getPhone());
 }

 // Test updating address
 @Test
 void testUpdateAddress() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     contactService.updateContact("ID001", null, null, null, "300 Elm St");
     Assertions.assertEquals("300 Elm St", contactService.getContact("ID001").getAddress());
 }

 // Test updating multiple fields
 @Test
 void testUpdateMultipleFields() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     contactService.updateContact("ID001", "Robert", "Brown", "5551234567", "500 Maple Dr");
     Assertions.assertEquals("Robert", contactService.getContact("ID001").getFirstName());
     Assertions.assertEquals("Brown", contactService.getContact("ID001").getLastName());
     Assertions.assertEquals("5551234567", contactService.getContact("ID001").getPhone());
     Assertions.assertEquals("500 Maple Dr", contactService.getContact("ID001").getAddress());
 }

 // Test updating a non-existent contact
 @Test
 void testUpdateNonExistentContact() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         contactService.updateContact("NonExistentID", "NewName", null, null, null);
     });
 }

 // Test updating with null contact ID
 @Test
 void testUpdateNullContactId() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         contactService.updateContact(null, "NewName", null, null, null);
     });
 }

 // Test attempting to update contact ID (should not be possible)
 @Test
 void testUpdateContactIdNotAllowed() {
     Contact contact1 = new Contact("ID001", "Alice", "Smith", "1112223333", "100 Pine Ln");
     contactService.addContact(contact1);
     // There is no method in ContactService to update contactId, which correctly reflects the requirement.
     // This test implicitly passes if no such method exists, demonstrating the requirement is met by design.
     // If a contactId parameter was part of updateContact and was mistakenly updated, it would be a failure.
     // We'll verify the contact ID remains the same after other updates.
     contactService.updateContact("ID001", "UpdatedName", null, null, null);
     Assertions.assertEquals("ID001", contactService.getContact("ID001").getContactId());
 }
}
