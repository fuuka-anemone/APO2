package model;

public class LinkedList {

    private Node head; //i could also create an attribute that contains the tail of the list, this would do the adding much simpler.
    private int size;

    public LinkedList(){
        size = 0;
    }

    public void setHead(Node h){
        head = h;
    }

    public int getSize(){
        return size;
    }

    public Node getHead(){
        return head;
    }

    // adds the node at the end of the list.
    public void addNode(long id){
        Node n = new Node(id);
        if (head == null){
            setHead(n);
        } else {
            Node tail = head;
            while (tail.getNext() != null){ //searches for the last element (the tail) in the list.
                tail = tail.getNext(); //if the current element has a next element, then sets the current as the tail.
            }
            tail.setNext(n); //at this point, current is the last element, then sets its next (that's null) as the element that we want to add.
        }
        size++;
    }

    // adds the node as the head of the list.
    public void addAsHead(long id){
        Node n = new Node(id);
        n.setNext(head);
        setHead(n);
        size++;
    }

    //adds the node given a certain index.
    public boolean addNode(int index, long id){
        boolean added = true;
        if (index > size){ //index out of bounds.
            added = false;
        } else if (index == 0) { //adds it as the first element
            addAsHead(id);
        } else { //adds it within the list
            Node n = new Node(id);
            Node current = head;
            while (index-- != 1){ // why 1 and not 0? because to add an element at a certain index, you need be at the item before the index, to add it as the next.
                current = current.getNext();
            }
            n.setNext(current.getNext());
            current.setNext(n);
            size++;
        }
        return added;
    }

    //prints the nodes.
    public void printList(){
        Node current = head;
        System.out.print("[");
        for (int i = 0; i < size; i++){
            System.out.print(current.getId());
            if (i != size-1){
                System.out.print(",");
            }
            current = current.getNext();
        }
        System.out.print("]");
    }
}
