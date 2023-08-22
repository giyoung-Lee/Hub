import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	/**
	 * BJ 13023 ABCDE
	 * 
	 * dfs로 풀었습니다.
	 * 인접리스트에 친구들의 정보를 넣고
	 * 친구 0 번부터 N-1번까지 전부 dfs를 실행하는데,
	 * 만약 가던 도중 조건에 맞는 경우가 있다면
	 * 정답을 출력합니다.
	 * 
	 * 메모리 : 25,548 kb
	 * 시간 : 296 ms
	 */

    static int N, M;
    static boolean visited[];
    static ArrayList<Integer>[] graph;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        graph = new ArrayList[N];

        // 그래프 초기화
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
        	// 양방향 그래프이므로, 양쪽에 다 넣어줌
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
            graph[a].add(b);
        }

        for (int i = 0; i < N; i++) {
        	// 탐색결과가 true면 그만 탐색하고 정답 출력
            if(dfs(i, 1)) {
            	System.out.println(1);
            	return;
            }
            visited = new boolean[N];
        }
        // 만약 dfs를 다 돌았는데 true를 받지못했다면 0
        System.out.println(0);
    }

    private static boolean dfs(int i, int count) {
    	// 방문처리
        visited[i] = true;
        // 조건에 맞게되면 true 리턴
        if (count >= 5) {
        	return true;
        }
        
        for (int neighbor : graph[i]) {
            if (!visited[neighbor]) {
            	// 들어갔던 dfs가 true면 다시한번 true리턴
                if(dfs(neighbor, count + 1)) {
                	return true;
                }
                // 방문했다가 나온곳은 다시 false로 바꿔줌
                visited[neighbor] = false;
            }
        }
        // 다 왔다갔다 했지만, 단한번도 true를 못만났다면 false;
        return false;
    }
}