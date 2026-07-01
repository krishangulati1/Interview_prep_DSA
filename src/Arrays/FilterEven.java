package Arrays;

import java.util.Arrays;

class FilterEven{

    private static int[] filterEven(int []arr) {

        return Arrays.stream(arr).filter(ar -> ar%2 == 0).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(filterEven(arr)));
    }
}
