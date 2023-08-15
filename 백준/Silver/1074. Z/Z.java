import java.util.Scanner;

public class Main {
    static int N, r, c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();   // 배열의 크기 지수를 입력받습니다.
        r = sc.nextInt();   // 찾고자 하는 행 번호를 입력받습니다.
        c = sc.nextInt();   // 찾고자 하는 열 번호를 입력받습니다.

        // 배열의 크기를 2^N으로 계산합니다.
        int size = (int) Math.pow(2, N);
        // 순회하면서 값을 찾는 함수를 호출하고 결과를 저장합니다.
        int answer = solve(0, 0, size);

        System.out.println(answer); // 결과를 출력합니다.
    }

    public static int solve(int nr, int nc, int size) {
        // 기저 조건: 배열의 크기가 1일 때
        if (size == 1) {
            return 0;   // 값을 찾지 못한 경우 0을 반환합니다.
        }

        // 배열을 4개의 구역으로 나누어 찾고자 하는 위치를 판별합니다.
        if (r < nr + size / 2 && c < nc + size / 2) {
            return solve(nr, nc, size / 2);  // 좌상단 영역으로 이동하여 재귀 호출합니다.
        } else if (r < nr + size / 2 && c < nc + size) {
            // 우상단 영역으로 이동하여 재귀 호출하고, 값 계산 시 이전 영역의 크기를 더합니다.
            return solve(nr, nc + size / 2, size / 2) + (int) Math.pow(size / 2, 2);
        } else if (r < nr + size && c < nc + size / 2) {
            // 좌하단 영역으로 이동하여 재귀 호출하고, 값 계산 시 이전 영역의 크기의 2배를 더합니다.
            return solve(nr + size / 2, nc, size / 2) + (int) Math.pow(size / 2, 2) * 2;
        } else {
            // 우하단 영역으로 이동하여 재귀 호출하고, 값 계산 시 이전 영역의 크기의 3배를 더합니다.
            return solve(nr + size / 2, nc + size / 2, size / 2) + (int) Math.pow(size / 2, 2) * 3;
        }
    }
}
