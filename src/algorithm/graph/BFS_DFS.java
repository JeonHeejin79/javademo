package algorithm.graph;

import java.util.*;

public class BFS_DFS {

    /*
    input
    4 5 1
    1 2
    1 3
    1 4
    2 4
    3 4

    output
    1 2 4 3
    1 2 3 4
    */
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] nms = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = nms[0];
        int m = nms[1];
        int s = nms[2];

        // 1. init data
        visited = new boolean[n+1];

        for (int i=0; i<=n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 2. input data
        // []
        // [1, 2]
        // [1, 3]
        // [1, 4]
        // [2, 4]
        //
        for (int i=1; i<=m; i++) {
            int[] values = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int node1 = values[0];
            int node2 = values[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }

        exeucte_DFS(s);

        System.out.println();
        // 2. init data
        visited = new boolean[n + 1];
        exuecte_BFS(s);

    }
    // visited = [true, false, false, false, false]
    public static void exeucte_DFS(int node) {
        // 1. 방문처리
        System.out.print(node + " ");
        visited[node] = true;
        Collections.sort(graph.get(node));

        for (int i=0; i<graph.get(node).size(); i++) {
            if (!visited[graph.get(node).get(i)]) {
                exeucte_DFS(graph.get(node).get(i));
            }
        }
    }

    public static void exuecte_BFS(int node) {

        Queue<Integer> queue = new LinkedList<Integer>();

        // 1. 시작노드 방문처리
        visited[node] = true;
        // 2. 시작노드 큐를사용해서 노드를 를 큐에집어넣은다
        queue.offer(node);
        System.out.print(node + " ");

        while(!queue.isEmpty()) {
            int a = queue.poll();

            for (int i=0; i< graph.get(a).size(); i++) {
                if (!visited[graph.get(a).get(i)]) {
                    queue.offer(graph.get(a).get(i));
                    System.out.print(graph.get(a).get(i) + " ");
                    visited[graph.get(a).get(i)] = true;
                }
            }
        }
    }

}
