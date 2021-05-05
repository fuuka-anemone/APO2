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


    public SimpleLinkedNode searchSimpleLN(int i){
        return searchSimpleLN(i, firstSimpleLN);
    }

    private SimpleLinkedNode searchSimpleLN(int i, SimpleLinkedNode current){
        if (current == null || current.getId() == i){ //if found then return it.
            return current;
        } else if (current.getNext() != null){ //if not found but the next ain't null, then get the next.
            return searchSimpleLN(i, current.getNext());
        } else {
            return null; //not found.
        }
    }

    private SimpleLinkedNode removeSimpleLN(SimpleLinkedNode current, SimpleLinkedNode toRemove){
         if (current.getNext() == null) {
             return null;
         } else {
             if (current.getNext() == toRemove){
                 current.setNext(toRemove.getNext());
                 toRemove.setNext(null);
                 return toRemove;
             } else {
                 return removeSimpleLN(current.getNext(),toRemove);
             }
         }
    }

    public SimpleLinkedNode removeSimpleLinkedNode(int i){
        SimpleLinkedNode toRemove = searchSimpleLN(i);
        if (firstSimpleLN == null || toRemove == null){
            return null;
        } else if (firstSimpleLN == toRemove){
            if (firstSimpleLN.getNext() == null){
                firstSimpleLN = null;
            } else {
                firstSimpleLN = toRemove.getNext();
            }
            //toRemove.setNext(null); i don't know if i should set the pointer null.
            return toRemove;
        } else {
            return removeSimpleLN(firstSimpleLN, toRemove);
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
        if (current == null || current.getId() == i){ //we use the null verification in case of the list being empty (then the first is null)
            return current;
        } else if (current.getNext() != firstCircularDoubleLN){
            return searchCircularDoubleLN(i, current.getNext());
        } else {
            return null; //we return null if the method couldn't find the node.
        }
    }

    public CircularDoubleLinkedNode removeCircularDoubleLN(int i){
        CircularDoubleLinkedNode toRemove = searchCircularDoubleLN(i);
        if (toRemove == null){
            return null;
        } else if (toRemove == firstCircularDoubleLN && toRemove.getNext() == firstCircularDoubleLN){
            firstCircularDoubleLN = null;
        } else {
            toRemove.getPrevious().setNext(toRemove.getNext());
            toRemove.getNext().setPrevious(toRemove.getPrevious());
            if (toRemove == firstCircularDoubleLN) {
                firstCircularDoubleLN = toRemove.getNext();
            }
        }
        return toRemove;
    }

    public void printSimpleLN(){
        if (firstSimpleLN == null){
            System.out.println("The simple linked list is empty.");
        } else {
            printSimpleLN(firstSimpleLN);
        }
    }

    private void printSimpleLN(SimpleLinkedNode current){
        if (current != null){
            System.out.print(current.getId()+" ");
            printSimpleLN(current.getNext());
        }
    }

    public void printCircularDoubleLN(){
        if (firstCircularDoubleLN == null){
            System.out.println("The circular double linked list is empty.");
        } else {
            printCircularDoubleLN(firstCircularDoubleLN);
        }
    }

    private void printCircularDoubleLN(CircularDoubleLinkedNode current){
        System.out.print(current.getId()+" ");
        if (current.getNext() != firstCircularDoubleLN){
            printCircularDoubleLN(current.getNext());
        }
    }

    public void nonRecursivePrint(){
        if (firstCircularDoubleLN == null){
            System.out.println("The circular double linked list is empty.");
        } else {
            CircularDoubleLinkedNode current = firstCircularDoubleLN;
            do{
                System.out.print(current.getId()+" ");
                current = current.getNext();
            } while (current != firstCircularDoubleLN);
        }
    }
}
