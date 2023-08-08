import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	// 좌 상 우 하
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	
	public static void main(String[] args) throws IOException{
		// 버퍼
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N, M, R,
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// 담을 배열
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()); 
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// R만큼 회전
		for(int i = 0; i < R; i++) {
			rotate(N, M);			
		}
		
		// 출력
		for(int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
		
	}
	
	public static void rotate(int N, int M) {
		// 회전하는 사각형의 수
		int count = Math.min(N, M) / 2;
		
		for (int i = 0; i < count; i ++) {
			// 시작지점 x y
			int x = i;
			int y = i;
			
			// 초기값 저장
			int tmp = arr[x][y];
			
			int index = 0;
			// 한줄 탐색
			while (index < 4) {
				int nx = x + dx[index];
				int ny = y + dy[index];
				
				// 만약 범위 안이라면
				if(nx < N-i && ny < M-i && nx >= i && ny >= i) {
					arr[x][y] = arr[nx][ny];
					x = nx;
					y = ny;
				} else { // 범위 밖이라면 한줄 안쪽으로 이동
					index ++;
				}
			}
			// 초기값을 한칸 밀린곳에 저장
			arr[i+1][i] = tmp;
		}
	}
}





