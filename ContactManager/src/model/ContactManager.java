package model;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    private List<Contact> contacts;

    public ContactManager() {
        contacts = new ArrayList<>();
    }

    public void addContact(String ne, String em){
        contacts.add(new Contact(ne,em, contacts.size()+1));
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
