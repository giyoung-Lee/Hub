import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		dp = new int[1000001];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		
		for(int i = 5; i <= 1000000; i++) {
			
			int temp = 0;
			if (i%3 == 0 && i%2 != 0) {
				temp = Math.min(dp[i/3], dp[i-1]);
			} else if (i%2 == 0 && i%3 != 0) {
				temp = Math.min(dp[i/2], dp[i-1]);
			} else if (i%2 == 0 && i%3 == 0){
				temp = Math.min(dp[i/3], dp[i/2]);
				temp = Math.min(temp, dp[i-1]);
			} else {
				temp = dp[i-1];
			}
			
			dp[i] = temp+1;
			
			if(i == N) {
				break;
			}
		}
		
		System.out.println(dp[N]);
		
	}
}