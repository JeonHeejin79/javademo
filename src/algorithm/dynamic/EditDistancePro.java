package algorithm.dynamic;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;

/**
 * Given two words word1 and word2
 * find the minimum number of operations required to convert word1 to word2
 *
 * you have the following 3 operations permiited on a word
 * 1. Insert to character
 * 2. Delete to character
 * 3. Replace to character
 *
 * Input : word1 = "horse", word2 = "ros
 *
 * Output : 3
 *
 * horse - > rorse (replace h -> r)
 * rorse -> rose (remove r)
 * rose - > ros (remove 2)
 */
public class EditDistancePro {

    static String[] str;
    static int[][] dp;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] str = scanner.nextLine().split(" ");

        String word1 = str[0];
        String word2 = str[1];

        System.out.println(word1 + " " + word2);
        minDistance(word1, word2);
    }

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // dp[i][j] : word1 의 i까지의 부분문자열을 word2 의 j까지의 문자열로 교체하기 위한 최소 작업 수
        // ex) abc. def  d[1]d[1]  a-> d 1
        dp = new int[len1+1][len2+1];

        // 초기화
        for (int i=0; i<=len1; i++) {
            dp[i][0] = i;
        }
        for (int j=0; j<=len2; j++) {
            dp[0][j] = j;
        }

        // 루프
        for (int i=1; i<= len1; i++) {
            for (int j=1; j<= len2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    System.out.println(word1+".charAt("+(i-1)+") == "+word2+".charAt("+(j-1)+")");
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    System.out.println(word1+".charAt("+(i-1)+") != "+word2+".charAt("+(j-1)+")");
                    System.out.println("Math.min(dp["+(i-1)+"]["+j+"], dp["+i+"]["+(j-1)+"])");
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                Arrays.stream(dp).forEach(v -> {
                    Arrays.stream(v).forEach(System.out::print);
                    System.out.println("");
                });
                System.out.println("-----------------------------");
            }
            System.out.println("=============================");
        }
        // 리턴
        return dp[len1][len2];
    }
}
