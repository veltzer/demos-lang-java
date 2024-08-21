package com.company;

import java.util.Scanner;

public class ContactServiceProvider extends ContactBase {
    private String occupation;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }


    public ContactServiceProvider(String[] split_strings) {
        super(split_strings);
        setOccupation(split_strings[4]);
    }
    public ContactServiceProvider() {
    }
    @Override
    public String to_line() {
        return String.format("%s,%s,%s,%s,%s\n",
                "ServiceProvider",
                getName(),
                getSurname(),
                getPhone(),
                getOccupation()
        );
    }
    @Override
    public void read_extra_properties(Scanner scanner) {
        System.out.print("What occupation: ");
        String occupation=scanner.nextLine();
        setOccupation(occupation);
    }
}
