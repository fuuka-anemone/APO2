package model;

public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(){
    }

    public void addNode(int id){
        Node n = new Node(id);
        if (root == null){
            root = n;
        } else {
            addNode(root,n);
        }
    }

    //overload* damn i was calling it override all this time.
    private void addNode(Node current, Node newNode){
        if (newNode.getId() <= current.getId()){
            if (current.getLeft() != null) {
                addNode(current.getLeft(), newNode);
            } else {
                current.setLeft(newNode);
                newNode.setParent(current);
            }
        } else {
            if (current.getRight() != null){
                addNode(current.getRight(), newNode);
            } else {
                current.setRight(newNode);
                newNode.setParent(current);
            }
        }
    }

    public Node searchCar(int id){
        return searchCar(root, id);
    }

    //overload
    private Node searchCar(Node current, int id){
        if (current == null || current.getId() == id){
            return current;
        } else if (id < current.getId()){
            searchCar(current.getLeft(),id);
        } else {
            searchCar(current.getRight(), id);
        }
        return null;
    }

    public void removeNode(int id){
        Node toRemove = searchCar(id);
        removeNode(toRemove);
    }

    private void removeNode(Node toRemove){
        if (toRemove != null){
            if (toRemove.getLeft() == null && toRemove.getRight() == null){ // case 1, removing a leaf.
                if (toRemove == root){
                    root = null;
                } else if (toRemove.getParent().getLeft() == toRemove){
                    toRemove.getParent().setLeft(null);
                } else {
                    toRemove.getParent().setRight(null);
                }
                toRemove.setParent(null);
            } else if (toRemove.getLeft() == null || toRemove.getRight() == null){ //case 2, removing a node with 1 son.
                Node son;
                if (toRemove.getLeft() != null){
                    son = toRemove.getLeft();
                    toRemove.setLeft(null);
                } else {
                    son = toRemove.getRight();
                    toRemove.setRight(null);
                }
                son.setParent(toRemove.getParent());
                if (toRemove == root){
                    root = son;
                } else if (toRemove.getParent().getLeft() == toRemove){
                    toRemove.getParent().setLeft(son);
                } else {
                    toRemove.getParent().setRight(son);
                }
                toRemove.setParent(null);
            }
        } else { //case 3, removing a node with both sons, we search for the successor (the most left node of the right subtree of the node that we want to remove.
            Node successor = findSuccessor(toRemove.getRight());
            toRemove.setId(successor.getId());
            removeNode(successor);
        }
    }

    private Node findSuccessor(Node current){
        if (current.getLeft() == null){
            return current;
        } else {
            return findSuccessor(current.getLeft());
        }
    }
}
