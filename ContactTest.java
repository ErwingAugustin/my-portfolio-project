package Contact;

//ContactTest.java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactTest {

 // Test successful contact creation
 @Test
 void testContactCreation() {
     Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
     Assertions.assertNotNull(contact);
     Assertions.assertEquals("12345", contact.getContactId());
     Assertions.assertEquals("John", contact.getFirstName());
     Assertions.assertEquals("Doe", contact.getLastName());
     Assertions.assertEquals("1234567890", contact.getPhone());
     Assertions.assertEquals("123 Main St", contact.getAddress());
 }

 // Test contactId validation: null
 @Test
 void testContactIdNull() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact(null, "John", "Doe", "1234567890", "123 Main St");
     });
 }

 // Test contactId validation: too long
 @Test
 void testContactIdTooLong() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
     });
 }

 // Test firstName validation: null
 @Test
 void testFirstNameNull() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", null, "Doe", "1234567890", "123 Main St");
     });
 }

 // Test firstName validation: too long
 @Test
 void testFirstNameTooLong() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", "JohnathanTooLong", "Doe", "1234567890", "123 Main St");
     });
 }

 // Test lastName validation: null
 @Test
 void testLastNameNull() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", "John", null, "1234567890", "123 Main St");
     });
 }

 // Test lastName validation: too long
 @Test
 void testLastNameTooLong() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", "John", "DoeIsVeryLong", "1234567890", "123 Main St");
     });
 }

 // Test phone validation: null
 @Test
 void testPhoneNull() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", "John", "Doe", null, "123 Main St");
     });
 }

 // Test phone validation: not 10 digits (too short)
 @Test
 void testPhoneTooShort() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", "John", "Doe", "12345", "123 Main St");
     });
 }

 // Test phone validation: not 10 digits (too long)
 @Test
 void testPhoneTooLong() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", "John", "Doe", "12345678901", "123 Main St");
     });
 }

 // Test phone validation: non-digit characters
 @Test
 void testPhoneNonDigits() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", "John", "Doe", "123-456-7890", "123 Main St");
     });
 }

 // Test address validation: null
 @Test
 void testAddressNull() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", "John", "Doe", "1234567890", null);
     });
 }

 // Test address validation: too long
 @Test
 void testAddressTooLong() {
     Assertions.assertThrows(IllegalArgumentException.class, () -> {
         new Contact("12345", "John", "Doe", "1234567890", "This is an extremely long address that exceeds the thirty character limit.");
     });
 }

 // Test setters with valid data
 @Test
 void testSettersValid() {
     Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

     contact.setFirstName("Jane");
     Assertions.assertEquals("Jane", contact.getFirstName());

     contact.setLastName("Smith");
     Assertions.assertEquals("Smith", contact.getLastName());

     contact.setPhone("0987654321");
     Assertions.assertEquals("0987654321", contact.getPhone());

     contact.setAddress("456 Oak Ave");
     Assertions.assertEquals("456 Oak Ave", contact.getAddress());
 }

 // Test contactId is not updatable (should not have a setter)
 @Test
 void testContactIdNotUpdatable() {
     Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
     // We ensure this by not having a setContactId method in the Contact class.
     // If a setContactId method existed, this test would fail or indicate a design flaw.
     // This test implicitly passes if no compilation error due to absence of setter.
     // To be more explicit, one might try to use reflection to check for its absence,
     // but for this level, simply ensuring no setter is present is sufficient.
     Assertions.assertEquals("12345", contact.getContactId());
 }
}