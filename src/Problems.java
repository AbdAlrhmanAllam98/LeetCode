
import java.util.Arrays;

public class Problems {
    //return the number that exist once time.

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i == (nums.length - 1)) {
                    return nums[i];
                } else if (nums[i] == nums[i + 1]) {
                    i++;
                } else {
                    return nums[i];
                }
            }
        }
        return Integer.MIN_VALUE;
    }
    
    //find the maximum sub array of natural numbers.
    public static int maxSubArray(int[] nums) {
        int Length = nums.length;
        int sum = 0, Max = -1000;
        for (int i = 0; i < Length; i++) {
            sum += nums[i];
            if (Max < sum) {
                Max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return Max;
    }
//if you have array and you need to count the element when the element+1 is also in that array,regardless the duplicates
    public static int countElements(int[] arr) {
        int Count = 0, countEqual = 1, length = arr.length, increment = 0, flag = 0;
        Arrays.sort(arr);
        for (int i = 0; i < length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                countEqual++;
                flag = arr[i];
            }
            increment = arr[i]+1;

            if (increment == arr[i + 1] && arr[i] == flag) {
                Count += countEqual;
                countEqual = 1;
            } else if (increment == arr[i + 1]) {
                Count++;
            }
            if (flag != arr[i + 1]) {
                countEqual = 1;
            }
        }

        return Count;
    }
    /*A happy number is a number defined by the following process: Starting with any positive integer, 
    replace the number by the sum of the squares of its digits,
    and repeat the process until the number equals 1 (where it will stay), 
    or it loops endlessly in a cycle which does not include 1. 
    Those numbers for which this process ends in 1 are happy numbers.
    */
    public static int Count = 0;
    public static boolean isHappy(int n) {
        Count++;
        if (Count < 20) {
            if (n == 1) {
                System.out.println("Number of Iteration to reach to 1 is "+Count);
                return true;
            }
            int temp = n;

            int oneNumber, sum = 0;

            while (temp != 0) {

                oneNumber = temp % 10;

                sum += (oneNumber * oneNumber);

                temp = temp / 10;

            }
            return isHappy(sum);
        }
        return false;
    }
}
