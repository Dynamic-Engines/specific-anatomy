import java.util.Arrays;

public class Merge {
    
    private static void merge(Integer[] input, int p, int q, int r) {
        int sizeL = q - p + 1;
        int sizeR = r - q; 

        Integer[] leftArray = new Integer[sizeL];
        Integer[] rightArray = new Integer[sizeR];

        for(int i=0; i < sizeL; i++) {
            leftArray[i] = input[p + i];
        }

        for(int i=0; i < sizeR; i++) {
            rightArray[i] = input[q + 1 + i];
        }

        int i = 0;
        int  j = 0;
        int k = p; // index to fill - so it wont start from 0 every tine

        while (i < sizeL && j < sizeR) {
            if (leftArray[i] <= rightArray[j]) {
                input[k] = leftArray[i];
                i = i + 1;
            } else {
                input[k] = rightArray[j];
                j = j + 1;
            }

            k = k + 1;
        }

        while (i < sizeL) {
            input[k] = leftArray[i];
            i = i + 1;
            k = k + 1;
        }

        while (j < sizeR) {
            input[k] = rightArray[j];
            j = j + 1;
            k = k + 1;
        }
    }

    private static void mergeSort(Integer[] input, int p, int r) {
        if(p >= r) {
            return;
        }

        int q = (p + r) / 2;

        mergeSort(input, p, q);
        mergeSort(input, q + 1, r);
        
        merge(input, p, q, r);
    }

    private static Integer[] getOutput(Integer[] input) {
        mergeSort(input, 0, input.length - 1);
        return input;
    }

    public static void main(String[] args) {
        Integer [] input = {10, 12, 14 , 3, 2, 1, 0};

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(getOutput(input)));

    }

}
