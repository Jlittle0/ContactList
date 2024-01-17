import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    private ArrayList<Person> contacts;
    private Scanner input = new Scanner(System.in);
    private boolean exit;

    public ContactList() {
        this.contacts = new ArrayList<Person>();
        exit = false;
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(String type) {
        switch (type) {
            case "1":
                // Stuff for adding a student
                System.out.println("Please fill out the following information.");
                System.out.println("First Name:");
                String studentFirstName = input.nextLine();
                System.out.println("Last Name:");
                String studentLastName = input.nextLine();
                System.out.println("Phone Number:");
                String studentPhoneNumber = input.nextLine();
                System.out.println("Grade:");
                int grade = input.nextInt();
                contacts.add(new Student(studentFirstName, studentLastName, studentPhoneNumber,grade));
                break;
            case "2":
                // Stuff for adding faculty
                System.out.println("Please fill out the following information.");
                System.out.println("First Name:");
                String facultyFirstName = input.nextLine();
                System.out.println("Last Name:");
                String facultyLastName = input.nextLine();
                System.out.println("Phone Number:");
                String facultyPhoneNumber = input.nextLine();
                System.out.println("Occupation:");
                String occupation = input.nextLine();
                contacts.add(new Faculty(facultyFirstName, facultyLastName, facultyPhoneNumber, occupation));
                break;
            default:
                // Do nothing
                System.out.println("Invalid input");
        }
    }

    public void displayMenu() {
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
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    public void sort(int sortBy) {
        switch (sortBy) {
            case 0:
                for(int i = 0; i < contacts.size(); i++) {
                    for (int j = 0; j < contacts.size() - i - 1; j++) {
                        if (contacts.get(j).getFirstName().compareTo(contacts.get(j + 1).getFirstName()) > 0) {
                            contacts.add(j, contacts.remove(j + 1));
                        }
                    }
                }
                break;
            case 1:
                for(int i = 0; i < contacts.size(); i++) {
                    for (int j = 0; j < contacts.size() - i - 1; j++) {
                        if (contacts.get(j).getLastName().compareTo(contacts.get(j + 1).getLastName()) > 0) {
                            contacts.add(j, contacts.remove(j + 1));
                        }
                    }
                }
                break;
            case 2:
                for(int i = 0; i < contacts.size(); i++) {
                    for (int j = 0; j < contacts.size() - i - 1; j++) {
                        if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0) {
                            contacts.add(j, contacts.remove(j + 1));
                        }
                    }
                }
                break;
            default:
                System.out.println("Something went wrong sort");
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person person : contacts) {
            if (person.getFirstName().equals(firstName)) {
                return person;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person person : contacts) {
            if (person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String PhoneNumber) {
        for (Person person : contacts) {
            if (person.getFirstName().equals(PhoneNumber)) {
                return person;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person person : contacts) {
            if (person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    public void run() {
        System.out.println("Welcome to your contacts list");
        while (!exit) {
            displayMenu();
            String userInput = input.nextLine();
            switch (userInput) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Select a type of contact to add:");
                    System.out.println("1. Student");
                    System.out.println("2. Faculty");
                    String secondInput = input.nextLine();
                    addContact(secondInput);
                    break;
                case "2":
                    sort(0);
                    printContacts();
                    break;
                case "3":
                    sort(1);
                    printContacts();
                    break;
                case "4":
                    sort(2);
                    printContacts();
                    break;
                case "5":
                    System.out.println("All students in your contacts list:");
                    listStudents();
                    break;
                case "6":
                    System.out.println("Please enter their first name:");
                    userInput = input.nextLine();
                    System.out.println(searchByFirstName(userInput));
                    break;
                case "7":
                    System.out.println("Please enter their last name:");
                    userInput = input.nextLine();
                    System.out.println(searchByLastName(userInput));
                    break;
                case "8":
                    System.out.println("Please enter their phone number:");
                    userInput = input.nextLine();
                    System.out.println(searchByPhoneNumber(userInput));
                    break;
                default:
                    System.out.println("Invalid user input");
            }
        }
    }
    public static void main(String[] args) {
        ContactList c = new ContactList();
        c.run();
    }
}


