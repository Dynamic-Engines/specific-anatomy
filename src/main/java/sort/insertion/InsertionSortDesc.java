import java.util.Arrays;

public class InsertionSortDesc {

    // Input
    private static Integer[] input = {5, 2, 4, 6, 1, 3};

    // Sorting Logic
    private static Integer[] sort(Integer[] input) {
        for(int index = 1; index < input.length; index++) {
            System.out.println("-------------------------------------------");
            System.out.println("Array " + Arrays.toString(input));
            System.out.println("Triggring new itteration for index: "+ index);
            
            Integer key = input[index];
            Integer pointer = index - 1;
            System.out.println("current key: " + key + " current index: "+ index+" and pointer:" + pointer);

            while(pointer >= 0 && input[pointer] > key) {
                System.out.println("Saving " + input[pointer] + "at index" + pointer);
                input[pointer + 1] = input[pointer];
                
                System.out.println("decreasing pointer from " + pointer + " to " + (pointer - 1));
                pointer = pointer - 1;

                System.out.println("Saving " + key + "at index " + (pointer + 1));
                input[pointer + 1] = key;
            }
        }
        return input;
    }

    // Main Call
    public static void main(String[] args) {
        System.out.println("Triggring Operation: Sort, Type: Insertion");

        String output = Arrays.toString(sort(input));
        
        System.out.println("Output: "+ output);
    }
    
}