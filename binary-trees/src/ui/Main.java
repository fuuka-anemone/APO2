package ui;

import model.BinarySearchTree;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        BinarySearchTree bsb = new BinarySearchTree(); //size 0
        System.out.println("| - Welcome to my binary search tree - | \n\n");
        menu(s, bsb);
    }

    public static void menu(Scanner sc, BinarySearchTree bsb) {
        System.out.println("1. to add a new node");
        System.out.println("2. to search a node");
        System.out.println("3. to remove a node");
        System.out.println("4. to print the tree inorder");
        System.out.println("5. to print the tree's root");
        System.out.println("0. to exit");
        int option = sc.nextInt();
        System.out.println();
        menu(option, bsb, sc);
    }

    public static void menu(int o, BinarySearchTree bsb, Scanner sc) {
        switch (o) {
            case 1:
                System.out.print("id: ");
                bsb.addNode(sc.nextInt());
                menu(sc, bsb);
            case 2:
                System.out.print("id: ");
                bsb.printNode(bsb.searchNode(sc.nextInt()));
                menu(sc, bsb);
            case 3:
                System.out.print("id: ");
                bsb.removeNode(sc.nextInt());
                menu(sc, bsb);
            case 4:
                bsb.inOrder();
                System.out.println();
                menu(sc,bsb);
            case 5:
                bsb.root();
                menu(sc,bsb);
            case 0:
                System.exit(0);
        } if (o > 5){
            menu(sc,bsb);
        }
    }
}
