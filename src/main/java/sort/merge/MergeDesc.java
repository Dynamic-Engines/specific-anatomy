import java.util.Arrays;

public class MergeDesc {
    
    public static void merge(Integer[] array, Integer p, Integer q, Integer r) {

        Integer nL = q - p + 1; // 3 - 0 + 1 == 4, lenght pf ledt sub array
        Integer nR = r - q; // 7 - 3 == 4

        System.out.println("p: "+ p +", q: "+ q + ", r: "+ r +", nl: "+ nL +", nR: " + nR);

        Integer[] lA = new Integer[nL]; // left array 0, 3 = 4
        Integer[] rA = new Integer[nR]; // right array 0, 3 = 4

        for(int i = 0; i < nL; i++)
            lA[i] = array[p + i];

        for(int j = 0; j < nR; j++)
            rA[j] = array[q + j + 1];

        System.out.println("-------------------");
        System.out.println(Arrays.toString(rA));
        System.out.println(Arrays.toString(lA));
        System.out.println(lA.length+", "+rA.length);
        
        Integer iL = 0; // smallest in L
        Integer jR = 0; // smallest in R
        Integer k = p; //indexes in array to fill

        while (iL < nL && jR < nR) {
            if (lA[iL] <= rA[jR]) {
                array[k] = lA[iL];
                iL = iL + 1;
            } else {
                array[k] = rA[jR];
                jR = jR + 1;
            }

            k = k + 1;
        }

        // Fill remaining
        while (iL < nL) {
            array[k] = lA[iL];
            iL = iL + 1;
            k = k + 1;
        }

        while (jR < nR) {
            array[k] = rA[jR];
            jR = jR + 1;
            k = k + 1;
        }
    }

    public static void mergeSort(Integer[] array, Integer p, Integer r) {
        if (p >= r) { // zero or single element check
            return;
        }

        Integer q = (p + r) / 2;

        mergeSort(array, p, q);
        mergeSort(array, q + 1, r);

        merge(array, p, q, r);
    }

    public static Integer[] getOutput(Integer[] input) {
        mergeSort(input, 0, input.length - 1);
        return input;
    }

    public static void main(String... args) {
        Integer[] input = {10, 12, 14, 3, 2, 1, 0 , 5};

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(getOutput(input)));
    }
}
