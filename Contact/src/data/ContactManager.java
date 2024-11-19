package data;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class ContactManager {
    private Map<String, Contact> contacts = new HashMap<>();

    public String addContact(String name, String phone) {
    	if (name == null || name.trim().isEmpty()) {
            return "Name cannot be null or empty";
        }
        if (phone == null || phone.trim().isEmpty()) {
            return "Phone number cannot be null or empty";
        }
        if (contacts.containsKey(phone)) {
            return "Contact with this phone number already exists";
        }
        Contact contact = new Contact(name, phone);
        contacts.put(phone, contact);
        return "Contact added successfully";
    }

    public String deleteContact(String phone) {
    	 if (phone == null || phone.trim().isEmpty()) {
    	        return "Invalid input";  
    	}
    	 
        if (!contacts.containsKey(phone)) {
            return "Contact not found";
        }
        contacts.remove(phone);
        return "Contact deleted successfully";
    }

 
    public String updateContact(String phone, String newName) {
    	if (phone == null || phone.trim().isEmpty() || newName == null || newName.trim().isEmpty()) {
            return "Invalid input";
        }


        if (!contacts.containsKey(phone)) {
            return "Contact not found";
        }
        Contact contact = contacts.get(phone);
        contact.setName(newName);
        return "Contact updated successfully";
    }

    public String viewContact(String phone) {
        Contact c = contacts.get(phone);
        return (c == null) ? "Contact not found" : c.toString();
    }

    public Map<String, Contact> viewAllContacts() {
        return new HashMap<>(contacts); 
    }
}









/*public class ContactManager {

    
     public boolean updateContact(String oldName, String newName, String newPhone) {
        // Search for the contact by oldName
        for (Contact contact : contacts) {
            if (contact.getName().equals(oldName)) {
                // Update the contact details
                contact.setName(newName);
                contact.setPhone(newPhone);
                return true; // Successfully updated
            }
        }
        return false; // No contact with oldName found
    }

    // Delete a contact by name
    public boolean deleteContact(String name) {
        // Search for the contact and remove it if found
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                contacts.remove(i);
                return true; // Successfully deleted
            }
        }
        return false; // No contact with the given name found
    }

    // Check if a contact exists by name
    public void displayContacts() {
        for (Contact contact : contacts) {
            System.out.println("Name: " + contact.getName() + ", Phone: " + contact.getPhone());
        }
    }
    
    
    private List<Contact> contacts;

  
    public ContactManager() {
    	 this.contacts = new ArrayList<>();
    }

    
    public boolean addContact(String name, String phone) {
        
    	if (informationExists(name)) {
            return false; 
        }
        
  
        Contact newContact = new Contact(name, phone);
        contacts.add(newContact);
        return true;
    }

   
    public boolean updateContact(String oldName, String newName, String newPhone) {
       
        return false; 
    }

    
    public boolean deleteContact(String name) {
       
        return false; 
    }
    
    public boolean informationExists(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                return true; // Contact found
            }
        }
        return false; // Contact not found
}*/