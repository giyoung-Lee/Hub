import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int N, start;
    static List<Node> arr;
    static int max;
    static boolean[] visited;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 10;
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            arr = new ArrayList<>();
            max = 0;
            visited = new boolean[101];
            count = new int[101];


            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                arr.add(new Node(from, to, 0));

            }

            bfs(start);
            int result = 0;
            for (Node temp : arr) {
                if (temp.count == max) {
                    result = Math.max(result, temp.to);
                }
            }

            System.out.println("#" + test + " " + result);


        }
    }

    public static void bfs(int start) {
        Queue<Node> q = new ArrayDeque<>();
        for (Node temp : arr) {
            if (temp.from == start) {
                temp.count = 1;
                q.add(temp);
            }
        }

        visited[start] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (Node node : arr) {
                if (now.to == node.from && !visited[node.to]) {
                    node.count = now.count + 1;

                    visited[node.to] = true;

                    q.offer(node);
                }
            }
        }

        for (Node temp : arr) {
            max = Math.max(temp.count, max);
        }
    }

    static class Node {
        int from, to, count;

        public Node(int from, int to, int count) {
            this.from = from;
            this.to = to;
            this.count = count;
        }

    }
}