import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		int max = Integer.MAX_VALUE/4;
		for(int test=1; test<=T; test++) {
			
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i==j) {
						arr[i][j] = 0;
					} else {
						// 적당히 큰값
						arr[i][j] = max;
					}
				}
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 1;
			}
			
    		for(int i = 0; i < N; i++) {
    			for(int j = 0; j < N; j++) {
    				if (i==j) continue;
    				for(int k = 0; k < N; k++) {
    					if (j == k || i == k) continue;
    					
    					arr[j][k] = Math.min(arr[j][i] + arr[i][k], arr[j][k]);
    				}
    			}
    		}
    		
			int[] result = new int[N];
			
    		for(int i = 0; i < N; i++) {
    			for (int j = 0; j < N; j++) {
    				if(arr[i][j] != max || arr[j][i] != max) {
    					result[i] ++;
    				}
    			}
    		}
    		int count = 0;
    		for(int i = 0; i < N; i++) {
    			if (result[i] == N) count++;
    		}
    		
    		System.out.println("#"+test + " "+count);
		}
	}
}