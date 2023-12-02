import java.util.Scanner;

public class Phonebook {

    public static Scanner input = new Scanner(System.in); // to use it in the whole class if needed
    public static LinkedList<Contact> PBook = new LinkedList<Contact>(); // a bst of all contacts
    public static BST<Contact> PBook2 = new BST<Contact>(); // a bst of all contacts

    public static LinkedList<Event> AllEvent = new LinkedList<Event>(); // a list of all events

    public static void main(String[] args) {

        System.out.println("Welcome to the phonebook!");
        // do while for menu
        int num;
        do {

            System.out.println("\n \n \n Please choose an option from the following ");
            System.out.println(
                    " 1.Add a contact \n 2.Search for a contact \n 3.Delete a contact \n 4.Schedule an event \n 5.Print event details \n 6.Print contacts by first name \n 7.Print all events alphabetically \n 8.Print contacts that share an event\n 9.Exit");
            num = input.nextInt();
            input.nextLine();

            switch (num) {
                case 1:
                    System.out.println("Enter the contact's name:");
                    String name = input.nextLine();
                    System.out.println("Enter the contact's phone number");
                    String phone = input.nextLine();
                    System.out.println("Enter the contact's email address:");
                    String email = input.nextLine();
                    System.out.println("Enter the contact's address:");
                    String address = input.nextLine();
                    System.out.println("Enter the contact's birthday (MM/DD/YYYY):");
                    String bday = input.nextLine();
                    System.out.println("Enter any notes for the contact:");
                    String note = input.nextLine();
                    Contact newContact = new Contact(name, phone, email, address, bday, note);

                    if (!PBook2.chickUnique(newContact)) {
                        /************************** */
                        if (PBook2.insert(name, newContact)) {
                            System.out.println("Contact added successfully!");
                            PBook.add(newContact);
                        } else
                            System.out.println("This name exists!");

                    } else
                        System.out.println("This contact already exists!");

                    break;
                /************************** */
                case 2:
                    System.out.println(
                            "Enter search criteria:\n 1.Name\n 2.Phone Number\n 3.Email Address \n 4.Address\n 5.Birthday");
                    int searchChoice = input.nextInt();
                    switch (searchChoice) {
                        case 1:
                            System.out.println("Enter the contact's name:");
                            break;
                        case 2:
                            System.out.println("Enter the contact's phone number");
                            break;
                        case 3:
                            System.out.println("Enter the contact's email address:");
                            break;
                        case 4:
                            System.out.println("Enter the contact's address:");
                            break;
                        case 5:
                            System.out.println("Enter the contact's birthday (MM/DD/YYYY):");
                            break;
                        default:
                            System.out.println("You have entered a wrong number, please try again!");
                            break;
                    }
                    input.nextLine();
                    String choice = input.nextLine();

                    if (!PBook2.empty()) {
                        searchFor(searchChoice, choice);
                    } else
                        System.out.println("Nothing found!\n");

                    break;

                case 3:

                    System.out.println("Enter the name of the contact you want to delete");
                    String deletedContact = input.nextLine();
                    deleteContact(deletedContact);
                    break;


                case 4:
                    scheduleEvent();
                    break;

                case 5:
                    printEventDetails();
                    break;

                case 6:
                    System.out.println("Enter the first name: ");
                    String firstName = input.next();

                    if (PBook2.empty())
                        System.out.print("No contactS found\n");
                    else {
                        PBook2.searchFirstName(firstName);
                    }
                    break;

                case 7:
                    if (AllEvent.empty()) {
                        System.out.println("there are no events to print");
                    } else {
                        AllEvent.findFirst();
                        while (!AllEvent.last()) {
                            System.out.print(AllEvent.retrieve().toString()); // print all events alphabetically
                            AllEvent.findNext();
                        }

                        System.out.println(AllEvent.retrieve().toString());
                    }
                    break;

                /*
                 * case 8:
                 * printSharedEvent();
                 * break;
                 */
                case 8:
                    System.out.println("Thank you for using the phonebook, goodbye!");
                    break;

                default:
                    System.out.println("You have entered a wrong number, please try again");
                    break;

            }

        } while (num != 8);

    }// end main

