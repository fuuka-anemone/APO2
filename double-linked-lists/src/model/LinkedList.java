package model;

public class LinkedList {

    private CircularDoubleLinkedNode firstCircularDoubleLN; //LN stands for Linked Node (if it's not pretty obvious already lol)
    private SimpleLinkedNode firstSimpleLN;

    public LinkedList(){
    }


    public void addSimpleLN(int i){
        SimpleLinkedNode toAdd = new SimpleLinkedNode(i);
        if (firstSimpleLN == null){
            firstSimpleLN = toAdd;
        } else {
            addSimpleLN(firstSimpleLN, toAdd); // this can also be done within the same node, like in the next line
            //firstSimpleLN.addSimpleLN(toAdd);  -
            // then, within SimpledLinkedNode, we would have the recursive method that would set its own next as the toAdd node if next is null,
            // pretty much like the recursive method below but without the getters and setters.
        }
    }

    private void addSimpleLN(SimpleLinkedNode current, SimpleLinkedNode toAdd){
        if (current.getNext() == null){
            current.setNext(toAdd);
        } else {
            addSimpleLN(current.getNext(),toAdd);
        }
    }

    public void addCircularDoubleLN(int i){
        CircularDoubleLinkedNode toAdd = new CircularDoubleLinkedNode(i);
        if (firstCircularDoubleLN == null){
            firstCircularDoubleLN = toAdd;
            toAdd.setNext(toAdd);
            toAdd.setPrevious(toAdd);
        } else {
            toAdd.setPrevious(firstCircularDoubleLN.getPrevious());
            firstCircularDoubleLN.getPrevious().setNext(toAdd);
            toAdd.setNext(firstCircularDoubleLN);
            firstCircularDoubleLN.setPrevious(toAdd);
        }
    }

    public CircularDoubleLinkedNode searchCircularDoubleLN(int i){
        return searchCircularDoubleLN(i,firstCircularDoubleLN);
    }

    private CircularDoubleLinkedNode searchCircularDoubleLN(int i, CircularDoubleLinkedNode current){
        if (current == null || current.getId() == i){
            return current;
        } else if (current.getNext() != firstCircularDoubleLN){
            return searchCircularDoubleLN(i, current.getNext());
        } else {
            return null;
        }
    }

    public CircularDoubleLinkedNode removeCircularDoubleLN(int i){
        if (firstCircularDoubleLN == null){
            return null;
        } else if (firstCircularDoubleLN.getNext() == firstCircularDoubleLN)
    }



}
