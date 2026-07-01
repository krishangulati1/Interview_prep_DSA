package Patterns.PrefixSuffix;

import java.util.Arrays;
import java.util.Collections;

public class ProductExceptSelf {

    private static int [] findProduct(int[] inputs) {
        int i=0, temp=1;
        int n = inputs.length;
        int [] results = new int[n];

        for(i=0;i<n;i++) {
            results[i] = temp;
            temp *= inputs[i];
        }
        temp=1;
        for (i=n-1;i>=0;i--) {
            results[i] *= temp;
            temp *=inputs[i];
        }

        return results;
    }


    public static void main(String[] args) {
        int[][] inputs = {
                {1, 2, 3, 4},
                {5, -3, 1, 2},
                {2, 2, 2, 0},
                {0, 0, 0, 0},
                {-1, -2, -4}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.printf("%d.\t Array: %s%n", i + 1, Arrays.toString(inputs[i]));
            System.out.printf("%n\t List of products: %s%n", Arrays.toString(findProduct(inputs[i])));
            System.out.println('-' + String.join("", Collections.nCopies(70, "-")) + '\n');
        }
    }
}
