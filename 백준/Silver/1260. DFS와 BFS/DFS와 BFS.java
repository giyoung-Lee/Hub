import java.util.*;

public class Main {
    /**
     * 백준 1260 DFS와 BFS
     * https://www.acmicpc.net/problem/1260
     * DFS 와 BFS의 기초를 다질 수 있는 좋은 문제입니다.
     *
     * 너비우선탐색은 Queue를 사용하여 구하고,
     * 깊이우선탐색은 재귀적 호출을 통해 풀 수 있습니다.
     *
     * 문제였던 점은 작은 점부터 방문할 수 있게
     * 인접한 정점들을 정렬 해야 한다는 것이었습니다.
     *
     * 기초를 다질 수 있는 좋은 문제라고 생각합니다.
     */

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

        // dfs 에서 사용할 방문했는지 체크하기 위한 배열
        boolean[] visited = new boolean[numVertices+1];
        dfs(graph, startVertex, visited);
        System.out.println();
        bfs(graph, startVertex);


    }

    // 그래프에 양방향 간선 추가하는 함수
    public static void addEdge(List<List<Integer>> graph, int src, int dest) {
        graph.get(src).add(dest);
        graph.get(dest).add(src);
    }

    // BFS 함수
    public static void bfs(List<List<Integer>> graph, int startVertex) {
        int numVertices = graph.size();
        boolean[] visited = new boolean[numVertices]; // 정점 방문 여부를 저장하는 배열
        Queue<Integer> queue = new LinkedList<>(); // 방문할 정점들을 저장하는 큐

        // 시작 정점을 방문했다고 표시
        visited[startVertex] = true;
        // 시작 정점을 큐에 추가
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            // 큐에서 정점을 하나 꺼냄
            int currVertex = queue.poll();
            System.out.print(currVertex + " ");

            // 작은 점부터 방문할 수 있게 인접한 정점들을 정렬
            List<Integer> neighbors = graph.get(currVertex);
            Collections.sort(neighbors);

            // 현재 정점과 인접한 정점들을 차례로 방문
            for (int neighbor : neighbors) {
                if (!visited[neighbor]) {
                    // 방문한 정점 표시
                    visited[neighbor] = true;
                    // 방문할 정점 큐에 추가
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void dfs(List<List<Integer>> graph, int currVertex, boolean[] visited) {
        // 방문처리
        visited[currVertex] = true;
        System.out.print(currVertex + " ");

        // 작은 점부터 방문할 수 있게 인접한 정점들을 정렬
        List<Integer> neighbors = graph.get(currVertex);
        Collections.sort(neighbors);

        // 탐색
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
}
