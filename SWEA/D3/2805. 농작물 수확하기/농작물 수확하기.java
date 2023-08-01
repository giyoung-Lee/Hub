
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine(); // 개행 문자 소비

        for (int test = 1; test <= T; test++) {
            int N = sc.nextInt();
            sc.nextLine(); // 개행 문자 소비

            // N x N 크기의 배열
            int[][] arr = new int[N][N];

            // 배열에 값을 넣어줌
            for (int i = 0; i < N; i++) {
                String strValue = sc.nextLine();
                for (int j = 0; j < N; j++) { // 인덱스를 0부터 N-1까지 사용
                    char ch = strValue.charAt(j);
                    arr[i][j] = Character.getNumericValue(ch);
                }
            }
            
            // 출력할 총합
            int sum = 0;
            // 가운데 가로 라인
            int num = N/2;
            // 위 아래 라인으로 이동하기 위한 count
            int count = 1;

            // 가장 중앙의 가운데 한줄의 합
            for (int i = 0; i < N; i++) {
                sum += arr[num][i];
            }

            // 가운데 줄을 기점으로, 위 아래줄을 양옆 한칸씩 줄여가면서 값을 더해줌
            while (num >= count) {
                // 윗줄
                int tmp = num-count;
                for (int i = count; i < N-count; i++) {
                    sum += arr[tmp][i];
                }

                // 아랫줄
                int tmp2 = num+count;
                for (int i = count; i < N-count; i++) {
                    sum += arr[tmp2][i];
                }

                count ++;
            }

            System.out.printf("#%d %d\n", test, sum);


        }
    }
}