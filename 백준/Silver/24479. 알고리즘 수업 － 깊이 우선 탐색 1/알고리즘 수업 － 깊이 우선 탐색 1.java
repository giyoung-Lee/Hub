import java.util.*;

public class Main {
    static int[] visitedOrder;
    static int idx = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 그래프 정점의 수
        int numVertices = sc.nextInt();

        // 간선의 개수
        int numEdges = sc.nextInt();

        // 시작 정점
        int startVertex = sc.nextInt();

        // 인접리스트로 그래프를 구현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= numVertices; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 그래프에 간선 추가
        for (int i = 0; i < numEdges; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            addEdge(graph, src, dest);
        }

        // 그래프의 인접한 정점들을 오름차순으로 정렬
        for (int i = 0; i <= numVertices; i++) {
            Collections.sort(graph.get(i));
        }

        // dfs 에서 사용할 방문했는지 체크하기 위한 배열
        boolean[] visited = new boolean[numVertices+1];

        visitedOrder = new int[numVertices+1];

        dfs(graph, startVertex, visited);
        for (int i = 1; i <= numVertices; i++) {
            System.out.println(visitedOrder[i]);
        }
    }

    // 그래프에 양방향 간선 추가하는 함수
    public static void addEdge(List<List<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    public static void dfs(List<List<Integer>> graph, int currVertex, boolean[] visited) {
        // 방문처리
        visited[currVertex] = true;
        visitedOrder[currVertex] = idx++;

        // 탐색
        List<Integer> neighbors = graph.get(currVertex);
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}