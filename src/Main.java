import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nms = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nms[0]; // 노드의 갯수
        int m = nms[1]; // 간선의 갯수
        int s = nms[2]; // 시작노드

        // 방문 데이터 초기화
        visited = new boolean[n+1];
        // 그래프 데이터 초기화
        for (int i=0; i<=n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 데이터 입력받기
        /**
         * input
         * graph = [
         *  [],
         *  [2, 3, 8],
         *  [1, 7],
         *  [1, 4, 5],
         *  [3, 5],
         *  [3, 4],
         *  [7],
         *  [2, 6, 8],
         *  [1, 7]
         * ]
         */
        for (int i=1; i<=n; i++) {
            int[] nodeVals = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=0; j < nodeVals.length; j++) {
                graph.get(i).add(nodeVals[j]);
            }
        }

        execute_DFS(graph, s);

        // result = 1-> 2-> 7-> 6-> 8-> 3-> 4-> 5
    }

    // dfs 수행
    public static void execute_DFS(ArrayList<ArrayList<Integer>> graph, int node) {

        System.out.print(node + " ");
        // 방문처리실행
        visited[node] = true;

        // 인접리스트 오른차순정렬후 작은것부터 탐색
        Collections.sort(graph.get(node));

        // 노드 인접 리스트 탐색
        for (int i=0; i<graph.get(node).size(); i++) {
            int val = graph.get(node).get(i);
            // 방문했는지 확인후 안한 노드만 dfs 실행
            if (!visited[val]) {
                execute_DFS(graph, val);
            }
        }
    }

}
