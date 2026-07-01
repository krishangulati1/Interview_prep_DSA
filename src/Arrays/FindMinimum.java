package Arrays;

public class FindMinimum {

    public static int findMin(int[] nums) {
        int min = nums[0];

        for(int num : nums) {
            if(min > num) {
                min = num;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1, 4, 1, 5, 9, 2, 6};
        System.out.println("Min: " + findMin(nums)); // 1
    }
}
