package com.company;

import java.util.Scanner;

public class ContactArmyBuddy extends ContactBase {
    private String armyid;

    public String getArmyid() {
        return armyid;
    }

    public void setArmyid(String armyid) {
        this.armyid = armyid;
    }

    public ContactArmyBuddy(String[] split_strings) {
        super(split_strings);
        setArmyid(split_strings[4]);
    }
    public ContactArmyBuddy() {

    }
    @Override
    public String to_line() {
        return String.format("%s,%s,%s,%s,%s\n",
                "ArmyBuddy",
                getName(),
                getSurname(),
                getPhone(),
                getArmyid()
        );
    }
    @Override
    public void read_extra_properties(Scanner scanner) {
        System.out.print("What armyid: ");
        String armyid=scanner.nextLine();
        setArmyid(armyid);
    }
}
