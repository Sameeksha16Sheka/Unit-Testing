package data;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactTest {
	public ContactManager contact;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		 contact = new ContactManager();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddContact() {
        String result = contact.addContact("Sam", "1234567890");
        assertEquals("Contact added successfully", result);
    }

    @Test
    void DuplicatePhone() {
    	contact.addContact("Sam", "1234567890");
        String result = contact.addContact("Sam", "1234567890");
        assertEquals("Contact with this phone number already exists", result);
    }

    @Test
    void testAddContact_InvalidInput() {
        
        String result1 = contact.addContact(null, "1234567890");
        assertEquals(result1, "Name cannot be null or empty");

        
        String result2 = contact.addContact("John Doe", "");
        assertEquals(result2, "Phone number cannot be null or empty");
    }


    @Test
    void testDeleteContact_Success() {
    	contact.addContact("Veena", "9876543210");
        String result = contact.deleteContact("9876543210");
        assertEquals("Contact deleted successfully", result);
    }

    @Test
    void testDeleteContact_NotFound() {
        String result = contact.deleteContact("1111111111");
        assertEquals("Contact not found", result);
    }

    @Test
    void testDeleteContact_InvalidInput() {
        String result = contact.deleteContact(null);
        assertEquals("Invalid input", result);

        result = contact.deleteContact("");
        assertEquals("Invalid input", result);
    }

    @Test
    void testUpdateContact() {
    	contact.addContact("Veena", "1111111111");
        String result = contact.updateContact("1111111111", "Veena");
        assertEquals("Contact updated successfully", result);
    }

    @Test
    void testUpdateContact_NotFound() {
        String result = contact.updateContact("2222222222", "Veena");
        assertEquals("Contact not found", result);
    }

    @Test
    void testUpdateContact_InvalidInput() {
    	contact.addContact("Veena", "1111111111");

        String result = contact.updateContact(null, "Veena");
        assertEquals("Invalid input", result);

        result = contact.updateContact("1111111111", null);
        assertEquals("Invalid input", result);
    }

    @Test
    void testViewContact() {
    	 contact.addContact("Veena", "3333333333");
         String result = contact.viewContact("3333333333");
         assertNotNull(result);
         
    }

    @Test
    void testViewContact_NotFound() {
        String result = contact.viewContact("4444444444");
        assertEquals("Contact not found", result);
    }

    
    @Test
    void testViewAllContacts() {
        contact.addContact("Veena", "1111111111");
        contact.addContact("Sam", "3333333333");

        Map<String, Contact> allContacts = contact.viewAllContacts();
        assertNotNull(allContacts); 
        assertEquals(2, allContacts.size());
        assertTrue(allContacts.containsKey("1111111111"));
        assertTrue(allContacts.containsKey("3333333333"));
    }


}
