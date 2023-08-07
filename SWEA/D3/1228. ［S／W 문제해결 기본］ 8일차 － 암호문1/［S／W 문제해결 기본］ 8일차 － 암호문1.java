import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<String> password;
        for (int t = 1; t <= 10; t++) {
            password = new LinkedList<>();
            br.readLine(); // 원본 암호문의 길이, 의미없음
            st = new StringTokenizer(br.readLine(), " ");// 원본 암호문
            while (st.hasMoreTokens()) {
                password.add(st.nextToken());
            }

            br.readLine(); // 명령어의 개수, 의미없음
            st = new StringTokenizer(br.readLine(), " "); // 명령어, 의미없음
            int x, y;
            while (st.hasMoreTokens()) {
                st.nextToken(); // I
                x = Integer.parseInt(st.nextToken()); // x
                y = Integer.parseInt(st.nextToken()); // y
                for (int i = 0; i < y; i++) {
                    password.add(x++, st.nextToken()); // 원문에 추가
                }
            }

            // 테스트 케이스
            System.out.print("#" + t);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + password.get(i));
            }
            System.out.println();
        }

    }
}