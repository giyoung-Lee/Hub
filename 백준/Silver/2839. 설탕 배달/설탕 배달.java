import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] arr = new int[N+6];
		for(int i = 0; i < N+1; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
		
		arr[3] = 1;
		arr[5] = 1;
		
		for(int i=6; i < N+6; i++) {
			int min = Math.min(arr[i-3], arr[i-5]);
			if (min != Integer.MAX_VALUE) {
				arr[i] = min + 1;
			}
		}
		
		if (arr[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(arr[N]);
		}
		
	}
}
