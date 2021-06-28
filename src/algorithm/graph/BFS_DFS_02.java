package algorithm.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS_02 {
    // 방문 리스트
    public static boolean[] visited_dfs;
    public static boolean[] visited_bfs;

    // graph
    public static ArrayList<ArrayList<Integer>> graph_dfs = new ArrayList<ArrayList<Integer>>();
    public static ArrayList<ArrayList<Integer>> graph_bfs = new ArrayList<ArrayList<Integer>>();

    // 그래프
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int[] nms  = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = 8; // 노드의 갯수
        // int m = nms[1]; // 간선의 갯수
        int s = 1; // 시작노드

        /**
         * input
         */
        int[][] graphData = {
                {},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}
        };

        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph_dfs.add(new ArrayList<Integer>());
        }

        for (int i = 1; i <= n; i++) {
            // int[] nodeVals = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=0; j<graphData[i].length; j++) {
                graph_dfs.get(i).add(graphData[i][j]);
            }
        }

        // 데이터 초기화
        visited_dfs = new boolean[n+1];

        execute_DFS(graph_dfs, s);
        System.out.println();


        // 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph_bfs.add(new ArrayList<Integer>());
        }
        /**
         * input
         */
        for (int i = 1; i <= n; i++) {
            // int[] nodeVals = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j=0; j<graphData[i].length; j++) {
                graph_bfs.get(i).add(graphData[i][j]);
            }
        }

        // 데이터 초기화
        visited_bfs = new boolean[n+1];
        execute_BFS(graph_bfs, s);
        System.out.println("");
        // 결과 1-> 2-> 3-> 8-> 7-> 4-> 5-> 6
    }

    // dfs 수행
    public static void execute_DFS(ArrayList<ArrayList<Integer>> graph, int node) {

        System.out.print(node + " ");
        // 방문처리실행
        visited_dfs[node] = true;

        // 인접리스트 오른차순정렬후 작은것부터 탐색
        // Collections.sort(graph.get(node));

        // 노드 인접 리스트 탐색
        for (int i=0; i<graph.get(node).size(); i++) {
            int val = graph.get(node).get(i);
            // 방문했는지 확인후 안한 노드만 dfs 실행
            if (!visited_dfs[val]) {
                execute_DFS(graph, val);
            }
        }
    }

    // bfs 수행
    public static void execute_BFS(ArrayList<ArrayList<Integer>> graph, int node) {

        Queue<Integer> q = new LinkedList<>();
        // 첫번째 노드를 큐에넣고 방문처리한다.
        q.offer(node);
        visited_bfs[node] = true;
        System.out.print(node + " ");

        // 큐가 빌 떄까지 반복하면서 원소를 뽑음
        while (!q.isEmpty()) {
            // 1. 큐에 있는 원소를 꺼낸다.
            int x = q.poll();

            // 2. 큐에서 꺼낸 원소의 인접리스트를 차례대로 방문처리 됐는지 확인한다.
            for (int i=0; i<graph.get(x).size(); i++) {
                int val = graph.get(x).get(i);
                // 3. 방문처리 안된것만 큐에 넣고 방문처리한다.
                if (!visited_bfs[val]) {
                    System.out.print(val + " ");
                    q.offer(val);
                    visited_bfs[val]  = true;
                }
            }
        }
    }
}
