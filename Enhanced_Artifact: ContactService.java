package Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contactList;

    public ContactService() {
        this.contactList = new HashMap<>();
    }

    public void addContact(Contact contact) {
        if (contact == null || contactList.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Invalid Contact or Duplicate ID.");
        }
        contactList.put(contact.getContactId(), contact);
    }

    /**
     * ENHANCEMENT: Binary Search Algorithm Implementation
     * To show algorithmic efficiency, we first sort the list by Last Name, 
     * then perform a Binary Search ($O(log n)$) instead of a Linear Search ($O(n)$).
     */
    public Contact searchByLastName(String lastName) {
        // 1. Convert Map values to a List for sorting
        List<Contact> sortedContacts = new ArrayList<>(contactList.values());

        // 2. Sort the list using a Comparator (Uses TimSort - O(n log n))
        Collections.sort(sortedContacts, Comparator.comparing(Contact::getLastName));

        // 3. Perform Binary Search
        int low = 0;
        int high = sortedContacts.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = sortedContacts.get(mid).getLastName().compareToIgnoreCase(lastName);

            if (comparison == 0) {
                return sortedContacts.get(mid); // Found!
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // Not found
    }

    /**
     * ENHANCEMENT: Performance Benchmarking
     * This helper method demonstrates the efficiency gain between the two algorithms.
     */
    public void compareSearchEfficiency(String targetLastName) {
        List<Contact> contacts = new ArrayList<>(contactList.values());

        // Linear Search Mockup
        long startTimeLinear = System.nanoTime();
        for (Contact c : contacts) {
            if (c.getLastName().equalsIgnoreCase(targetLastName)) break;
        }
        long endTimeLinear = System.nanoTime();

        // Binary Search Mockup (including sort time)
        long startTimeBinary = System.nanoTime();
        searchByLastName(targetLastName);
        long endTimeBinary = System.nanoTime();

        System.out.println("Linear Search Time: " + (endTimeLinear - startTimeLinear) + " ns");
        System.out.println("Binary Search (with Sort) Time: " + (endTimeBinary - startTimeBinary) + " ns");
    }

    // Standard delete and update methods remain below...
    public void deleteContact(String contactId) {
        contactList.remove(contactId);
    }
}
