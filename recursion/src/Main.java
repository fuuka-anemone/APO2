import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int test = s.nextInt();
        System.out.println("Fibonacci: "+fib(test));
        System.out.println("Factorial: " + fact(test));
        System.out.println("Sum: " + sum(test));
        System.out.println("Tail Factorial: " + tailFact(test));
    }

    //pre: n>0
    public static int fib(int n){
        if (n <= 2){
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }
    }

    //pre: n >= 0
    public static int fact(int n){ //no final linear
        if (n <= 1){
            return 1;
        } else{
            return fact(n-1)*n;
        }
    }

    //pre: n >= 1
    public static int sum(int n){
        if (n == 1){
            return 1;
        } else{
            return sum(n-1)+n;
        }
    }

    private static int tailFact(int n, int fact){ //final linear using parameters accumulation (fact is the accumulation).
        if (n <= 1){
            return fact;
        } else{
            return tailFact(n-1, n*fact);
        }
    }

    public static int tailFact(int n){  //method override.
        return tailFact(n,1);
    }
}
