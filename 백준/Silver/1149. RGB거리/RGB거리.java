import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	/**
	 * BJ 1149 RGB거리
	 * 
	 * DP로 풀이했습니다.
	 * 각 자리마다 올 수 있는 최소값을 갱신해주고,
	 * 마지막에 비교하여 출력하였습니다.
	 * 
	 */
	
	static int[][] arr;
	static int[][] dp;
	static int[] R, G, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// 원본배열과 dp 배열
		arr = new int[N][3];
		dp = new int[N][3];
		
		// 원본 배열 입력받고
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// 복사한 뒤에
		dp = arr.clone();
		
		// 각 자리에 올수있는 최소값으로 갱신해줌
		for(int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]); 
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]); 
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]); 
		}
		
		// 3개 비교해서
		int temp = Math.min(dp[N-1][0], dp[N-1][1]);
		temp = Math.min(dp[N-1][2], temp);
		
		// 출력
		System.out.println(temp);
	}
}