package model;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.DuplicateFormatFlagsException;

import org.junit.Test;

import exception.DuplicatedContactException;

public class ContactListTest {

    ContactList list;

    // Escenario en el que hay 5 contactos en la lista
    public void setUp1() {
        list = new ContactList();

        list.addContact(new Contact("Andres", "111", "a@a.com"));
        list.addContact(new Contact("Bernardo", "211", "b@a.com"));
        list.addContact(new Contact("Carlos", "311", "c@a.com"));
        list.addContact(new Contact("Daniela", "411", "d@a.com"));
        list.addContact(new Contact("Erika", "511", "e@a.com"));

    }

    @Test
    public void addNewContactTest() {
        // Arrange
        setUp1();

        // Act

        list.addContact(new Contact("Fabio", "666", "f@a.com"));

        // Assert
        assertEquals(list.getSize(), 6);
        assertEquals(list.getLast().getPhone(), "666");
    }

    @Test
    public void addDuplicatedContactTest() {
        setUp1();
        assertThrows(DuplicatedContactException.class, () -> {
            list.addContact(new Contact("Erika", "511", "e@a.com"));
        });
    }
}