    // methods

    /*
     * public static boolean checkUnique(Contact c) {
     * // checks if the contact exists already in the phonebook list. returns true
     * if
     * // it is unique and false otherwise
     * 
     * if (PBook.empty())
     * return true;
     * PBook.findFirst();
     * while (!PBook.last()) {
     * if (PBook.retrieve().getName().equalsIgnoreCase(c.getName())
     * || PBook.retrieve().getPhone().equalsIgnoreCase(c.getPhone())) {
     * return false;
     * }
     * PBook.findNext();
     * } // end while
     * 
     * if (PBook.retrieve().getName().equalsIgnoreCase(c.getName())
     * || PBook.retrieve().getPhone().equalsIgnoreCase(c.getPhone())) //check last
     * element
     * return false;
     * 
     * else
     * return true;
     * 
     * }// end of checkUnique method
     * 
     */

    /******************************************************************** */
    public static void searchFor(int searchChoice, String choice) {
        switch (searchChoice) {
            case 1:
                if (PBook2.findkey(choice)) {
                    System.out.println("Contact found!");
                    System.out.println(PBook2.retrieve().toString());

                } else
                    System.out.println("Contact not found!");

                break;

            case 2:
                if (PBook2.SearchPhone(choice)) {
                    System.out.println("Contact found!");
                    System.out.println(PBook2.retrieve().toString());
                } else
                    System.out.println("Contact not found!");

                break;

            case 3:
                PBook2.SearchEmail(choice);
                break;

            case 4:
                PBook2.SearchAddress(choice);
                break;

            case 5:
                PBook2.SearchBirthday(choice);
                break;

        }// end switch

    } // end search for
    /******************************************************************** */

    /*
     * public static LinkedList<Contact> search(int searchChoice, String choice) {
     * 
     * // This method searches for a list of contacts based on the inputs the user
     * //entered.
     * // It searches either by full name, phone number ,email, address, birthday,
     * or
     * //first name
     * // and returns a linked list with all the contacts that match the search
     * 
     * 
     * LinkedList<Contact> returnedlist = new LinkedList<Contact>();
     * if (PBook.empty())
     * return returnedlist;
     * 
     * PBook.findFirst();
     * while (!PBook.last()) {
     * switch (searchChoice) {
     * case 1:
     * if (PBook.retrieve().getName().equalsIgnoreCase(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 2:
     * if (PBook.retrieve().getPhone().equals(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 3:
     * if (PBook.retrieve().getEmail().equalsIgnoreCase(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 4:
     * if (PBook.retrieve().getAddress().equalsIgnoreCase(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 5:
     * if (PBook.retrieve().getBirthday().equals(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 6:
     * if (PBook.retrieve().getName().substring(0,
     * PBook.retrieve().getName().indexOf(" "))
     * .equalsIgnoreCase(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * }// end switch
     * PBook.findNext();
     * } // end while
     * 
     * switch (searchChoice) { // check last element
     * case 1:
     * if (PBook.retrieve().getName().equalsIgnoreCase(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 2:
     * if (PBook.retrieve().getPhone().equals(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 3:
     * if (PBook.retrieve().getEmail().equalsIgnoreCase(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 4:
     * if (PBook.retrieve().getAddress().equalsIgnoreCase(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 5:
     * 
     * if (PBook.retrieve().getBirthday().equals(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * case 6:
     * if (PBook.retrieve().getName().substring(0,
     * PBook.retrieve().getName().indexOf(" "))
     * .equalsIgnoreCase(choice))
     * returnedlist.insert(PBook.retrieve());
     * break;
     * 
     * }// end switch
     * 
     * return returnedlist;
     * 
     * }// end searh method
     * 
     * 
     */
    /*
     * public static void scheduleEvent() {
     * 
     * // schedule an event for a contact, it checks if the contact exists
     * // or it has a conflict at the entered time, shows a message accordingly
     * 
     * System.out.println("Enter event title: ");
     * String title = input.nextLine();
     * System.out.println("Enter contact name:");
     * String contact = input.nextLine(); // change it to contact name
     * 
     * if (search(1, contact).empty())
     * System.out.print("Contact entered doesn't exist!\n");
     * else {
     * Contact contactInvolved = search(1, contact).retrieve();
     * System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
     * String DateTime = input.nextLine();
     * System.out.println("Enter event location:");
     * String location = input.nextLine();
     * 
     * if (contactInvolved.checkconflict(DateTime))
     * System.out.println("The contact has time conflict!\n");
     * else {
     * Event e = new Event(title, DateTime, location, contactInvolved);
     * contactInvolved.setEvents(e);
     * AllEvent.add(e); // add to big list
     * System.out.println("Event scheduled successfully!");
     * }
     * } // end else
     * } // end schedule event
     */

