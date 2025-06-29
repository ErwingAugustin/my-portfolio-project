package Contact;

//Contact.java
import java.util.Objects;

public class Contact {
 private final String contactId;
 private String firstName;
 private String lastName;
 private String phone;
 private String address;

 public Contact(String contactId, String firstName, String lastName, String phone, String address) {
     // Validate contactId
     if (contactId == null || contactId.length() > 10) {
         throw new IllegalArgumentException("Contact ID cannot be null and must be 10 characters or less.");
     }
     this.contactId = contactId;

     // Validate firstName
     if (firstName == null || firstName.length() > 10) {
         throw new IllegalArgumentException("First name cannot be null and must be 10 characters or less.");
     }
     this.firstName = firstName;

     // Validate lastName
     if (lastName == null || lastName.length() > 10) {
         throw new IllegalArgumentException("Last name cannot be null and must be 10 characters or less.");
     }
     this.lastName = lastName;

     // Validate phone
     if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
         throw new IllegalArgumentException("Phone number cannot be null and must be exactly 10 digits.");
     }
     this.phone = phone;

     // Validate address
     if (address == null || address.length() > 30) {
         throw new IllegalArgumentException("Address cannot be null and must be 30 characters or less.");
     }
     this.address = address;
 }

 // Getters
 public String getContactId() {
     return contactId;
 }

 public String getFirstName() {
     return firstName;
 }

 public String getLastName() {
     return lastName;
 }

 public String getPhone() {
     return phone;
 }

 public String getAddress() {
     return address;
 }

 // Setters (for updatable fields) with validation
 public void setFirstName(String firstName) {
     if (firstName == null || firstName.length() > 10) {
         throw new IllegalArgumentException("First name cannot be null and must be 10 characters or less.");
     }
     this.firstName = firstName;
 }

 public void setLastName(String lastName) {
     if (lastName == null || lastName.length() > 10) {
         throw new IllegalArgumentException("Last name cannot be null and must be 10 characters or less.");
     }
     this.lastName = lastName;
 }

 public void setPhone(String phone) {
     if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
         throw new IllegalArgumentException("Phone number cannot be null and must be exactly 10 digits.");
     }
     this.phone = phone;
 }

 public void setAddress(String address) {
     if (address == null || address.length() > 30) {
         throw new IllegalArgumentException("Address cannot be null and must be 30 characters or less.");
     }
     this.address = address;
 }

 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (o == null || getClass() != o.getClass()) return false;
     Contact contact = (Contact) o;
     return Objects.equals(contactId, contact.contactId);
 }

 @Override
 public int hashCode() {
     return Objects.hash(contactId);
 }
}