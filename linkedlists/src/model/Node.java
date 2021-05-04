package model;

public class Node {

    private Node next;
    private long id; //only used in this case for learning purposes as it will be needed for searching / deleting specific nodes by their attributes.

    public Node(long i){
        id = i;
    }

    public Node getNext(){
        return next;
    }

    public void setNext(Node n){
        next = n;
    }

    public void setId(long i){
        id = i;
    }

    public long getId(){
        return id;
    }
}