    /******************************************************************** */
    public static void scheduleEvent() {
        /*
         * schedule an event for a contact, it checks if the contact exists
         * or it has a conflict at the entered time, shows a message accordingly
         */
        System.out.println("Enter type: \n 1.event \n 2.appointment ");
        int value = input.nextInt();
        input.nextLine();

        Event e;
        String title = "";
        boolean type = false;
        Contact contactObj;
        boolean found = false;

        if (!PBook2.empty()) {
            switch (value) {
                case 1:
                    System.out.println("Enter event title: ");
                    title = input.nextLine();
                    type = false;
                    break;
                case 2:
                    System.out.println("Enter appointment title: ");
                    title = input.nextLine();
                    type = true;
                    break;

            }// switch

            System.out.println("Enter contact name:");
            String contact = input.nextLine();

            if (PBook2.findkey(contact) == false)
                System.out.println("contact not found");

            else {
                contactObj = PBook2.retrieve();
                System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
                String DateTime = input.nextLine();
                System.out.println("Enter event location:");
                String location = input.nextLine();

                // check if there are a conflict
                if (contactObj.checkconflict(DateTime))
                    System.out.println("The contact has time conflict!\n");
                else {
                    e = new Event(type, title, DateTime, location);
                    // add the event to contact eventList

                    if (AllEvent.empty()) {
                        contactObj.setEvents(e);
                        System.out.println("event is added to the contact");
                        System.out.println("the list was empty");
                        e.setEventContacts(contactObj);
                        AllEvent.add(e);
                        System.out.println("Event scheduled successfully!");
                        found = true;
                    }

                    else {
                        if (type == true) {
                            found = false;
                        } else {
                            AllEvent.findFirst();
                            while (!AllEvent.last()) {

                                if (AllEvent.retrieve().compareEvent(e) == true) {
                                    contactObj.setEvents(AllEvent.retrieve());
                                    System.out.println("event is added to the contact");
                                    AllEvent.retrieve().setEventContacts(contactObj);
                                    contactObj.setEvents(AllEvent.retrieve());
                                    System.out.println("Event scheduled successfully!");
                                    System.out.println("the contact is added to exist event");
                                    found = true;
                                } // end if
                                AllEvent.findNext();

                            }
                            if (AllEvent.retrieve().compareEvent(e) == true) {
                                contactObj.setEvents(AllEvent.retrieve());
                                System.out.println("event is added to the contact");
                                AllEvent.retrieve().setEventContacts(contactObj);
                                contactObj.setEvents(AllEvent.retrieve());
                                System.out.println("Event scheduled successfully!");
                                System.out.println("the contact is added to exist event");
                                found = true;
                            } // end if

                        } // end of else (check type)

                        if (!found) {
                            e.setEventContacts(contactObj);
                            contactObj.setEvents(e);
                            AllEvent.add(e);
                            System.out.println("Event scheduled successfully!");
                            System.out.println("no  exist event was found");
                        }

                    }

                } // inner else

            } // outer if
        } else
            System.out.println("there are no contacts exists");

    } // end schedule event

    /******************************************************************** */

