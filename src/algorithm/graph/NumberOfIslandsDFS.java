package algorithm.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 200 .Number of Islands
 *
 * Givem a 2d gid map  of '1' s (land) and '0's (water)
 * , count the number is islands.
 *
 * An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically.
 * You may assume all four deges of the grid are all surrounded by water
 */
public class NumberOfIslandsDFS {

    static int[] visited;
    static int[][] list;
    static int n;
    static int m;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] nm = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        n = nm[0];
        m = nm[1];

        // init
        list = new int[n][m];

        for (int i=0; i<n; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

            list[i] = arr;
        }

        int rsCnt = 0;
        for (int i=0; i<list.length; i++) {

            for (int j=0; j<list[i].length; j++) {
                if (executeIslandDFS(i, j)) {
                    rsCnt += 1;
                }
            }
        }
        System.out.println("rsCnt : " + rsCnt);
    }

    public static boolean executeIslandDFS(int x, int y) {

        if (x < 0 || x >= n || y < 0 || y >= m) return false;

        if (list[x][y] == 1){

            list[x][y] = 0;
            executeIslandDFS(x+1, y);
            executeIslandDFS(x, y+1);
            executeIslandDFS(x-1, y);
            executeIslandDFS(x, y-1);

            return true;
        }

        return false;
    }


}
