package model;

import exception.InvalidNumberException;

public class Contact {

    private String name;
    private String phone;

    private String email;

    public Contact(String name, String phone, String email) throws InvalidNumberException {
        // Regular expresions
        try {
            this.name = name;
            this.phone = phone;
            this.email = email;
            Double.valueOf(phone);
        } catch (NumberFormatException ex) {
            throw new InvalidNumberException();
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object contact) {
        if (contact instanceof Contact) {
            return ((Contact) contact).getEmail().equals(this.name)
                    || ((Contact) contact).getPhone().equals(this.phone);
        }
        return false;
    }
}