
import java.util.*;

public class ArraysMain {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("what do you want to do?\n"
                + "1- Obtain the only Non repeated number\n"
                + "2- Obtain sum of two number that equal to specific Value\n"
                + "3- Find Maximum Value from Fixed Range\n"
                + "4- Find Maximum Range that not Exceeds Value\n"
                + "5- Count Elements when the element+1 is also in that array,regardless the duplicates\n"
                + "6- Happy Number\n"
                + "7- Relay All zeros in the end of the array\n"
                + "8- Find Maximum Profit for any market");
        int choice = in.nextInt();
        if (choice == 6) {
            System.out.println("Enter The Number ");
            int num = in.nextInt();
            System.out.println(Problems.isHappy(num));
        } else {
            System.out.println("Enter the size of Array: ");
            int size = in.nextInt();
            int[] arr = new int[size];
            System.out.println("Enter the Elements of Array: ");
            for (int i = 0; i < size; i++) {
                arr[i] = in.nextInt();
                switch (choice) {
                    case 1: {
                        System.out.println("The Non Repeated Number is " + Problems.singleNumber(arr));
                        break;
                    }
                    case 2: {
                        System.out.println("Enter The Value: ");
                        int value = in.nextInt();
                        TwoPointer.sumTwoNumbers(arr, value);
                        break;
                    }
                    case 3: {
                        System.out.println("Enter The Fixed Size: ");
                        int fixedSize = in.nextInt();
                        System.out.println(TwoPointer.MaxNumberFixedSlidingWindow(arr, fixedSize));
                        break;
                    }
                    case 4: {
                        System.out.println("IF you want to show steps click 2,if not click 1");
                        choice = in.nextInt();
                        System.out.println("Enter The Value: ");
                        int value = in.nextInt();
                        if (choice == 1) {
                            TwoPointer.NumberVariableSlidingWindow(arr, value);
                        } else {
                            System.out.println(TwoPointer.NumberVariableSlidingWindowWithSteps(arr, value));
                        }
                        break;
                    }
                    case 7: {
                        TwoPointer.moveZeroes(arr);
                        break;
                    }
                    case 8:
                    {
                        System.out.println(TwoPointer.maxProfit(arr));
                        break;
                    }
                    default:
                        System.out.println("unknown Input");
                        break;
                }
            }
            
            /*String[] str = {"Allam", "AbdAlrhman", "Kamal"};
            Integer[] arr0 = {1, 2, 3, 4, 5};
            SortArray.sort(str);
            SortArray.sort(arr0);*/
           
        }
    }
}
