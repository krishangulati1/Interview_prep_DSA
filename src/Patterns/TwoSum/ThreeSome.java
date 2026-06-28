package Patterns.TwoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSome {

    List<List<Integer>> checkForThreeSome(int [] test) {
        Arrays.sort(test);
        List<List<Integer>> results = new ArrayList<>();
        int n = test.length;

        for(int i=0; i<n-2; i++)  {
            if(i > 0 && test[i] == test[i-1]) continue;
            if(test[i] > 0) break;

            int left = i + 1;
            int right = n - 1;

            while(left < right) {
                int currentSum = test[i] + test[left] + test[right];
                if(currentSum < 0) {
                    left++;
                } else if(currentSum > 0) {
                    right--;
                } else {
                    results.add(List.of(test[i], test[left], test[right]));
                    while (left < right && test[left] == test[left + 1]) left++;
                    while (left < right && test[right] == test[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }
        return results;
    }

    public static void main(String [] arg) {
        //return pairs of 3 who's result is 0
        int [] test = new int [] {-4, -2, -1, 0, 1, 2, 3, 4};
        ThreeSome sum = new ThreeSome();
        var results = sum.checkForThreeSome(test);
        System.out.println(results);
    }
}
