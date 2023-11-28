public class Event implements Comparable<Event> {
   // private String type; ?could be boolean?
    private String title;
    private String dateTime;
    private String location;
   // private Contact contactInvolved;
    /******************************** */
    private boolean appointment;
    private LinkedList <Contact> EventContacts=new LinkedList<Contact>();

    /******************************** */

    public Event(boolean appointment, String title, String dateTime, String location) {
            //constructor with parameters
        //this.type=type;
        this.title = title;
        this.dateTime = dateTime;
        this.location = location;
       // this.contactInvolved = contactInvolved;
        this.appointment=appointment;
        
    }// end method

    @Override
    public int compareTo(Event b) { 
        // the method compare between two objects And return an integer indicate if there are equal 
        //or the first object is bigger than the other ,or smaller
        return title.compareTo(b.title);
    }// end method



    /********************************* */
    //used to check if the event has alrady exist or not 
    public boolean compareEvent( Event obj){
        if(  this.title.equalsIgnoreCase(obj.title)&&this.dateTime.equalsIgnoreCase(obj.dateTime)&&this.location.equalsIgnoreCase(obj.location)) 
        return true;
        else
        return false;

    }

    /********************************* */

    public void setEventContacts( Contact c){

        EventContacts.add(c);
    }

    public LinkedList<Contact> getEventContacts(){
        return EventContacts;

    }

    /********************************* */
   public boolean Getappointment(){return appointment;}


/******************************************** */
   public String listContactName(){
    String names="";

    EventContacts.findFirst();
    while(EventContacts!=null){
       names=names+EventContacts.retrieve().getName()+" ,";
        EventContacts.findNext();

    }
    return names;

   }

/************************** */






   
    public String toString() {

        String names= listContactName();
        String text="";
        if(appointment==true)
        text=" title: " + title + "\n Contact name: " + printList()
                + "\n Event date and time(MM/DD/YYYYHH:MM):" + dateTime + "\n Event location:" + location+"\n";

         else
            text= " title: " + title + "\n Contact name: " +names
                + "\n appointment date and time(MM/DD/YYYYHH:MM):" + dateTime + "\n appointment location:" + location+"\n";

                return text;

    }// end method








    //setter&getter
    public String gettitle() {
        return this.title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

   /*  public Contact getContactInvolved() {
        return this.contactInvolved;
    }

    public void setContactInvolved(Contact contactInvolved) {
        this.contactInvolved = contactInvolved;
    }

    */

}//end class
