package com.company;

import java.util.ArrayList;

public class MobilePhone {
    private ArrayList<Contact> contactList;
    private String mobilePhone;

    public MobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        this.contactList = new ArrayList<Contact>();
    }

    public boolean addContact(Contact contact) {
        int position = findContact(contact.getName());
        if (position < 0) {
            contactList.add(contact);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position >= 0) {
            this.contactList.set(position, newContact);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position > 0) {
            this.contactList.remove(position);
            return true;
        } else {
            return false;
        }
    }

    private int findContact(Contact contact) {
        return this.contactList.indexOf(contact);
    }

    private int findContact(String name) {
        if (this.contactList == null) {
            return -1;
        }
        for (int i = 0; i < this.contactList.size(); i++) {
            Contact contact = this.contactList.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact findContactName(String name) {
        int position = findContact(name);
        if (position >= 0 ) {
            return this.contactList.get(position);
        }
        return null;
    }



    public void printContacts() {
        for (int i = 0; i < this.contactList.size(); i++) {
            Contact contact = this.contactList.get(i);
            System.out.println((i + 1) + ". " + contact.getName() + " - " + contact.getNumber());
        }
    }

}
