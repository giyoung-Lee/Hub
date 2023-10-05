import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };
	static int[][] arr;
	static int[][] temp;
	static int max = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = 1;

		while (true) {
			N = Integer.parseInt(br.readLine());
			// 종료조건
			if(N == 0) {
				break;
			}
			
			// 입력받을 arr 배열과 정답을 갱신할 temp 배열
			arr = new int[N][N];
			temp = new int[N][N];
			
			// arr 입력받고
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// temp를 max값으로 초기화 해줌
			for (int i = 0; i < N; i++) {
				Arrays.fill(temp[i], max);
			}
			
			// queue에 들어가는 int[] 들이 첫번째 값을 기준으로 오름차순 정렬
			PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					return a[0] - b[0];
				}
			});
			
			// 초기값은 시작 위치
			temp[0][0] = arr[0][0];
			// queue에 넣어주고
			pq.add(new int[] {temp[0][0], 0, 0});
			
			while(!pq.isEmpty()) {
				// 꺼내서 비교. 비용, x좌표, y좌표 순으로 들어감
				int[] now = pq.poll();
				int cost = now[0];
				int x = now[1];
				int y = now[2];
				
				// 마지막까지 이동을했다면 종료
				if(x == N-1 && y == N-1) {
					break;
				}
				
				// 4방탐색
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					// 범위를 벗어나거나
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
					// 현재비용 + 이동할 좌표의 도둑루피 비용 >= 이동할 칸에 있는 비용
					// 즉, 더 작은 값이 먼저 들어가있다면 해당 연산은 시행하지않음
					if(cost + arr[nx][ny] >= temp[nx][ny]) continue;
					
					// 최소값을 갱신하고
					temp[nx][ny] = cost + arr[nx][ny];
					// pq에 넣어줌
					pq.add(new int[] {temp[nx][ny], nx, ny});
				}
			}
			
			// 결과 출력
			System.out.println("Problem "+testcase+": "+temp[N-1][N-1]);
			testcase++;
		}
	}
}