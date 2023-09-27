import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    	
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int test = 1; test <= T; test++) {
    		st = new StringTokenizer(br.readLine());
    		
    		int N = Integer.parseInt(st.nextToken());
    		int[][] arr = new int[N][N];
    		
    		for(int i = 0; i < N; i++) {
    			for(int j = 0; j < N; j++) {
    				
    				int temp = Integer.parseInt(st.nextToken());
    				
    				if (i==j) {
    					temp = 0;
    				} else if (temp == 0){
    					temp = 10000000;
    				}
    				arr[i][j] = temp;
    			}
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
    		
    		int[] answer = new int[N];
    		int result = Integer.MAX_VALUE;
    		for (int i = 0; i < N; i++) {
    			for (int j = 0; j < N; j++) {
    				answer[i] += arr[i][j];
    			}
    			if (result >= answer[i]) {
    				result = answer[i];
    			}
    		}
    		System.out.println("#" + test + " " + result);
    	}
	}
}