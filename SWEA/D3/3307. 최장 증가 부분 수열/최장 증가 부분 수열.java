import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			
			for(int i = 0; i < N; i ++) {
				arr[i] = Integer.parseInt(st.nextToken());
				dp[i] = 1;
			}
			int max = 0;
			for(int i = 1; i < N; i ++) {
				for(int j = 0; j < i; j++) {
					if(arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j]+1);
						max = Math.max(max, dp[i]);
					}
				}
			}
			
			System.out.println("#"+test+" "+max);
		}
	}
}
