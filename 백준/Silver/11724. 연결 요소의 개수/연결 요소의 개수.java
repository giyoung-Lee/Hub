import java.util.*;

public class Main {
    /**
     * 백준 11724번 연결 요소의 개수
     *  https://www.acmicpc.net/problem/11724
     *  그래프의 연결 요소를 구하는 문제입니다.
     *  dfs, bfs 두가지 방법으로 해결 할 수있는데,
     *  저는 bfs로 풀어봤습니다.
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, m을 입력받음
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 인접리스트 초기화
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<Integer>());
        }

        // 그래프 입력
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        // 방문배열
        int size = list.size();
        boolean[] visited = new boolean[size];
        // 정답
        int result = 0;

        // 탐색 시작.
        for (int i = 1; i < size; i++) {
            if (!visited[i]) {
                bfs(list, i, visited);
                result ++;
            }
        }

        System.out.println(result);
    }

    public static void bfs(List<List<Integer>> list, int start, boolean[] visited){

        // Queue 자료형
        Queue<Integer> q = new LinkedList<>();

        // 시작점은 1로 할거긴한데..
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int currentVertex = q.poll();

            for(int vertex : list.get(currentVertex)) {
                if (!visited[vertex]) {
                    q.offer(vertex);
                    visited[vertex] = true;
                }
            }

        }
    }
}

