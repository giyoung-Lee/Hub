import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    /**
     * <pre>
     *     SWEA 숫자 배열 회전
     *     한 배열을 90도 회전 총 3번하면 됩니다.
     *
     *
     * </pre>
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            int n = sc.nextInt();

            int[][] board = new int[n][n];
            int[][] b90 = new int[n][n];
            int[][] b180 = new int[n][n];
            int[][] b270 = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            // borad를 90 회전
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b90[i][j] = board[n - 1 - j][i];
                }
            }

            // b90을 90 회전
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b180[i][j] = b90[n - 1 - j][i];
                }
            }

            // b180을 90 회전
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    b270[i][j] = b180[n - 1 - j][i];
                }
            }

            System.out.println("#" + t);
            // 각 회전한 배열을 한줄씩 출력
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(b90[i][j]);
                }
                System.out.print(" ");

                for (int j = 0; j < n; j++) {
                    System.out.print(b180[i][j]);
                }

                System.out.print(" ");
                for (int j = 0; j < n; j++) {
                    System.out.print(b270[i][j]);
                }

                System.out.println();
            }
        }
    }
}