import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int N;
	static String[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new String[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = temp[j];
			}
		}
		
		int count1 = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, arr[i][j]);
					count1 ++;
				}
			}
		}
		
		int count2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j].equals("R")) {
					arr[i][j] = "G";
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(i, j, arr[i][j]);
					count2 ++;
				}
			}
		}
		
		System.out.println(count1 + " " + count2);
		
	}
	
	private static void bfs(int x, int y, String color) {
		Queue<position> q = new ArrayDeque<>();
		q.offer(new position(x, y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			position temp = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N || !arr[nx][ny].equals(color)) {
					continue;
				}
				
				if (!visited[nx][ny]) {
					q.offer(new position(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	
	
	static class position {
		int x;
		int y;
		public position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}