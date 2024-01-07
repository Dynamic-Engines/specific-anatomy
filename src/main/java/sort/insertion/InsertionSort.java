import java.util.Arrays;

public class InsertionSort {

    private static int[] input = {14, 12, 5, 3, 1 , 2};

    private static int[] output(int[] input) {
        for(int i = 1; i < input.length; i++ ) {

            int key = input[i];
            int j = i - 1;

            while(j >= 0 && input[j] > key) {
                input[j + 1] = input[j];
                j = j - 1;
                input[j + 1] = key;
            }
        }
        
        return input;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(output(input)));
    }
    
}