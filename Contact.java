
public class Contact implements Comparable<Contact> {
    private String name;
    private String phone;
    private String email;
    private String address;
    private String birthday;
    private String notes;
    //private xxxx? events;

    public Contact(String name, String phone, String email, String address, String birthday, String notes) {
        // constructor with parameters
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
        //events = new LinkedList<Event>();
    }

    public Contact() { // default constructor
        name = null;
        phone = null;
        email = null;
        address = null;
        birthday = null;
        notes = null;
        //events = new LinkedList<Event>();
    }

    @Override
    public int compareTo(Contact b) {
        // the method compare between two objects And return an integer indicate if
        // there are equal
        // or the first object is bigger than the other ,or smaller
        return name.compareTo(b.name);
    }

    /* public boolean checkconflict(String DateTime) {
        // the method accept a string and check if there are to events at the same time
        // returns true if theres conflict, false otherwise
       
        if (events.empty()) // check if list is empty
            return false;

        events.findFirst();
        while (!events.last()) {
            if (events.retrieve().getDateTime().equals((DateTime))) // check if there are to events at the same time
                return true;
            events.findNext();
        } // end while
        if (events.retrieve().getDateTime().equals(DateTime))
            return true;
        return false; 

    }// end checkconflict*/

    @Override
    public String toString() {
        return " Name: " + name + "\n Phone Number: " + phone + "\n Email Address: " + email + "\n Address: " + address
                + "\n Birthday (MM/DD/YYYY): " + birthday + "\n Notes: " + notes + "\n";
    }

    //// setter& getter

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    /*public void setEvents(Event event) {
        this.events.insert(event);
    } */

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }

    //public LinkedList<Event> getEvents() {
       // return events;
  //  }

}