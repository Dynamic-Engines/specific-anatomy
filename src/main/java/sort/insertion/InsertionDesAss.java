import java.util.Arrays;

public class InsertionDesAss {

    public static Integer[] getOutput(Integer[] input) {

        for(int i = 1; i < input.length; i++) {
            int key = input[i];
            int j = i - 1;

            // Changed comparision, same as compareTo
            while(j >= 0 && input[j] < key) {
                input[j + 1] = input[j];
                j = j - 1;
                input[j + 1] = key;
            }
        }

        return input;
    }

    public static void main(String... args) {
        Integer[] input = {10, 12, 14, 3, 2, 1};

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(getOutput(input)));
    }
}