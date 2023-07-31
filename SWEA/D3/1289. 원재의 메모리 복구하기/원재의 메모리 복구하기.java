import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();    // testcase 입력
        
        
        for(int t = 1; t <= test; t++) {
            // 문자열 입력받음
            String s = sc.next();
            
            
            // 비교할 문자열을 넣을 배열
            int[] a = new int[s.length()];
            
            // 다 0으로 초기화
            for(int i = 0; i < s.length(); i++) {
                a[i] = s.charAt(i) - '0';
            }
            
            int cnt = a[0];

            // 이전값과 다를때마다 count ++
            for(int i = 1; i < a.length; i++) {
                if(a[i] != a[i-1])
                    cnt++;
            }

            System.out.println("#" + t + " " + cnt);
        }
    }
}