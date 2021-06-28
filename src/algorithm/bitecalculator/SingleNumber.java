package algorithm.bitecalculator;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Given an array of numbers nums,
 * in which exactly two elements appear only once and
 * all the other elements appear exactly twice
 * Find the two elements that appear only once
 *
 * Input : [1, 2, 1, 3, 2, 5]
 * Output : [3, 5]
 */
public class SingleNumber {
    public static void main(String[] args) {

        // XOR
        // 1. a a b b c d 전부다 XOR = c^d
        // 2. c^d 적어도 한 비트는 1
        // 3. 그 1비트자리에서 c:0 d:1 혹은 그 반대
        // 4. 그 1비트자리를 기준으로 모든 원소를 두 그룹으로 나눌수 있음
        // 5. 각 그룹마다 유일하게 등장하는 원소는 하나

        Scanner scanner = new Scanner(System.in);
        int [] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        singleNumber(nums);
    }

    public static int[] singleNumber(int[] nums) {

        int xor = 0;

        for (int num : nums) {
            System.out.print(xor + "^=" + num + " = ");
            xor ^= num;
            System.out.print(xor +"("+Integer.toBinaryString(xor)+ ") > ");
        }
        System.out.println("");
        int idx = 0;

        for (int i=0; i<32; i++) { // 4비트 만큼 for
            System.out.println((xor>>i) + "(" + Integer.toBinaryString(xor>>i) +")" + " " + ((xor>>i) & 1));
            if (((xor>>i) & 1) == 1) {
                idx = i;
                break;
            }
        }

        int xor1 = 0;
        int xor2 = 0;

        for (int num : nums) {
            System.out.println("("+num + ">>" + idx + ")" + "&" + "1 = " + ((num >> idx) & 1));
            if (((num >> idx) & 1) == 1) {
                xor1 ^= num; // 2
                System.out.println("num : " + num + ", xor1 : " + xor1);
            } else {
                xor2 ^= num; // 1
                System.out.println("num : " + num + ", xor2 : " + xor2);
            }
            System.out.println("------------------------------------------------------");
        }


        return null;
    }
}
