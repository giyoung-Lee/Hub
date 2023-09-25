import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static int N, M;
	public static int[][] arr;
	public static List<int[]> zero;
	public static int[] index_arr;
	public static int max;
	public static int[] isSelcted;
	public static boolean[] check;
	public static boolean[][] visited;
	public static int[] dx = { 1, -1, 0, 0 };
	public static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		index_arr = new int[N * M];
		check = new boolean[N * M];
		isSelcted = new int[3];
		int count = 0;
		max = 0;
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				index_arr[count] = count++;
			}
		}
		comb(0);

		System.out.println(max);
	}

	public static void comb(int cnt) {
		if (cnt == 3) {
			int[][] temp_arr = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp_arr[i][j] = arr[i][j];
				}
			}

			for (int k = 0; k < 3; k++) {
				temp_arr[isSelcted[k] / M][isSelcted[k] % M] = 1;
			}

			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp_arr[i][j] == 2 && !visited[i][j]) {
						temp_arr = bfs((i * M + j), temp_arr);
					}
				}
			}

			int zero_cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (temp_arr[i][j] == 0) {
						zero_cnt++;
					}
				}
			}

			max = Math.max(max, zero_cnt);

			return;
		}

		for (int i = 0; i < N * M; i++) {
			if (check[i])
				continue;

			if (arr[i / M][i % M] == 1 || arr[i / M][i % M] == 2) {
				check[i] = true;
			} else {
				check[i] = true;
				isSelcted[cnt] = i;
				comb(cnt + 1);
				check[i] = false;
			}
		}
	}

	public static int[][] bfs(int count, int[][] temp_arr) {
		int x = count / M;
		int y = count % M;
		visited[x][y] = true;

		Queue<Integer[]> q = new ArrayDeque<>();
		q.add(new Integer[] { x, y });

		while (!q.isEmpty()) {
			Integer[] temp = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
					continue;
				}

				if (temp_arr[nx][ny] == 0 && !visited[nx][ny]) {
					temp_arr[nx][ny] = 2;
					visited[nx][ny] = true;
					q.offer(new Integer[] {nx, ny});
				}
			}
		}

		return temp_arr;

	}
}