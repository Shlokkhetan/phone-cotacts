package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("9890380983908");

    public static void main(String[] args) {

        System.out.println("Start phone yes or no");
        String coonfirmation = scanner.nextLine().toLowerCase();

            startPhone();
            printInstructions();
            boolean quit = false;
            while(!quit){
                System.out.println("Select from 0-6(if options are needed press 6");
                int action = scanner.nextInt();
                    switch (action){
                        case 0 :
                            System.out.println("Shutting down");
                            quit = true;
                            break;
                        case 1:
                            mobilePhone.printContacts();
                            break;
                        case 2:
                            addNewContact();
                            break;
                        case 3:
                            updateContact();
                            break;

                        case 4:
                            removeContact();
                            break;

                        case 5:
                            queryContact();
                            break;

                        case 6:
                            printInstructions();
                            break;




            }


            }






	// write your code here
    }
    private static void startPhone() {
        System.out.println("Starting phone...");
    }
    private static void printInstructions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0  - to shutdown\n" +
                "1  - to print contacts\n" +
                "2  - to add a new contact\n" +
                "3  - to update existing an existing contact\n" +
                "4  - to remove an existing contact\n" +
                "5  - query if an existing contact exists\n" +
                "6  - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

    private static void addNewContact(){
        System.out.println("Enter the name of thee conntact");
        String Name = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Enter the phone number");
        String phoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(Name, phoneNumber);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added : " + Name + " Contact no: " + phoneNumber);
        }else{
            System.out.println("unable to add contact");
        }
    }

    private static void updateContact(){
        System.out.println("Enter the old contact name: ");
        String oldName = scanner.nextLine();
        System.out.println("Enter the old contact number: ");
        Contact existingcontactrecord =  mobilePhone.queryContact(oldName);
        if(existingcontactrecord == null){
            System.out.println("contact not found");

        }
        System.out.println("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter the Phone numbr");
        String newno = scanner.nextLine();

        Contact newContact = Contact.createContact(newName,newno);
        if(mobilePhone.updateContact(existingcontactrecord,newContact)){
            System.out.println("Your old contact has beeen updated");
        }else{
            System.out.println("Error updating contact");
        }




    }
    private  static void removeContact(){
        System.out.println("Enter thee  name of  the  coontact you want removed: ");
        String  toRemove = scanner.nextLine();
        Contact toRemov = mobilePhone.queryContact(toRemove);
        if(mobilePhone.removeContact(toRemov)){
            System.out.println("The item has  beenn succesfully  removed");
        }else{
            System.out.println("The  item has been removed");
        }
    }

    private static void queryContact(){
        System.out.println("Enter the namee of  the  cotact that yoou wannt  to find");
        String qury = scanner.nextLine();
        Contact toqury = mobilePhone.queryContact(qury);
        System.out.println("The  conntact exists with name: " + toqury.getName() + " Phone number: " + toqury.getPhoneNumber());
    }


}
