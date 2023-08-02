import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // 계산하기 쉽게 0 번 인덱스는 0으로
        int[][] arr = new int[n + 1][n + 1];

        // 1, 1부터 입력받음
        for (int i = 1; i <= n; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(row[j - 1]);
            }
        }

        // 가로 누적합
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                arr[i][j] = arr[i][j - 1] + arr[i][j];
            }
        }

        // 세로 누적합
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= n; j++) {
                arr[j][i] = arr[j - 1][i] + arr[j][i];
            }
        }

        for (int test = 0; test < m; test++) {
            // 시작 x,y 끝 x,y를 입력받음
            String[] x_y = br.readLine().split(" ");
            int start_x = Integer.parseInt(x_y[0]);
            int start_y = Integer.parseInt(x_y[1]);
            int end_x = Integer.parseInt(x_y[2]);
            int end_y = Integer.parseInt(x_y[3]);

            int result = arr[start_x - 1][end_y]
                    + arr[end_x][start_y - 1]
                    - arr[start_x - 1][start_y - 1];

            result = arr[end_x][end_y] - result;

            System.out.println(result);
        }
    }
}
