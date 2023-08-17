import java.util.Scanner;

public class Solution {
	static int N;
	static position[] arr, temp;
	static int com_x, com_y, home_x, home_y;
	static int answer;
	static boolean[] visited;
	
	static class position {
		int x;
		int y;
		public position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			N = sc.nextInt();
			arr = new position[N];
			visited = new boolean[N];
			temp = new position[N];
			
			com_x = sc.nextInt();
			com_y = sc.nextInt();
			
			home_x = sc.nextInt();
			home_y = sc.nextInt();
			
			answer = Integer.MAX_VALUE;
			
			for (int i = 0; i < N; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[i] = new position(x, y);
			}
			comb(0);
			System.out.println("#"+ test + " " + answer);
		}
		
	}
	
	// 출력 확인용
	public static void print() {
		for(int i = 0; i < N; i++) {
			System.out.print("(" + temp[i].x + " "+ temp[i].y + ")" + " ");
		}
	}
	
	
	public static void comb(int count) {
		
		if (count == N) {
			// 확인용
//			print();
//			System.out.println();
			int sum = 0;
			sum += Math.abs(com_x - temp[0].x) + Math.abs(com_y - temp[0].y);
			
			for (int i = 1; i < count; i++) {
				sum += Math.abs(temp[i-1].x - temp[i].x) + Math.abs(temp[i-1].y - temp[i].y);
			}
			sum += Math.abs(home_x - temp[N-1].x) + Math.abs(home_y - temp[N-1].y);
			if (sum < answer) {
				answer = sum;
			}
			
			
		} else {
			for(int i = 0; i < N; i++) {
				if (visited[i]) {
					continue;
				}
				visited[i] = true;
				temp[count] = arr[i];
				comb(count+1);
				visited[i] = false;

			}
		}
	}
}