import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, zero, minus, plus;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        zero = 0;
        minus = 0;
        plus = 0;
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);

    }

    public static void solve(int x, int y, int size) {
        int sum0 = 0;   // 0
        int sum1 = 0;   // 1
        int sum_1 = 0;  // -1
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] == 1) {
                    sum1 ++;
                } else if (arr[i][j] == 0) {
                    sum0 ++;
                } else if (arr[i][j] == -1) {
                    sum_1 ++;
                }
            }
        }

        if (sum0 == size * size) {
            zero++;
        } else if (sum1 == size * size) {
            plus++;
        } else if (sum_1 == size * size) {
            minus++;
        } else {
            int newSize = size / 3;
            solve(x, y, newSize);
            solve(x, y + newSize, newSize);
            solve(x, y + 2 * newSize, newSize);
            solve(x + newSize, y, newSize);
            solve(x + newSize, y + newSize, newSize);
            solve(x + newSize, y + 2 * newSize, newSize);
            solve(x + 2 * newSize, y, newSize);
            solve(x + 2 * newSize, y + newSize, newSize);
            solve(x + 2 * newSize, y + 2 * newSize, newSize);
        }
    }

}