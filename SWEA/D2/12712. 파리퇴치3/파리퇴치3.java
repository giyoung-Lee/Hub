import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


class Solution
{
	public static void main(String args[]) throws Exception
	{
	   /**
     * <pre>
     *     SWEA 파리퇴치3
     *     + 모양과 X 모양의 스프레이 분사를 통해 파리를잡는데,
     *     가장 많이 잡을 수 있는 경우를 출력해야 합니다.
     *
     *     해당 좌표에서
     *     + 모양은 (-1, 0), (0, 1), (1, 0), (0, -1) 값을 더해주면 구할 수 있고,
     *     X 모양은 (1, 1), (-1, 1), (-1, -1), (1, -1) 값을 더해주면 구할 수 있습니다.
     *
     *     여기서 X 와 + 모양은 M의 세기로 분사하여 그 크기가 커진다는 특징이 있습니다.
     *     그래서 1 부터 M 까지의 값을 곱해주며 M의 크기만큼 전부 더해줘야 합니다.
     *
     *     아이디어를 생각하는것은 그렇게 어렵지 않았으나, for문이 여러개 들어가서
     *     구현하는데 시간이 조금 걸렸습니다.
     *
     * </pre>
     */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		            // N 과 M을 입력받습니다.
            int N = sc.nextInt();
            int M = sc.nextInt();

            // arr에 값을 입력받습니다.
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            List<Integer> catchList = new ArrayList<>();
            int answer = 0;

            // + 모양
            int[] dpcol = {-1, 0, 1, 0};
            int[] dprow = {0, 1, 0, -1};

            // x 모양
            int[] dxcol = {1, -1, -1, 1};
            int[] dxrow = {1, 1, -1, -1};

            // 강도 M의 + 형
            for (int col = 0; col < N; col++) {
                for (int row = 0; row < N; row++) {
                    int fly = arr[col][row];
                    for (int m = 1; m < M; m++) {
                        for (int v = 0; v < 4; v++) {
                            int ncol = col + dpcol[v] * m;
                            int nrow = row + dprow[v] * m;
                            if (ncol >= 0 && ncol < N && nrow >= 0 && nrow < N) {
                                fly += arr[ncol][nrow];
                            }
                        }
                    }
                    catchList.add(fly);
                }
            }

            // 강도 M의 X 형
            for (int col = 0; col < N; col++) {
                for (int row = 0; row < N; row++) {
                    int fly = arr[col][row];
                    for (int m = 1; m < M; m++) {
                        for (int v = 0; v < 4; v++) {
                            int ncol = col + dxcol[v] * m;
                            int nrow = row + dxrow[v] * m;
                            if (ncol >= 0 && ncol < N && nrow >= 0 && nrow < N) {
                                fly += arr[ncol][nrow];
                            }
                        }
                    }
                    catchList.add(fly);
                }
            }

            // 잡은 파리의 수들 중 가장 큰값
            for (int i : catchList) {
                if (i > answer) {
                    answer = i;
                }
            }

            System.out.println("#" + test_case + " " + answer);
		}
	}
}