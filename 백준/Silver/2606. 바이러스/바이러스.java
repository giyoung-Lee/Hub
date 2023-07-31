import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            graph[x].add(y);
            graph[y].add(x);
        }

        int result = bfs(graph, 1);
        System.out.println(result);
    }

    public static int bfs(ArrayList<Integer>[] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for (int nextPos : graph[current]) {
                if (!visited[nextPos]) {
                    queue.add(nextPos);
                    visited[nextPos] = true;
                }
            }
        }

        return count - 1; // 1번 컴퓨터 빼주기
    }
}
