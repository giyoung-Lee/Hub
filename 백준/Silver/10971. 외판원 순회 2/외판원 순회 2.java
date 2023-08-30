import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[][] arr;
	static int[] numbers;
	static boolean isSelected[];
	static int min;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		numbers = new int[N+1];
		isSelected = new boolean[N];
		min = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		per(0);
		System.out.println(min);
		
	}
	
	private static void per(int count) {
		if (count == N) {
			numbers[numbers.length-1] = numbers[0];
			int temp = 0;
			for(int i = 0; i < N; i++) {
				if(arr[numbers[i]][numbers[i+1]] == 0) return;
				temp += arr[numbers[i]][numbers[i+1]];
			}
			
			min = Math.min(temp, min);			
		}
		
		for (int i = 0; i < N; i++) {
			if (isSelected[i]) continue;
			numbers[count] = i;
			isSelected[i] = true;
			per(count+1);
			isSelected[i] = false;
		}
	}
	
}