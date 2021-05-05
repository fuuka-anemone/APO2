package model;

public class SimpleLinkedNode {

    private SimpleLinkedNode next;
    private int id;

    public SimpleLinkedNode(int i){
        id = i;
    }

    public int getId() {
        return id;
    }

    public SimpleLinkedNode getNext(){
        return next;
    }

    public void setNext(SimpleLinkedNode sln){
        next = sln;
    }
}
