package com.andrewpg.model;

import java.time.LocalDate;

public class Register {

    private String description;
    private Double ammount;
    private RegisterType type;
    private LocalDate date;

    
    public Register(String description, double ammount, RegisterType type, LocalDate date) {
        this.description = description;
        this.ammount = ammount;
        this.type = type;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmmount() {
        return ammount;
    }

    public void setAmmount(double ammount) {
        this.ammount = ammount;
    }

    public RegisterType getType() {
        return type;
    }

    public void setType(RegisterType type) {
        this.type = type;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
