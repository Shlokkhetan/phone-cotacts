package com.company;

import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContact;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContact = new ArrayList<Contact>();
    }
    public boolean updateContact(Contact oldContact, Contact newContact){
        int foundPosition = findContact(oldContact);
        if(foundPosition< 0){
            System.out.println("Contact not  found");
            return false;

        }
        this.myContact.set(foundPosition,newContact);
        System.out.println("The cootact  at position: " + foundPosition + "was updated to: " +  newContact);
        return true;
    }


    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);
        if(foundPosition< 0){
            System.out.println("Contact not  found");

            return false;

        }
        this.myContact.remove(foundPosition);
        System.out.println("The cootact  at position: " + foundPosition + "was removed ");
        return true;
    }

    public void printContacts(){
        System.out.println("Contact list");
        for(int i = 0; i<myContact.size(); i++){
            System.out.println("Position: " + i +
                    "Name : " + myContact.get(i).getName() +
                    "Phone Number : " + myContact.get(i).getPhoneNumber());

        }
    }

    public boolean addNewContact(Contact contact){
        if((findContact(contact.getName()) >= 0)){
            System.out.println("Contact is  already on filee");
            return false;

        }
        myContact.add(contact);
        return true;



    }

    private int findContact(Contact contact){
        return this.myContact.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i =0; i<this.myContact.size();i++){
           Contact contact = this.myContact.get(i);
           if(contact.getName().equals(contactName)){
               return i;
            }
        }

        return  -1;

    }

    public  String queryContact(Contact contact){
        if(findContact(contact)>=0){
            return contact.getName();
        }
        return null;
    }
    public Contact queryContact(String name){
        int position = findContact(name);
        if(position>=0){
            return this.myContact.get(position);
        }
        return null;
    }




}


