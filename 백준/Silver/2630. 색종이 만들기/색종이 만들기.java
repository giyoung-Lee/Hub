import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] arr;
	static int white, green;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		white = 0;
		green = 0;
		
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		sol(0, 0, N);
		System.out.println(white);
		System.out.println(green);
		
	}
	
	private static void sol (int sc, int sr, int size) {
		int sum = 0;
		for (int i = sc; i < sc + size; i++) {
			for(int j = sr; j < sr + size; j++) {
				sum += arr[i][j];
			}
		}
		
		if (sum == 0) {
			white++;
		} else if (sum == size*size) {
			green++;
		} else {
			int half = size/2;
			sol(sc, sr, half);
			sol(sc+half, sr, half);
			sol(sc, sr+half, half);
			sol(sc+half, sr+half, half);
		}
	}
}