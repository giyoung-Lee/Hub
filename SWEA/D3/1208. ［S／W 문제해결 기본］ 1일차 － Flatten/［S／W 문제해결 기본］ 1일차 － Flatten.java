import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

class Solution
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int dump = sc.nextInt();
			int[] arr = new int[100];
			
			for (int i = 0; i <100; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			for (int i = 0; i < dump; i++) {
				arr[0] ++;
				arr[99] --;
				
				Arrays.sort(arr);
			}
			
			int max = 0;
			int min = 100;
			
			for (int i = 0; i < 100; i++) {
				if (arr[i] > max) {
					max = arr[i];
				}
				
				if (arr[i] < min) {
					min = arr[i];
				}
			}
			
			System.out.printf("#%d %d\n", test_case, (max-min));
		}
	}
}