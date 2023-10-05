import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	
	/**
	 * SW 5658 보물상자비밀번호
	 * 
	 * 자동 정렬되는 TreeSet을 이용하여 풀이 하였습니다.
	 * 
	 * 
	 * 메모리 : 22,848 KB
	 * 시간 : 138 ms
	 * 
	 */
	
	static String[] temp_str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			// 각 변의 길이, 회전하는 횟수
			int div = N/4;
			
			// 입력받아서
			temp_str = br.readLine().split("");
			
			// 트리셋
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
			
	        // 총 4개의 변으로 이루어져있으므로
			String[] str = new String[4];
			for(int i = 0; i < div; i++) {
				// 각 변의 길이에 맞게 붙여서 리턴해줌
				str = makeString(temp_str, div);
				for(int j=0; j < str.length; j++) {
					// set에 넣어줌
					set.add(str[j]);
				}
				// 한칸 회전
				rotate();
			}
			
			// 정답
			String result = "";
			int count = 0;
			// k번째가 되면 result에 넣고
			for(String num : set) {
				count++;
				if (count==K) {
					result = num;
				}
			}
			
			// 결과 출력
			System.out.println("#" + test + " " + Integer.parseInt(result, 16));
		}
	}
	
	// div개씩 뜯어서 배열에 저장해주는 메서드
	public static String[] makeString(String[] temp_str, int div) {
		int count = 0;
		String[] str = new String[4];
		
		String temp = "";
		for(int i = 0; i < temp_str.length; i++) {
			// 만약 한 변이 다 채워지면
			if (i != 0 && i%div== div-1) {
				// 일단 한글자 더해주고
				temp += temp_str[i];
				// 넣어주고
				str[count] = temp;
				// temp 초기화
				temp = "";
				count ++;
			} else {
				// 경우가 아니면 한글자 또 더해줌
				temp += temp_str[i];
			}
		}
		
		// 결과 리턴
		return str;
	}
	
	// 회전
	public static void rotate() {
		String first = temp_str[0];
		
		for(int i = 0; i <temp_str.length-1; i++) {
			temp_str[i] = temp_str[i+1];
		}
		
		temp_str[temp_str.length - 1] = first;
		
	}
	
	
}