    /*
     * public static void printEventDetails() {
     * 
     * //print event details based on criteria, either by contact name or event
     * title
     * //shows a message if the contact doesnt exist or if it doesnt have any events
     * // or if there is no events that match the titles entered
     * 
     * 
     * System.out.
     * println("Enter search criteria number :\n1.Contact name\n2.Event tittle");
     * int searchEvent = input.nextInt();
     * input.nextLine();
     * LinkedList<Contact> returnedContacts = new LinkedList<Contact>();
     * switch (searchEvent) {
     * case 1:
     * System.out.println("Enter contact name:");
     * String contactName = input.nextLine();
     * returnedContacts = search(1, contactName);
     * if (returnedContacts.empty())
     * System.out.print("Contact entered doesn't exist!\n");
     * else {
     * if (!returnedContacts.retrieve().getEvents().empty()) {
     * System.out.println("Events for " + contactName);
     * returnedContacts.retrieve().getEvents().printList();
     * } // end if
     * else
     * System.out.println("There are no events for " + contactName);
     * } // end else
     * break;
     * 
     * case 2:
     * System.out.println("Enter Event name:");
     * String EventName = input.nextLine();
     * if (AllEvent.empty())
     * System.out.println("There are no events!");
     * else {
     * boolean found=false;
     * AllEvent.findFirst();
     * while (!AllEvent.last()) {
     * if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName)){
     * System.out.println(AllEvent.retrieve().toString());
     * found=true;}
     * AllEvent.findNext();
     * } // end while
     * if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName)){// check last
     * element
     * System.out.println(AllEvent.retrieve().toString());
     * found=true;}
     * if(!found)
     * System.out.println("There are no events with that title!");
     * } // end else
     * break;
     * 
     * default:
     * System.out.println("You have entered a wrong number, please try again");
     * break;
     * 
     * }
     * }// end method
     * 
     * 
     */
    /********************************************************* */
    public static void printEventDetails() {
        /*
         * print event details based on criteria, either by contact name or event title
         * shows a message if the contact doesnt exist or if it doesnt have any events
         * or if there is no events that match the titles entered
         */

        System.out.println("Enter search criteria number :\n1.Contact name\n2.Event tittle");
        int searchEvent = input.nextInt();
        input.nextLine();
        LinkedList<Event> returnedEvent = new LinkedList<Event>();
        boolean found;

        switch (searchEvent) {
            case 1:
                System.out.println("Enter contact name:");
                String contactName = input.nextLine();
                if (PBook2.findkey(contactName)) {
                    returnedEvent = PBook2.retrieve().getEvents();
                    System.out.println("contact found");
                    if (returnedEvent.empty()) {
                        System.out.println("There are no events for " + contactName);
                    } else {
                        System.out.println("check if list was empty or not " + (returnedEvent.empty()));
                        System.out.println("Events for " + contactName);
                        System.out.println(returnedEvent.printList());
                    }
                } else
                    System.out.print("Contact entered doesn't exist!\n");

                break;

            case 2:

                System.out.println("Enter Event name:");
                String EventName = input.nextLine();
                if (AllEvent.empty())
                    System.out.println("There are no events!");
                else {
                    found = false;
                    AllEvent.findFirst();
                    while (!AllEvent.last()) {
                        if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName)) {
                            System.out.println(AllEvent.retrieve().toString());
                            found = true;
                        }
                        AllEvent.findNext();
                    } // end while
                    if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName)) {
                        System.out.println(AllEvent.retrieve().toString());
                        found = true;
                    }

                    if (!found)
                        System.out.println("There are no events with that title!");
                } // end else
                break;

            default:
                System.out.println("You have entered a wrong number, please try again");
                break;

        }
    }// end method

    /******************************************************************* */

    public static void deleteContact(String name){
        if (PBook2.findkey(name)) { //check contact exists
            if (!AllEvent.empty()) { //check there are events
                        AllEvent.findFirst();
                        while(!AllEvent.last()) { 

                            if(AllEvent.retrieve().Getappointment()){ //if appointment, delete
                                LinkedList<Contact> TempList =AllEvent.retrieve().getEventContacts();
                                if (TempList.retrieve().getName().equalsIgnoreCase(name))
                                    AllEvent.removeSpecificObject(AllEvent.retrieve());
                            }
                            else{ //its an event

                            AllEvent.retrieve().getEventContacts().removeSpecificObject(PBook2.retrieve());

                            if(AllEvent.retrieve().getEventContacts().empty()) //if all contact deleted in event, delete event
                                AllEvent.removeSpecificObject(AllEvent.retrieve());
                            }

                            AllEvent.findNext();
                        }

                        //last node1
                       if(AllEvent.retrieve().Getappointment()){ //if appointment, delete

                            LinkedList<Contact> TempList =AllEvent.retrieve(). getEventContacts();
                            if (TempList.retrieve().getName().equalsIgnoreCase(name))
                                AllEvent.removeSpecificObject(AllEvent.retrieve());
                        }

                        else{ //its an event

                            AllEvent.retrieve().getEventContacts().removeSpecificObject(PBook2.retrieve());

                            if(AllEvent.retrieve().getEventContacts().empty()) //if all contact deleted in event, delete event
                                AllEvent.removeSpecificObject(AllEvent.retrieve());
                        }
                        }
                        PBook2.remove_key(name);
                        System.out.println("Contact and all related events/appointments deleted successfully");
                    }
        else
            System.out.println("Contact doesn't exist!");

        }
        
    /*
     * public static void deleteContact(String name) {
     * 
     * //This method takes the name of contact as a string and delete it
     * // , Also delete all associated events, the method does not return anything
     * 
     * 
     * if (PBook.empty()) { // check if pbook is empty
     * System.out.println("there is no contacts to be deleted");
     * return;
     * }
     * 
     * LinkedList<Contact> TempList = search(1, name);// search for the contact that
     * has the given name
     * if (!TempList.empty()) { // check if there is a returned contact
     * PBook.removeSpecificObject(TempList.retrieve()); // delete the contact
     * System.out.println("Contact is deleted! ");
     * if (!AllEvent.empty()) { // chech if there exist any event
     * 
     * boolean isDeleted = false;
     * AllEvent.findFirst();
     * while (!AllEvent.last()) { // loop to delete any associated events
     * if
     * (AllEvent.retrieve().getContactInvolved().getName().equalsIgnoreCase(name)) {
     * AllEvent.remove();
     * isDeleted = true;
     * } // end if
     * else
     * AllEvent.findNext();
     * } // end while loop
     * 
     * if
     * (AllEvent.retrieve().getContactInvolved().getName().equalsIgnoreCase(name)) {
     * // check last element
     * AllEvent.remove();
     * isDeleted = true;
     * }
     * 
     * if (isDeleted == true)
     * System.out.println("and all associated event were deleted!");
     * else
     * System.out.println("this contact doesn't have any event to be deleted");
     * } // end if
     * 
     * else
     * System.out.println("there is no scheduled events to be deleted");
     * } // outer if
     * 
     * else // no contact with name
     * System.out.println("contact not found");
     * }// end deleteContact method
     * 
     * 
     */

    /*
     * 
     * //i think we don't need it anymore
     * public static void printSharedEvent() {
     * 
     * //this method prints the names of contacts that share an event the user
     * // specified
     * 
     * System.out.println("Enter event title");
     * String EventName = input.nextLine();
     * System.out.println("Enter event date and time (MM/DD/YYYY HH:MM):");
     * String DateTime = input.nextLine();
     * System.out.println("Enter event location:");
     * String location = input.nextLine();
     * if (AllEvent.empty())
     * System.out.println("There are no events!");
     * else {
     * boolean found = false;
     * AllEvent.findFirst();
     * while (!AllEvent.last()) {
     * if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName)
     * && AllEvent.retrieve().getDateTime().equalsIgnoreCase(DateTime)
     * && AllEvent.retrieve().getLocation().equalsIgnoreCase(location)) {
     * found = true;
     * System.out.println(AllEvent.retrieve().getContactInvolved().getName());
     * }
     * AllEvent.findNext();
     * } // end while
     * 
     * if (AllEvent.retrieve().gettitle().equalsIgnoreCase(EventName)
     * && AllEvent.retrieve().getDateTime().equalsIgnoreCase(DateTime)
     * && AllEvent.retrieve().getLocation().equalsIgnoreCase(location)) { //check
     * last element
     * found = true;
     * System.out.println(AllEvent.retrieve().getContactInvolved().getName());
     * }
     * 
     * if (!found)
     * System.out.println("No event found for the entered info!");
     * else
     * System.out.println("these are all the involved contacts");
     * } // end else
     * }// end method
     * 
     */

}// end phone book
