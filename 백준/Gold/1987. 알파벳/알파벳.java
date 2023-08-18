import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int X, Y, answer;
	static boolean[] visited;
	static char[][] arr;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().split(" ");
		X = Integer.parseInt(st[0]);
		Y = Integer.parseInt(st[1]);
		visited = new boolean[26];
		arr = new char[X][Y];
		answer = 1;
		
		for (int i = 0; i < X; i++) {
			String stline = br.readLine();
			for (int j = 0; j < Y; j++) {
				arr[i][j] = stline.charAt(j);
			}
		}
		
		
		visited[arr[0][0] - 65] = true;
		dfs(0, 0, 1);

		

		System.out.println(answer);
		
	}
	
	private static void dfs(int x, int y, int count) {
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx < 0 || nx >= X || ny < 0 || ny >= Y) {
				continue;
			}
			
			char alp = arr[nx][ny];
			
			if (!visited[alp-65]) {
				visited[alp-65] = true;
				dfs(nx, ny, count+1);
				visited[alp-65] = false;
			}
			
		}
		answer = Math.max(count, answer);
	}
}