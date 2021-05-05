package model;

public class Node {

    private Node left;
    private Node right;
    private Node parent;
    private int id;


    public Node(int i){
        id = i;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getId() {
        return id;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setId(int id) {
        this.id = id;
    }
}


