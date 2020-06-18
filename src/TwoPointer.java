public class TwoPointer {
    // sum two number from any where in the array but they must be equal that value using two pointer technique.
    public static void sumTwoNumbers(int[] nums, int value) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int sum;
        while (p1 <= p2) {
            sum = nums[p1] + nums[p2];
            if (sum > value) {
                p2--;
            } else if (sum < value) {
                p1++;
            } else {
                System.out.println(nums[p1] + " in index " + p1 + "\t" + nums[p2] + " in index " + p2);
                break;
            }
        }
    }

    //find maximum result of summation to fixed range of indices.
    public static int MaxNumberFixedSlidingWindow(int[] nums, int fixed) {
        int p1 = 0;
        int n = nums.length;
        int p2 = fixed;
        int Max = Integer.MIN_VALUE;
        while (p2 <= n) {
            int sum = 0;
            for (int i = p1; i < p2; i++) {
                sum += nums[i];
            }
            if (sum > Max) {
                Max = sum;
            }
            p2++;
            p1++;
        }
        return Max;
    }

    //find the max range of numbers that not exceeds that value that print the start to end numbers.
    public static void NumberVariableSlidingWindow(int[] nums, int value) {
        int p1, p2;
        p1 = p2 = 0;
        int sum = 0;
        while (sum < value) {
            sum += nums[p2++];
            if (sum > value) {
                while (sum > value) {
                    sum -= nums[p1++];
                }
            }
            if (sum == value) {
                System.out.println("from number " + nums[p1] + " with index " + p1 + " to number " + nums[p2 - 1] + " with index " + p2 + " are equal " + sum);
                break;
            }
        }
    }

     //find the max range of numbers that not exceeds that value that print each step for summation and abstraction from sum.
    public static int NumberVariableSlidingWindowWithSteps(int[] nums, int value) {
        int p1, p2, ans = 0;
        p1 = p2 = 0;
        int sum = 0;
        int n = nums.length;
        while (p1 < n) {
            while (p2 < n && sum + nums[p2] <= value) {
                sum += nums[p2++];
                System.out.println("summation " + sum);
            }
            ans = Math.max(ans, sum);
            sum -= nums[p1++];
            System.out.println("abstract " + sum);
        }
        return ans;
    }
    
    //Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        int last = n - 1;
        int first = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                arr[last--] = nums[i];
            } else {
                arr[first++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
        System.out.print("[");
        for (int i = 0; i < n - 1; i++) {
            System.out.print(nums[i] + ",");
        }
        System.out.print(nums[n - 1] + "]");
    }    
    
    /*find the maximum profit. You may complete as many transactions 
    as you like (i.e., buy one and sell one share of the stock multiple times).*/
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        int profit = 0;
        int i = 0;
        int j = 1;
        while (j < length) {
            if (prices[i] >= prices[j]) {
                i++;
                j++;
                if (j == length) {
                    return profit;
                }
            } else {
                while ((j < length - 1) && prices[j] < prices[j + 1]) {
                    if (j != length - 1) {
                        j++;
                    }
                }
                profit += prices[j] - prices[i];
                i = ++j;
                j++;
            }

        }
        return profit;
    }
}
