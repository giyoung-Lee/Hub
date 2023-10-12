import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		// 필드 초기화
		// 계산하기 편하게 1칸씩 띄워서 사용할 예정. 0을더하면 0이므로
		int[][] map = new int[N+1][N+1];
		
		// 누적시킬 정답 초기화
		// 마찬가지로 계산하기 편하게 1칸 띄워줌
		long[][][] arr = new long[N+1][N+1][3];
		
		// 필드를 입력받고
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기값(시작위치 1)
		arr[1][2][0] = 1;
		
		// 1, 2 열은 갈 수 있는 경우가없으므로, j는 3부터 시작함
		for(int i = 1; i<= N; i++) {
			for (int j = 3; j<= N; j++) {
				// 못가는 벽을 만났을경우 continue
				if(map[i][j] == 1) continue;
				
				// 가로의값. 이전위치의 가로와 대각선 값을 더해줌
				arr[i][j][0] = arr[i][j-1][0] + arr[i][j-1][2];
				
				// 세로값. 이전위치의 세로와 대각선 값을 더해줌
				arr[i][j][1] = arr[i-1][j][1] + arr[i-1][j][2];
				
				// 대각선의 값. 가로 세로 대각선 값을 전부 더해줌.
				// 가는길에 벽이 있으면 안되므로, 예외 확인
				if(map[i-1][j] != 1 && map[i][j-1] != 1) {
					arr[i][j][2] = arr[i-1][j-1][0] + arr[i-1][j-1][1] + arr[i-1][j-1][2];
				}
			}
		}
		
		// N,N 위치에서 모든 경우의 수 를 더하면 정답.
		System.out.println(arr[N][N][0]+arr[N][N][1]+arr[N][N][2]);
	}
}