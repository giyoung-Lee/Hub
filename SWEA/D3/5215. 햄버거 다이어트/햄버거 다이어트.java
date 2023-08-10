import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class val {
	int num;
	int cal;
	
	public val(int num, int cal) {
		super();
		this.num = num;
		this.cal = cal;
	}
	
}

public class Solution {
	
	static int N, TARGET, max;
	static int[] input;
	static boolean[] isSelected;
	static List<val> list;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int test = 1; test <= T; test++) {
			N = sc.nextInt();
			TARGET = sc.nextInt();

			isSelected = new boolean[N];
			max = 0;
			
			list = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				int num = sc.nextInt();
				int cal = sc.nextInt();
				val tmp = new val(num, cal);
				list.add(tmp);
			}
			
			generateSubset(0, 0, 0);
			
			System.out.printf("#%d %d\n", test, max);
		}
		

	}
	
	private static void generateSubset(int cnt, int sum, int selectedCount) { 
		// cnt : 직전까지 고려된 원소의 개수, 현재 처리할 원소의 인덱스
		// sum : 직전까지 선택된 원소들의 합
		
		if (cnt == N) { // 부분집합 완성
			
			// 부분집합의 구성원소의 합을 구하고 sum과 비교

			
			if (selectedCount > 0 && sum <= TARGET) {
				int tmp = 0;
				for(int i = 0; i < N; i ++) {
					if (isSelected[i]) {
						tmp = tmp + list.get(i).num;
					}
				}
				if (tmp > max) {
					max = tmp;
				}
				
			}
			return;

		}

		isSelected[cnt] = true;
		generateSubset(cnt+1, sum+list.get(cnt).cal, selectedCount+1);
		isSelected[cnt] = false;
		generateSubset(cnt+1, sum, selectedCount);
	}
}
