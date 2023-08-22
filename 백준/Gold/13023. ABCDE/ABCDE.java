import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean visited[];
    static ArrayList<Integer>[] graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
            graph[a].add(b);
        }

        for (int i = 0; i < N; i++) {
            if(dfs(i, 1)) {
            	System.out.println(1);
            	return;
            }
            visited = new boolean[N];
        }
        System.out.println(0);
    }

    private static boolean dfs(int i, int count) {
        visited[i] = true;
        if (count >= 5) {
        	return true;
        }
        
        for (int neighbor : graph[i]) {
            if (!visited[neighbor]) {
                if(dfs(neighbor, count + 1)) {
                	return true;
                }
                visited[neighbor] = false;
            }
        }
        return false;
    }
}