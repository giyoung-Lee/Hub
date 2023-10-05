import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	
	static String[] temp_str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int div = N/4;
			
			temp_str = br.readLine().split("");
			
	        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
	            @Override
	            public int compare(String hex1, String hex2) {
	                // 16진수 문자열을 정수로 변환하여 비교합니다.
	                int intValue1 = Integer.parseInt(hex1, 16);
	                int intValue2 = Integer.parseInt(hex2, 16);

	                // 내림차순으로 정렬하려면 역순으로 비교합니다.
	                return Integer.compare(intValue2, intValue1);
	            }
	        });
			
			String[] str = new String[4];
			for(int i = 0; i < div; i++) {
				str = makeString(temp_str, div);
				for(int j=0; j < str.length; j++) {
					set.add(str[j]);
				}
				rotate();
			}
			
			String result = "";
			int count = 0;
			for(String num : set) {
				count++;
				if (count==K) {
					result = num;
				}
			}
			
			System.out.println("#" + test + " " + Integer.parseInt(result, 16));
		}
	}
	
	
	public static String[] makeString(String[] temp_str, int div) {
		int count = 0;
		String[] str = new String[4];
		
		String temp = "";
		for(int i = 0; i < temp_str.length; i++) {
			if (i != 0 && i%div== div-1) {
				temp += temp_str[i];
				str[count] = temp;
				temp = "";
				count ++;
			} else {
				temp += temp_str[i];
			}
		}
		
		for(int i = 0; i < 4; i++) {
		}
		
		return str;
	}
	
	public static void rotate() {
		String first = temp_str[0];
		
		for(int i = 0; i <temp_str.length-1; i++) {
			temp_str[i] = temp_str[i+1];
		}
		
		temp_str[temp_str.length - 1] = first;
		
	}
	
	
}