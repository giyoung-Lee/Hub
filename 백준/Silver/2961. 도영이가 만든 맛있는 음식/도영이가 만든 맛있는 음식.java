import java.util.Scanner;

public class Main {
	static int[][] arr;
	static int n, answer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		answer = Integer.MAX_VALUE;
		n = sc.nextInt();
		arr = new int[n][2];
		
		for (int i = 0; i <n; i++) {
			arr[i][0] = sc.nextInt();	// 신맛
			arr[i][1] = sc.nextInt();	// 쓴맛
		}
		
		generate(0, 0, 1, 0);
		System.out.println(answer);
		
	}
	
	private static void generate(int idx, int count, int s, int b) {
		
		if (idx == n) {
			if (count > 0) {
				answer = Math.min(answer, Math.abs(s - b));
			}
			return;
		}
		
		generate(idx+1, count+1, s * arr[idx][0], b + arr[idx][1]);
		generate(idx+1, count, s, b);		
	}
	
}
