package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PhonebookWithInheritance {
    // these are constants
    int MAX_NUMBER_OF_CONTACTS=100;
    String FILENAME="contacts_new.txt";

    // these are real members
    ContactBase[] contacts;
    int capacity;

    public PhonebookWithInheritance() {
        this.contacts=new ContactBase[MAX_NUMBER_OF_CONTACTS];
        this.capacity=0;
    }

    public void read() {
        File file = new File(FILENAME);
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (scanner.hasNextLine()) {
            String current_line = scanner.nextLine();
            String[] split_strings = current_line.split(",");
            contacts[capacity] = createContactFromParts(split_strings);
            capacity++;
        }
    }

    private static ContactBase createContactFromParts(String[] split_strings) {
        switch(split_strings[0]) {
            case "ArmyBuddy":
                return new ContactArmyBuddy(split_strings);
            case "WorkRelated":
                return new ContactWorkRelated(split_strings);
            case "ServiceProvider":
                return new ContactServiceProvider(split_strings);
        }
        throw new RuntimeException("You should be here");
    }

    public void write() {
        try {
            FileWriter file_writer = new FileWriter(FILENAME);
            for (int i = 0; i < capacity; i++) {
                file_writer.write(this.contacts[i].to_line());
            }
            file_writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(contacts[i].to_line());
        }
    }

    public void loop_menu() {
        outer: while(true) {
            System.out.println("Phonebook in java (ver 5.6.1-beta)");
            System.out.println("==================================");
            System.out.println("1) add contact");
            System.out.println("2) remove contact");
            System.out.println("3) search for contact");
            System.out.println("4) change contact phone");
            System.out.println("5) print the phonebook");
            System.out.println("6) exit");
            Scanner scanner=new Scanner(System.in);
            String user_answer=scanner.nextLine();
            switch (user_answer) {
                case "1":
                    this.add_contact(scanner);
                    break;
                case "2":
                    this.remove_contact(scanner);
                    break;
                case "3":
                    this.search_for_contact(scanner);
                    break;
                case "4":
                    this.change_phone(scanner);
                    break;
                case "5":
                    this.print();
                    break;
                case "6":
                    this.write();
                    break outer;
                default:
                    System.out.println("I don't know what you mean");
                    break;
            }
        }
    }

    private void add_contact(Scanner scanner) {
        System.out.println("What kind of contact do you want?");
        System.out.println("1) WorkRelated");
        System.out.println("2) ArmyBuddy");
        System.out.println("3) ServiceProvider");
        String user_answer=scanner.nextLine();
        ContactBase c;
        switch (user_answer) {
            case "1":
                c = new ContactWorkRelated();
                break;
            case "2":
                c = new ContactArmyBuddy();
                break;
            case "3":
                c = new ContactServiceProvider();
                break;
            default:
                throw new RuntimeException("I dont know what you mean");
        }
        System.out.print("What is the name of the contact: ");
        String name=scanner.nextLine();
        c.setName(name);
        System.out.print("What is the surname of the contact: ");
        String surname=scanner.nextLine();
        c.setSurname(surname);
        System.out.print("What is the phone of the contact: ");
        String phone=scanner.nextLine();
        c.setPhone(phone);
        c.read_extra_properties(scanner);
        this.contacts[capacity]=c;
        capacity++;
    }

    private void remove_contact(Scanner scanner) {
        /*
            contacts:
                | X | Y | Z | NULL | NULL | NULL |....
            We search for Y to remove it
                | X | Z | NULL | NULL | NULL | NULL |....
                capacity = 2
         */
        System.out.print("What is the name of the contact: ");
        String name=scanner.nextLine();
        for(int i=0;i<this.capacity;i++) {
            ContactBase current_contact=this.contacts[i];
            if(current_contact.getName().equals(name)) {
                if(i<this.capacity-1) {
                    this.contacts[i] = this.contacts[capacity - 1];
                }
                this.contacts[capacity-1]=null;
                this.capacity--;
                return;
            }
        }
        System.out.println("Haven't found you contact");
    }

    private void search_for_contact(Scanner scanner) {
        System.out.print("What is the name of the contact: ");
        String name=scanner.nextLine();
        for(int i=0;i<this.capacity;i++) {
            ContactBase current_contact = this.contacts[i];
            if (current_contact.getName().equals(name)) {
                System.out.println(current_contact);
                break;
            }
        }
        System.out.println("Haven't found you contact");
    }

    private void change_phone(Scanner scanner) {
        System.out.print("What is the name of the contact: ");
        String name=scanner.nextLine();
        for(int i=0;i<this.capacity;i++) {
            ContactBase current_contact = this.contacts[i];
            if (current_contact.getName().equals(name)) {
                System.out.print("What is the new phone of the contact: ");
                String new_phone=scanner.nextLine();
                current_contact.setPhone(new_phone);
                break;
            }
        }
        System.out.println("Haven't found you contact");
    }

    public static void main(String[] args) {
        PhonebookWithInheritance phonebook=new PhonebookWithInheritance();
        phonebook.read();
        // phonebook.print();
        phonebook.loop_menu();
    }
}
