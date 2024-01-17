import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    // Instance variables for every contact list
    private ArrayList<Person> contacts;
    private Scanner input = new Scanner(System.in);
    private boolean exit;

    public ContactList() {
        contacts = new ArrayList<Person>();
        exit = false;
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(String type) {
        // Asks for all the basic information using scanner & saves it
        System.out.println("Please fill out the following information.");
        System.out.println("First Name:");
        String firstName = input.nextLine();
        System.out.println("Last Name:");
        String lastName = input.nextLine();
        System.out.println("Phone Number:");
        String phoneNumber = input.nextLine();
        switch (type) {
            case "1":
                // Case for adding a student (requires a grade)
                System.out.println("Grade:");
                int grade = input.nextInt();
                input.nextLine();
                contacts.add(new Student(firstName, lastName, phoneNumber, grade));
                break;
            case "2":
                // Case for adding a faculty member (requires occupation)
                System.out.println("Occupation:");
                String occupation = input.nextLine();
                contacts.add(new Faculty(firstName, lastName, phoneNumber, occupation));
                break;
            default:
                // Do nothing and let user know that they did something wrong or there's an error in code
                System.out.println("Invalid input (addContact)");
        }
    }

    public void displayMenu() {
        // Prints out the menu items via print statements
        System.out.println("Please pick from the following menu options");
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. List all contacts by First Name");
        System.out.println("3. List all contacts by Last Name");
        System.out.println("4. List all contacts by Phone Number");
        System.out.println("5. List all Students");
        System.out.println("6. Search by First Name");
        System.out.println("7. Search by Last Name");
        System.out.println("8. Search by Phone Number");
        System.out.println("0. Exit");
    }

    public void printContacts() {
        // Goes through each contact using a forEach loop and prints them out individually.
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    public void sort(int sortBy) {
        switch (sortBy) {
            case 0:
                // Sorting through contacts by firstName (bubble sort)
                for (int i = 0; i < contacts.size(); i++) {
                    for (int j = 0; j < contacts.size() - i - 1; j++) {
                        // Swapping indices if the firstName of contact at j is further
                        // in the alphabet than that of contact at j+1
                        if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                            contacts.add(j, contacts.remove(j + 1));
                        }
                    }
                }
                break;
            case 1:
                // Sorting through contacts by lastName (bubble sort)
                for (int i = 0; i < contacts.size(); i++) {
                    for (int j = 0; j < contacts.size() - i - 1; j++) {
                        // Swapping indices if the lastName of contact at j is further
                        // in the alphabet than that of contact at j+1
                        if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                            contacts.add(j, contacts.remove(j + 1));
                        }
                    }
                }
                break;
            case 2:
                // Sorting through contacts by phoneNumber (bubble sort)
                for (int i = 0; i < contacts.size(); i++) {
                    for (int j = 0; j < contacts.size() - i - 1; j++) {
                        // Swapping indices if the phoneNumber of contact at j is further
                        // numerically than that of contact at j+1
                        if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j + 1).getPhoneNumber()) > 0) {
                            contacts.add(j, contacts.remove(j + 1));
                        }
                    }
                }
                break;
            default:
                // Does nothing and prints a statement indicating that something is wrong with the input
                System.out.println("Something went wrong (sort)");
        }
    }

    public Person searchByFirstName(String firstName) {
        // Go through each contact and check whether their firstName is the same as the
        // one being searched for, if so, return that person.
        for (Person person : contacts) {
            if (person.getFirstName().equals(firstName)) {
                return person;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        // Go through each contact and check whether their lastName is the same as the
        // one being searched for, if so, return that person.
        for (Person person : contacts) {
            if (person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String PhoneNumber) {
        // Go through each contact and check whether their phoneNumber is the same as the
        // one being searched for, if so, return that person.
        for (Person person : contacts) {
            if (person.getPhoneNumber().equals(PhoneNumber)) {
                return person;
            }
        }
        return null;
    }

    public void listStudents() {
        // Iterates through each of the people in contacts and checks whether
        // they're a student and prints their toString if they are.
        for (Person person : contacts) {
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    public void run() {
        System.out.println("Welcome to your contacts list");
        while (!exit) {
            // Until the user exits by selecting it from the menu, continue.
            displayMenu();
            String userInput = input.nextLine();
            switch (userInput) {
                // Cases for each of the menu items
                case "0":
                    // Exit
                    System.exit(0);
                    break;
                case "1":
                    // Add Contact
                    System.out.println("Select a type of contact to add:");
                    System.out.println("1. Student");
                    System.out.println("2. Faculty");
                    String secondInput = input.nextLine();
                    addContact(secondInput);
                    break;
                case "2":
                    // Print contacts sorted by firstName
                    sort(0);
                    printContacts();
                    break;
                case "3":
                    // Print contacts sorted by lastName
                    sort(1);
                    printContacts();
                    break;
                case "4":
                    // Print contacts sorted by phoneNumber
                    sort(2);
                    printContacts();
                    break;
                case "5":
                    // Print out all the students in the contacts list
                    System.out.println("All students in your contacts list:");
                    listStudents();
                    break;
                case "6":
                    // Search for a contact by their firstName
                    // Returns null if they aren't found
                    System.out.println("Please enter their first name:");
                    userInput = input.nextLine();
                    System.out.println(searchByFirstName(userInput));
                    break;
                case "7":
                    // Search for a contact by their lastName
                    // Returns null if they aren't found
                    System.out.println("Please enter their last name:");
                    userInput = input.nextLine();
                    System.out.println(searchByLastName(userInput));
                    break;
                case "8":
                    // Search for a contact by their phoneNumber
                    // Returns null if they aren't found
                    System.out.println("Please enter their phone number:");
                    userInput = input.nextLine();
                    System.out.println(searchByPhoneNumber(userInput));
                    break;
                default:
                    // Indicate that something went wrong with the user's input when prompted
                    System.out.println("Invalid user input");
            }
        }
    }

    public static void main(String[] args) {
        ContactList c = new ContactList();
        c.run();
    }
}


