import java.util.Scanner;

public class Main {
	
	/** 
	 * 백준 15649 N과 M(1)
	 * https://www.acmicpc.net/problem/15649
	 * 
	 * 재귀함수를 통해 문제를 해결하였습니다.
	 * 오늘 수업에서 배운 내용과 너무 찰떡이라 도움이 되었습니다.
	 * 
	 */
	
	// 변수 선언
	static int M;
	static int N;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N 입력받기
		N = sc.nextInt();
		// M 입력받기
		M = sc.nextInt();
		
		// 수열을 담을 배열을 초기화
		arr = new int[M];
		
		// 담긴 배열이 방문했는지 확인
		boolean[] ischecked = new boolean[N];
		
		// 시작
		permutation(0, ischecked);
		
		
	}
	
	public static void permutation(int count, boolean[] ischecked) {
		// 기저조건
		if (count == M) {
			for (int i = 0; i < count; i ++) {
				System.out.print(arr[i]+ " ");				
			}
			System.out.println();
		} else { // 아닐때
			for (int i = 0; i < N; i++) {
				// 방문했을경우 continue;
				if (ischecked[i]) {
					continue;
				}
				// 배열에 담음
				arr[count] = i+1;
				// 방문처리
				ischecked[i] = true;
				
				// count를 증가하여 다시 순회
				permutation(count+1, ischecked);
				
				// 기저조건을 만나 출력을 했을것이니, false로 돌려줌
				ischecked[i] = false;
			}
		}
		
	}
}