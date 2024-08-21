package com.company;

import java.util.Scanner;

public class ContactBase {
    private String name;
    private String surname;
    private String phone;

    public ContactBase (String[] split_strings) {
        setName(split_strings[1]);
        setSurname(split_strings[2]);
        setPhone(split_strings[3]);
    }
    public ContactBase() {
    }

    public String to_line() {
        return String.format("%s,%s,%s,%s\n",
                "Base",
                getName(),
                getSurname(),
                getPhone()
        );
    }

    public void read_extra_properties(Scanner scanner) {
    }

    public void setBaseAttributes(String[] split_strings) {
        this.name = split_strings[1];
        this.surname = split_strings[2];
        this.phone = split_strings[3];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("name: %s, surname: %s, phone: %s",
                this.name,
                this.surname,
                this.phone);
    }
}
