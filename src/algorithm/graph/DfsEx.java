package algorithm.graph;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  음료수 얼려먹기문제
 *  첫번째 줄에 얼음 튼의 세로길이 N과 가로길이 M이 주어진다.
 *  두번재 줄부터 N+1 번째 줄까지 얼음 틀의 형태가 주어진다.
 *  이때 구멍이 뚤려있는 부분은 0, 그렇지 않은 부분은 1 이다.
 *
 *  출력 : 한번째 만들수 있는 아이스크림 갯수를 축력한다.
 */
public class DfsEx {

    /**
     * 001
     * 010
     * 101
     *
     * 3
     */
    public static int[][] graph;
    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nm = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();

        n = nm[0];
        m = nm[1];


        graph = new int[n][m];

        for (int i=0; i<n; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
            graph[i] = input;
        }

        Arrays.asList(graph).stream().forEach(v ->  {
            Arrays.stream(v).forEach(s -> System.out.print(s));
            System.out.println("");
        });

        // graph 전체를 순회하면서 dfs 호출
        int result = 0; // 결과

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dfs(i, j)) {
                    result += 1;
                }
            }
        }

        System.out.println("result : " + result);
    }

    public static boolean dfs(int x, int y) {

        if (x < 0 || x >= n || y < 0  || y >= m) return false;

        if (graph[x][y] == 0) {
            graph[x][y] = 1;
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }

        return false;
    }
}
