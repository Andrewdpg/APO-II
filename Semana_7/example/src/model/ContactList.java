package model;

import java.util.LinkedList;

import exception.DuplicatedContactException;

public class ContactList {

    private LinkedList<Contact> list;

    public ContactList() {
        list = new LinkedList<>();
    }

    public void addContact(Contact contact) throws DuplicatedContactException{
        if(list.contains(contact)){
            throw new DuplicatedContactException();
        }
        list.add(contact);
    }

    public int getSize() {
        return list.size();
    }

    public Contact getLast() {
        return list.getLast();
    }

}
