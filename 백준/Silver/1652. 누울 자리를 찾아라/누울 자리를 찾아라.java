import java.util.Scanner;

public class Main {
    /**
     * 백준 1665 누울 자리를 찾아라
     * https://www.acmicpc.net/problem/1652
     *
     * 문자열 처리를 해서 푸는 구현 문제입니다.
     * 월말 평가를 생각해서 한번 풀어봤습니다...
     *
     *
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine(); // 개행 문자 처리

        // 방의 구조를 저장하는 2차원 char 배열 선언 및 초기화
        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            room[i] = line.toCharArray(); // 문자열을 char 배열로 변환하여 저장
        }

        // 가로로 누울 수 있는 자리 개수를 세는 변수
        int rowCount = 0;

        // 세로로 누울 수 있는 자리 개수를 세는 변수
        int colCount = 0;

        // 가로로 누울 수 있는 자리 개수 구하기
        for (int i = 0; i < N; i++) {
            int emptycount = 0; // 연속된 빈 칸 개수를 저장하는 변수
            for (int j = 0; j < N; j++) {
                if (room[i][j] == '.') {
                    emptycount++; // 빈 칸일 경우, 연속된 빈 칸 개수 증가
                } else {
                    // 벽이나 짐을 만난 경우, 연속된 빈 칸 개수 확인하여 가로로 누울 수 있는 자리인지 판단
                    if (emptycount >= 2) {
                        rowCount++; // 가로로 누울 수 있는 자리 개수 증가
                    }
                    emptycount = 0; // 연속된 빈 칸 개수 초기화
                }
            }
            // 한 행이 끝났을 때, 연속된 빈 칸 개수 확인하여 가로로 누울 수 있는 자리인지 판단
            if (emptycount >= 2) {
                rowCount++; // 가로로 누울 수 있는 자리 개수 증가
            }
        }

        // 세로로 누울 수 있는 자리 개수 구하기
        for (int j = 0; j < N; j++) {
            int emptycount = 0; // 연속된 빈 칸 개수를 저장하는 변수
            for (int i = 0; i < N; i++) {
                if (room[i][j] == '.') {
                    emptycount++; // 빈 칸일 경우, 연속된 빈 칸 개수 증가
                } else {
                    // 벽이나 짐을 만난 경우, 연속된 빈 칸 개수 확인하여 세로로 누울 수 있는 자리인지 판단
                    if (emptycount >= 2) {
                        colCount++; // 세로로 누울 수 있는 자리 개수 증가
                    }
                    emptycount = 0; // 연속된 빈 칸 개수 초기화
                }
            }
            // 한 열이 끝났을 때, 연속된 빈 칸 개수 확인하여 세로로 누울 수 있는 자리인지 판단
            if (emptycount >= 2) {
                colCount++; // 세로로 누울 수 있는 자리 개수 증가
            }
        }

        // 가로로 누울 수 있는 자리와 세로로 누울 수 있는 자리 개수 출력
        System.out.println(rowCount + " " + colCount);
        sc.close();
    }

}
