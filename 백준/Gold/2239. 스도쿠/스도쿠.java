import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr = new int[9][9]; // 9x9 크기의 스도쿠 퍼즐을 저장하는 배열
    static boolean flag; // 스도쿠 퍼즐을 해결했는지 여부를 나타내는 플래그

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 받기 위한 BufferedReader
        StringBuilder sb = new StringBuilder(); // 결과를 저장하고 출력하기 위한 StringBuilder

        // 입력받은 스도쿠 퍼즐을 2D 배열에 저장
        for (int i = 0; i < 9; i++) {
            char[] c = br.readLine().toCharArray(); // 문자열로 한 줄을 입력받아 문자 배열로 변환
            for (int j = 0; j < 9; j++) {
                arr[i][j] = c[j] - '0'; // 문자를 정수로 변환하여 배열에 저장
            }
        }

        // DFS 알고리즘으로 스도쿠 퍼즐을 풀기
        dfs(0);

        // 결과 출력
        for (int[] a : arr) {
            for (int b : a) {
                sb.append(b);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString()); // 결과 출력
    }

    private static void dfs(int d) {
        if (d == 81) { // 모든 칸을 채운 경우
            flag = true; // 스도쿠 퍼즐을 해결했다고 플래그 설정
            return;
        }

        int r = d / 9; // 현재 칸의 행
        int c = d % 9; // 현재 칸의 열

        if (arr[r][c] != 0)
            dfs(d + 1); // 이미 숫자가 채워진 칸이면 다음 칸으로 이동
        else {
            for (int i = 1; i < 10; i++) {
                if (!isValid(r, c, i))
                    continue; // 현재 숫자가 유효하지 않으면 다음 숫자로 시도
                arr[r][c] = i; // 현재 칸에 숫자 채우기
                dfs(d + 1); // 다음 칸으로 이동

                // 종료 조건이 아니라면 더이상 선택할 수가 없다는 뜻 => 백트랙킹
                if (flag)
                    return; // 스도쿠 퍼즐을 해결했으면 종료
                arr[r][c] = 0; // 스도쿠 퍼즐을 해결하지 못했으면 현재 칸을 다시 0으로 초기화
            }
        }
    }

    private static boolean isValid(int r, int c, int n) {
        for (int i = 0; i < 9; i++) {
            if (arr[i][c] == n || arr[r][i] == n)
                return false; // 같은 행 또는 같은 열에 이미 숫자 n이 존재하면 유효하지 않음
        }

        int sr = r / 3 * 3; // 현재 칸이 속한 작은 3x3 정사각형의 행 시작 위치
        int sc = c - c % 3; // 현재 칸이 속한 작은 3x3 정사각형의 열 시작 위치
        for (int row = sr; row < sr + 3; row++) {
            for (int col = sc; col < sc + 3; col++) {
                if (arr[row][col] == n)
                    return false; // 작은 3x3 정사각형 내에 이미 숫자 n이 존재하면 유효하지 않음
            }
        }

        return true; // 모든 조건을 만족하면 숫자 n은 유효함
    }
}