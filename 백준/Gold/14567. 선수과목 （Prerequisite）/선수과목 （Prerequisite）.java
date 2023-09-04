import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] degree;
    static Node[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        degree = new int[N+1];
        node = new Node[N+1];

        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            node[from] = new Node(to, node[from]);
            degree[to]++;
        }
        int[] answer = topology();

        for (int i = 1; i <= N; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static int[] topology() {
        int[] arr = new int[N+1];
        Queue<Integer[]> q = new LinkedList<>();

        for (int i = 1; i < degree.length; i++) {
            if (degree[i] == 0) {
                q.offer(new Integer[] {i, 1});
            }
        }

        while(!q.isEmpty()) {
            Integer[] now = q.poll();
            arr[now[0]] = now[1];

            for(Node temp=node[now[0]]; temp != null; temp = temp.next) {
                if (degree[temp.now] == 1) {
                    q.offer(new Integer[]{temp.now, now[1] + 1});
                }
                degree[temp.now]--;
            }
        }
        return arr;
    }



    static class Node {
        int now;
        Node next;

        public Node(int now, Node next) {
            super();
            this.now = now;
            this.next = next;
        }
    }
}