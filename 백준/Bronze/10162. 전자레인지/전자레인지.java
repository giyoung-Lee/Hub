import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력받을 T
		int T = sc.nextInt();
		
		// A : 5분 | B : 1분 | C : 10초
		// 각 시간을 초로 환산해서 초기화, 정답을 셀 카운트
		int A = 300;
		int a_count = 0;
		int B = 60;
		int b_count = 0;
		int C = 10;
		int c_count = 0;
		
		// 최소가 되어야 하므로, 가장 큰 버튼부터 사용
		// A로 나눠 몫을 저장하고 T를 나머지 값으로 갱신
		if (T >= 300) {
			a_count = T/A;
			T %= A;
		}
		
		// B로 나눠 몫을 저장하고 T를 나머지 값으로 갱신
		if (T >= 60) {
			b_count = T/B;
			T %= B;
		}
		
		// C로 나눠 몫을 저장하고 T를 나머지 값으로 갱신
		if (T >= 10) {
			c_count = T/C;
			T %= C;
		}
		
		// T가 0이아니라면, 버튼 3개로 해결할 수없는경우
		if (T != 0) {
			System.out.println(-1);
		} else {	// 아니면 값 출력
			System.out.println(a_count + " " + b_count + " " + c_count);
		}
		
		
	}
}