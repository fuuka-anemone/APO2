package model;

public class LinkedList {

    private Node first;

    public LinkedList(){
    }

    public void setFirst(Node f){
        first = f;
    }

    public Node getFirst(){
        return first;
    }

    public void addNode(long id){
        Node n = new Node(id);
        if (first == null){
            setFirst(n);
        } else {
            Node current = first;
            while (current.getNext() != null){ //searches for the last element in the list
                current = current.getNext(); //if the current element has a next element, then sets that element as current.
            }
            current.setNext(n); //at this point, current is the last element, then sets its next (that's null) as the element that we want to add.
        }
    }
}
