
public class LinkedList<T> {
    private Node<T> head;
    private Node<T> current;

    public LinkedList() {
        // default constructor
        head = current = null;
    }

    public void add(T obj) {// it used to add the object in specific order

        Node<T> n = new Node<T>(obj);

        if (head == null) // if empty
        {
            head = current = n;
            return;
        }

        if (obj instanceof Contact) {// if the object was of type Contact
            if (((Contact) obj).compareTo((Contact) head.data) < 0) // add at first and change the head
            {
                n.next = head;
                head = n;
                return;
            }

            Node<T> p = head;
            Node<T> cur = head.next;

            while (cur != null && (((Contact) cur.data).compareTo((Contact) obj)) <= 0) {
                p = cur;
                cur = cur.next;
            }

            n.next = cur; // add at the last or middle
            p.next = n;

        } // outer if that check if it was a contact

        if (obj instanceof Event) {// if the object was of type Event
            if (((Event) obj).compareTo((Event) head.data) < 0) // add at first and change the head
            {
                n.next = head;
                head = n;
                return;
            }

            Node<T> p = head;
            Node<T> cur = head.next;

            while (cur != null && (((Event) cur.data).compareTo((Event) obj)) <= 0) {
                p = cur;
                cur = cur.next;
            }
            n.next = cur; // add at the last or middle
            p.next = n;
        } // outer if that check if it was a Event
    }// end method addd

    public void insert(T vall) {// insert object to the list
        Node<T> tmp = new Node<T>(vall);

        if (empty()) // list is empty
            current = head = tmp;
        else {
            tmp.next = current.next;
            current.next = tmp;
            current = tmp;
        }
    }// end method

    public void remove() {// remove object from the list

        if (current == head)
            head = head.next;
        else {
            Node<T> tmp = head;
            while (tmp.next != current)
                tmp = tmp.next;
            tmp.next = current.next;
        }
        if (current.next == null)
            current = head;
        else
            current = current.next;
    }// end method

    public void removeSpecificObject(T obj) {
        // this method recieve a object, find its place and delete it, it doesn't return
        // anything

        if (head.data == obj)// check the condition
            head = head.next;

        Node<T> privous = head;
        Node<T> temp = head.next;

        while (temp != null) {
            if (temp.data == obj) {
                privous.next = temp.next;
            } // end if
            privous = privous.next;
            temp = temp.next;
        } // end while

    }/// end method

    public void printList() {
        /*
         * this method print all element in the list,
         * it has no parameter and does not return anything
         */
        if (empty()) { // check if it's not empty
            System.out.println("there is nothing to  print ");
            return;
        }
        current = head;
        while (current != null) { // loop on all element
            System.out.println(current.data.toString()); // print element's data
            current = current.next;
        }

    }// end method

    // setter&getter

    public boolean full() {
        return false;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current.next == null;
    }

    public void findFirst() {
        current = head;
    }

    public void findNext() {
        current = current.next;
    }

    public T retrieve() {
        return current.data;
    }

    public void update(T val) {
        current.data = val;
    }

}// end class