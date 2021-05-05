package model;

public class CircularDoubleLinkedNode {

    private CircularDoubleLinkedNode next;
    private CircularDoubleLinkedNode previous;
    private int id;

    public CircularDoubleLinkedNode(int i){
        id = i;
    }

    public int getId() {
        return id;
    }

    public CircularDoubleLinkedNode getNext() {
        return next;
    }

    public CircularDoubleLinkedNode getPrevious() {
        return previous;
    }

    public void setNext(CircularDoubleLinkedNode cDLN){
        next = cDLN;
    }

    public void setPrevious(CircularDoubleLinkedNode cDLN){
        previous = cDLN;
    }
}
