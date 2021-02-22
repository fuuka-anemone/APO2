import java.util.Arrays;

public class Main {

    public static int[] array;

    public static void bubbleSort(){
        boolean swapped = true;
        for (int j= 1; j < array.length && swapped; j++) {
            swapped = false;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println(Arrays.toString(array));
        }

    }

    public static void selectionSort(){
        for (int i = 0; i < array.length; i++){
            int min = array[i];
            for (int j = i+1; j < array.length; j++){
                if (array[j] < min){
                    int temp = array[j];
                    array[j] = min;
                    min = temp;
                }
            }
            array[i] = min;
            System.out.println(Arrays.toString(array));
        }
    }

    public static void main(String[] args){
        array = new int[]{7,3,9,2,5,1,6,4,8};
        selectionSort();
        //Collections.shuffle(Arraylist n)
    }
}
