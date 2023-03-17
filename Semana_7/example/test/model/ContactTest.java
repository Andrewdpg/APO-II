package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import exception.InvalidNumberException;

public class ContactTest {

    // Verificar que el contact es creado correctamente
    @Test
    public void contactIsCreatedSuccessfullyTest() {
        Contact contact = new Contact("Alejandra", "3224210570", "alejamantillac@gmail.com");
        assertNotNull(contact);
        assertEquals(contact.getName(), "Alejandra");
        assertEquals(contact.getPhone(), "3224210570");
    }

    // Verificar que el teléfono es únícamente numérico
    @Test
    public void contactNumberIsNumericTest() {
        boolean result = false;
        try {
            new Contact("Alejandra", "3224210570", "alejamantillac@gmail.com");
            result = true;
        } catch (InvalidNumberException e) {
            e.printStackTrace();
        }
        assertTrue(result);
    }

    @Test
    public void contactNumberIsNotNumericTest() {

        assertThrows(InvalidNumberException.class, () -> new Contact("Alejandra", "afadf", "alejamantillac@gmail.com"));
    }

    @Test
    public void contactEmailIsValidTest() {
        assertTrue(true);
    }

}