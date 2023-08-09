import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int n;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for(int test = 1; test <= t; test++) {
			st = new StringTokenizer(br.readLine());
		
			n = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = 0;
			int answer = Integer.MAX_VALUE;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					int tmp = bfs(i, j); 
					if (max < tmp) {
						answer = arr[i][j];
						max = tmp;
						
					} else if (max == tmp) {
						if (answer > arr[i][j]) {
							answer = arr[i][j];							
						}
						max = tmp;
					}
				}
			}
			System.out.printf("#%d %d %d\n", test, answer, max);
		}
	}
	
	public static int bfs(int x, int y) {
		int count = 1;
		boolean[][] visited = new boolean[n][n];
		
		visited[x][y] = true;
		Queue<coordinate> q = new LinkedList<>();
		q.offer(new coordinate(x, y));
		
		while(!q.isEmpty()) {
			coordinate now = q.poll();
			
			for (int i = 0; i <4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
					continue;
				}
				
				if (arr[now.x][now.y] +1 == arr[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new coordinate(nx, ny));
					count ++;					
				}
			}
		}
		return count;
	}
}

class coordinate {
	int x;
	int y;
	
	public coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}	
}



