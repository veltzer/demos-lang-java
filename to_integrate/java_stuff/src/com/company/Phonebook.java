package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Phonebook {
    // these are constants
    int MAX_NUMBER_OF_CONTACTS=100;
    String FILENAME="contacts.txt";

    // these are real members
    Contact[] contacts;
    int capacity;

    public Phonebook() {
        this.contacts=new Contact[MAX_NUMBER_OF_CONTACTS];
        this.capacity=0;
    }

    public void read() {
        File file = new File(FILENAME);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int line_counter = 0;
        while (scanner.hasNextLine()) {
            String current_line = scanner.nextLine();
            line_counter++;
            String[] split_strings = current_line.split(",");
            if (split_strings.length != 3) {
                System.err.println("You stupid user! Your line " + line_counter + " is very bad");
                return;
            }
            Contact new_contact = new Contact(split_strings[0], split_strings[1], split_strings[2]);
            contacts[capacity] = new_contact;
            capacity++;
        }
    }

    public void write() {
        try {
            FileWriter file_writer = new FileWriter(FILENAME);
            for (int i = 0; i < capacity; i++) {
                Contact current_contact = this.contacts[i];
                String contact_to_write=String.format("%s,%s,%s\n",
                        current_contact.getName(),
                        current_contact.getSurname(),
                        current_contact.getPhone());
                file_writer.write(contact_to_write);
            }
            file_writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.println(contacts[i]);
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
        System.out.print("What is the name of the contact: ");
        String name=scanner.nextLine();
        System.out.print("What is the surname of the contact: ");
        String surname=scanner.nextLine();
        System.out.print("What is the phone of the contact: ");
        String phone=scanner.nextLine();
        Contact new_contact = new Contact(name, surname, phone);
        this.contacts[capacity]=new_contact;
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
            Contact current_contact=this.contacts[i];
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
            Contact current_contact = this.contacts[i];
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
            Contact current_contact = this.contacts[i];
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
        Phonebook phonebook=new Phonebook();
        phonebook.read();
        // phonebook.print();
        phonebook.loop_menu();
    }
}
