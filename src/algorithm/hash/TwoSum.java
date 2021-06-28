package algorithm.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given an array of integers, return indics of the two numbers
 * such that they add up to a specific target
 * You may assume taht each input would have exactly one solution.
 * and you may not use the same element twice
 *
 * Give num = [2, 7, 11, 15], target 9
 * Because nums[0] + nims[1] = 2 + 7 = 9
 * return [0, 1]
 */
public class TwoSum {

    public static Map<Integer, Integer> map = new HashMap<>();

    public static int prev;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int target = scan.nextInt();
        scan.nextLine();
        int[] nums = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        executeTwoSum(nums, target);
    }

    public static void executeTwoSum(int[] nums, int target) {

        for (int i=0; i<nums.length; i++) {
            twoSumRecur(nums[i], i, target);
        }
    }

    public static void twoSumRecur(int cur, int index, int target) {
        System.out.println(cur + " " + index + " " + target);
        map.put(cur, index);
        Arrays.asList(map).stream().forEach(v -> System.out.print(v.toString() + " "));
        System.out.println();

        if (map.containsKey(target-cur)) {
            Integer rsIndex1 = map.get(cur);
            Integer rsIndex2 = map.get(target-cur);
            System.out.println("rs : " + rsIndex2 + " "  + rsIndex1);
            return;
        }
    }
}
