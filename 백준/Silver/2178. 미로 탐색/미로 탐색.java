import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean exit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		visited = new boolean[N][M];
		exit = false;
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = br.readLine().split("");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st[j]);
			}
		}
		
		bfs(0, 0);
		System.out.println(arr[N-1][M-1]);
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {x, y});
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			
			for (int i = 0; i < 4; i ++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				} 
				
				if (nx == N && ny == M) {
					exit = true;
					break;
				}
				
				if (arr[nx][ny] != 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					arr[nx][ny] = arr[now[0]][now[1]] + 1;
					q.offer(new int[] {nx, ny});
				}
			}
			if (exit) {
				break;				
			}
		}
	}
}