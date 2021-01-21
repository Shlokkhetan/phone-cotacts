package com.company;

public class Contact {

    private String name;
    private String PhoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        PhoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public static Contact createContact(String name, String PhoneNumber){
        return new Contact(name, PhoneNumber);
    }
}
