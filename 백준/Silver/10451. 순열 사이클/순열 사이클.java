import java.util.*;

public class Main {
    /**
     * 백준 10451 순열 사이클
     * https://www.acmicpc.net/problem/10451
     *
     * dfs를 통해 해결할 수 있는 문제입니다.
     * 그래프를 순회하면서 싸이클이 발생하는지 확인하고, 그 수를 출력하는 문제입니다.
     * 
     * 순회를 하다가, 처음 시작정점을 다시 만나게 된다면 싸이클이 하나 완성되었다고 할 수
     * 있겠습니다. 
     *
     * @author 이기영
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int test = 0; test < T; test++) {
            // 순열의 크기. 즉 정점의 개수
            int numVertices = sc.nextInt();

            // 인접리스트 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < numVertices; i++) {
                graph.add(new ArrayList<Integer>());
            }

            for (int i = 0; i < numVertices; i++) {
                int edge = sc.nextInt();
                // 입력된 값에 1을 빼서 0부터 인덱스 사용. 0부터 시작하니까
                graph.get(i).add(edge - 1);
            }

            int result = 0;
            //방문을 확인하기 위한 노드
            boolean[] visited = new boolean[numVertices];
            for (int i = 0; i < numVertices; i++) {
                if (!visited[i]) {
                    result += dfs(graph, i, visited, i);
                }
            }
            System.out.println(result);
        }
    }

    public static int dfs(List<List<Integer>> graph, int currVertex,
                          boolean[] visited, int startVertex) {
        visited[currVertex] = true;

        // 싸이클의 개수. 아마 1을 넘지 못할겁니다.
        int cycleCount = 0;
        for (int nextVertex : graph.get(currVertex)) {
            // 방문하지 않았다면
            if (!visited[nextVertex]) {
                cycleCount += dfs(graph, nextVertex, visited, startVertex);
            } else if (nextVertex == startVertex) {
                cycleCount++; // 사이클 발견
            }
        }

        return cycleCount;
    }
}
