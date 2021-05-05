package ui;

import model.LinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        System.out.println("| - Welcome to my recursive simple - circular double linked lists - | \n\n");
        mainMenu(s, ll);
    }

    public static void mainMenu(Scanner sc, LinkedList ll) {
        System.out.println("1. to work with simple linked nodes");
        System.out.println("2. to work with double circular double linked nodes");
        System.out.println("0. to exit");
        int option = sc.nextInt();
        System.out.println();
        menu(option, ll, sc);
    }

    public static void menu(int o, LinkedList ll, Scanner sc) {
        switch (o) {
            case 1:
                switch (secondMenu(sc)){
                    case 1:
                        System.out.print("id: ");
                        ll.addSimpleLN(sc.nextInt());
                        mainMenu(sc,ll);
                    case 2:
                        System.out.print("id: ");
                        if (ll.searchSimpleLN(sc.nextInt()) == null){
                            System.out.println("node not found");
                        } else {
                            System.out.println("The node was found");
                        }
                        mainMenu(sc,ll);
                    case 3:
                        System.out.print("id: ");
                        if (ll.removeSimpleLinkedNode(sc.nextInt()) == null){
                            System.out.println("node not found");
                        } else {
                            System.out.println("The node was removed successfully");
                        }
                        mainMenu(sc,ll);
                    case 4:
                        ll.printSimpleLN();
                        System.out.println();
                        mainMenu(sc,ll);
                    case 0:
                        mainMenu(sc,ll);
                }
            case 2:
                switch (secondMenu(sc)){
                    case 1:
                        System.out.print("id: ");
                        ll.addCircularDoubleLN(sc.nextInt());
                        mainMenu(sc,ll);
                    case 2:
                        System.out.print("id: ");
                        if (ll.searchCircularDoubleLN(sc.nextInt()) == null){
                            System.out.println("node not found");
                        } else {
                            System.out.println("The node was found");
                        }
                        mainMenu(sc,ll);
                    case 3:
                        System.out.print("id: ");
                        if (ll.removeCircularDoubleLN(sc.nextInt()) == null){
                            System.out.println("node not found");
                        } else {
                            System.out.println("The node was removed successfully");
                        }
                        mainMenu(sc,ll);
                    case 4:
                        ll.printCircularDoubleLN();
                        System.out.println();
                        mainMenu(sc,ll);
                    case 0:
                        mainMenu(sc,ll);
                }
            case 0:
                System.exit(0);
        }
    }

    public  static int secondMenu(Scanner sc){
        System.out.println("1. to add a new node");
        System.out.println("2. to search a node");
        System.out.println("3. to remove a node");
        System.out.println("4. to print the list");
        System.out.println("0. to return to the main menu");
        return sc.nextInt();
    }
}
