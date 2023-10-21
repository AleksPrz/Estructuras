import java.util.Arrays;
public class BubbleSort {
    
    public static int[] bubbleSort(int[] arr){
        bubbleSort(arr, arr.length - 1);
        return arr;
    }

    private static void bubbleSort(int[] arr, int limite) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < limite; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap = true;
                    int aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                }
                System.out.println("-" + Arrays.toString(arr));
            }
            limite--;
        }
    }
}
