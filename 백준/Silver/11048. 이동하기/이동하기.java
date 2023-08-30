import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j ++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i == 0 && j == 0) continue;
				
				if(i == 0 && j != 0) {
					arr[i][j] += arr[i][j-1]; 
				} else if (i != 0 && j == 0) {
					arr[i][j] += arr[i-1][j]; 					
				} else {
					int temp = Math.max(arr[i-1][j], arr[i][j-1]);
					temp = Math.max(temp, arr[i-1][j-1]);
					
					arr[i][j] += temp;
				}
			}
		}
		
		System.out.println(arr[N-1][M-1]);
	}
}