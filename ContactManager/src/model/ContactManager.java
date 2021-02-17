package model;

import java.io.*;
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

    public void importContacts (String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line = br.readLine();
        while (line != null){
            String[] parts = line.split(";");  // the regex could be a constant = FILESEPARATOR = ";"
            addContact(parts[0], parts[1]);
            line = br.readLine();
        }
    }

    public void exportContacts (String filename) throws IOException{
        PrintWriter pw = new PrintWriter(new FileWriter(filename,true));
        for (Contact c : contacts) {
            pw.println(c.getName() + ";" + c.getEmail());
        }
        pw.close();
    }
}
