package student_assignments;

/**
 * How do you find a cyclic in a Linked list?
 * 
 * WARNING: 
 * it will give you trouble when the number of 
 * nodes is either Even or Odd.
 * 
 * YT Channel: https://www.youtube.com/channel/UCM5ldu3IonPjffpYSnSYYJA/videos?view=0&sort=da&flow=grid
 * @author David
 */
public class IQ06_CyclicLinkedList {

    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        myList.appendToEnd(new Node("A"));
        Node nodeB = new Node("B");
        myList.appendToEnd(nodeB);
        myList.appendToEnd(new Node("C"));                
        myList.appendToEnd(new Node("D"));
        myList.appendToEnd(new Node("E")); // odd
        // myList.appendToEnd(new Node("F")); // even
        myList.appendToEnd(nodeB); // <-- this makes the node cyclic.
        
        // this is how linked-list look like:
        // A -> B -> C -> D -> E
        // A -> B -> C -> D -> E -> B
        System.out.printf("is list cyclic? ans: %s\n", myList.isCyclic());
    }

}

class LinkedList {
    
    public Node head;

    public LinkedList() {
        setHead(new Node("head"));        
    }
    
    public void appendToEnd(Node node) {
        Node current = head; // set to the beginning of the list
        // finds the end of the linked-list
        while (current.next != null) {
            current = current.next; // move to the next node 
        }
        current.next = node;
    }
    
    public boolean isCyclic() {
        Node slow = head;
        Node fast = head;
        
        while (slow.next != null && fast.next.next != null) {                                                                                                
            
            // shift the pointer to the following then,...
            slow = slow.next; // move to the next node
            fast = fast.next.next; // moving 2 steps at a time
            
            // ...compare, if the slow points to the same node as 
            // the fast node then the list contains a cyclic
            if (slow == fast) return true;
        }
        
        return false;
    }

    public Node getHead() { return head; }
    public void setHead(Node head) { this.head = head; }
}

class Node {
    public String data;
    public Node next;

    public Node(String data) {
        setData(data);
        setNext(null);
    }

    public String getData() { return data; }
    public Node getNext() { return next; }

    public void setData(String data) { this.data = data; }
    public void setNext(Node next) { this.next = next; }
}
