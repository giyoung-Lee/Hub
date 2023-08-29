import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int[][] dp;
	static int[] R, G, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		R = new int[N];
		G = new int[N];
		B = new int[N];
		
		arr = new int[N][3];
		dp = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp = arr.clone();
		
		for(int i = 1; i < N; i++) {
			dp[i][0] += Math.min(dp[i-1][1], dp[i-1][2]); 
			dp[i][1] += Math.min(dp[i-1][0], dp[i-1][2]); 
			dp[i][2] += Math.min(dp[i-1][0], dp[i-1][1]); 
		}
		int temp = Math.min(dp[N-1][0], dp[N-1][1]);
		temp = Math.min(dp[N-1][2], temp);
		
		System.out.println(temp);
	}
}