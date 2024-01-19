package languageSugar;

import java.util.Arrays;

public class Sugar_Stream {
    public static void main(String[] args) {
        int []array = {1,2,2,3,4,5,6,7,8,9};

        int sum = Arrays.stream(array).sum();

        // Save the distinct elements to a new array
        int[] distinctArray = Arrays.stream(array).distinct().toArray();
        int value = Arrays.stream(array).max().getAsInt();
        int minValue = Arrays.stream(array).min().getAsInt();
        System.out.println(value);
        System.out.println(minValue);
    }
}
