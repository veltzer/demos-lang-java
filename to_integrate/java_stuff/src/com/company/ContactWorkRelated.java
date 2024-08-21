package com.company;

import java.util.Scanner;

public class ContactWorkRelated extends ContactBase {
    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    public ContactWorkRelated(String[] split_strings) {
        super(split_strings);
        setCompany(split_strings[4]);
    }
    public ContactWorkRelated() {
    }
    @Override
    public String to_line() {
        return String.format("%s,%s,%s,%s,%s\n",
                "WorkRelated",
                getName(),
                getSurname(),
                getPhone(),
                getCompany()
        );
    }
    @Override
    public void read_extra_properties(Scanner scanner) {
        System.out.print("What company: ");
        String company=scanner.nextLine();
        setCompany(company);
    }
}
