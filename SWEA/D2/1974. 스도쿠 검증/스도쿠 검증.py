import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Set;

class Solution
{
        /**
     * <pre>
     *     SWEA 스도쿠 검증
     *     가로, 세로, 격자 한칸이 전부 스도쿠 규칙에 맞는지 확인하는 문제입니다.
     *     더 좋은 방법이 있겠지만, 9*9로 크기가 고정된 스도쿠이므로,
     *     존재하는 가로줄(9) + 존재하는 세로줄(9) + 각 격자칸(9)만 비교하면 되겠습니다.
     *
     *     Hashset 자료형을 이용하여, 각경우를 비교할때 Hashset에 추가합니다.
     *     한줄 또는 한칸을 비교했다면, 그 크기가 9인지 비교하면 된다고 생각했습니다.
     *
     *     오늘 Hashset을 알아보면서 알게되었는데, 굳이 비교할 필요없이
     *     값을 add 하려고 할때, 만약 이미 존재하는 값이라면, 자체적으로 false를 리턴하게 됩니다.
     *     그렇기 때문에 set.add 를 if문 안에 넣고, false일때 false값을 리턴해주면
     *     굳이 크기가 9인지 비교할 필요가 없어져 절차가 하나 줄어들게됩니다.
     *
     *     마지막 정답을 출력하기전에
     *     경우에 따라 0또는 1을 출력하면 되겠습니다.
     *
     * </pre>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수

        for (int t = 1; t <= T; t++) {
            int[][] puzzle = new int[9][9]; // 스도쿠 퍼즐 배열 초기화

            // 스도쿠 퍼즐 입력 받기
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    puzzle[i][j] = sc.nextInt();
                }
            }

            int answer = check(puzzle) ? 1 : 0; // 스도쿠 퍼즐 유효성 검사

            // 결과 출력
            System.out.println("#" + t + " " + answer);
        }
    }

    // 스도쿠 퍼즐 유효성 검사 함수
    public static boolean check(int[][] puzzle) {

        // 가로 방향 검사
        for (int i = 0; i < 9; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int num = puzzle[i][j];
                if (!set.add(num)) {
                    return false;
                }
            }
        }

        // 세로 방향 검사
        for (int j = 0; j < 9; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                int num = puzzle[i][j];
                if (!set.add(num)) {
                    return false;
                }
            }
        }

        // 3x3 작은 격자 검사
        for (int startRow = 0; startRow < 9; startRow += 3) {
            for (int startCol = 0; startCol < 9; startCol += 3) {
                Set<Integer> set = new HashSet<>();
                for (int i = startRow; i < startRow + 3; i++) {
                    for (int j = startCol; j < startCol + 3; j++) {
                        int num = puzzle[i][j];
                        if (!set.add(num)) {
                            return false;
                        }
                    }
                }
            }
        }

        // 모든 검사를 통과하면 true
        return true;
    }
}