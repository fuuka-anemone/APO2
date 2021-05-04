package ui;
import model.LinkedList;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        LinkedList ll = new LinkedList(); //size 0
        System.out.println("| - Welcome to my linked list - | \n\n");
        menu(s,ll);
    }

    public static void menu(Scanner sc, LinkedList l){
        System.out.println("1. to add a new element as the head");
        System.out.println("2. to add a new element as the tail");
        System.out.println("3. to add a new element by index");
        System.out.println("4. to search an element by attribute");
        System.out.println("5. to delete an element by attribute");
        System.out.println("6. to print the list.");
        System.out.println("7. to print the list size.");
        System.out.println("0. to exit");
        int option = sc.nextInt();
        System.out.println();
        menu(option,l,sc);
    }

    public static void menu(int o, LinkedList l, Scanner sc){
            switch (o){
                case 1:
                    System.out.print("id: ");
                    l.addAsHead(sc.nextLong());
                    menu(sc,l);
                case 2:
                    System.out.print("id: ");
                    l.addNode(sc.nextLong());
                    menu(sc,l);
                case 3:
                    System.out.print("id: ");
                    long id = sc.nextLong();
                    System.out.print("\nindex: ");
                    if(!l.addNode(sc.nextInt(),id)){
                        System.out.println("error, index out of bounds");
                    }
                    menu(sc,l);
                case 4:
                    System.out.print("id: ");
                    l.printNode(l.searchNode(sc.nextLong()));
                    menu(sc,l);
                case 5:
                    System.out.print("id: ");
                    l.printNode(l.removeNode(sc.nextLong()));
                    menu(sc,l);
                case 6:
                    l.printList();
                    menu(sc,l);
                case 7:
                    System.out.println("Linked list size: "+l.getSize());
                    menu(sc,l);
                case 0:
                    System.exit(0);
            }

    }
}
