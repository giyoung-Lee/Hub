import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    /**
     * BJ 2252 줄세우기
     * 
     * 오늘 배운 위상정렬 문제였습니다만,,,
     * 코드를 이해하는데 시간이 너무 오래 걸렸습니다.
     * 
     */

    static Node[] adjList;
    static int[] inDegree;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjList = new Node[N+1];
        inDegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjList[from] = new Node(to, adjList[from]);
            inDegree[to] ++;
        }
        ArrayList<Integer> sortedList = topologySort();
        if (sortedList.size() == N) {
            for (int num : sortedList) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("circle");
        }
    }

    public static ArrayList<Integer> topologySort() {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();

            arr.add(current);
            for (Node temp=adjList[current]; temp != null; temp = temp.next) {
                if (--inDegree[temp.vertex] == 0) {
                    q.offer(temp.vertex);
                }
            }

        }
        return arr;
    }


    static class Node {
        int vertex;
        Node next;
        public Node(int vertex, Node next) {
            this.vertex = vertex;
            this.next = next;
        }
    }
}