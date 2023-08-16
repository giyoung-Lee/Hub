import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }

        solve(0, 0, N);

    }

    public static void solve(int x, int y, int size) {
        int sum = 0;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                sum += arr[i][j];
            }
        }

        if (sum == 0) {
            System.out.print(0);
        } else if (sum == size * size) {
            System.out.print(1);
        } else {
            int half = size / 2;
            System.out.print("(");
            solve(x, y, half);

            solve(x, y + half, half);

            solve(x + half, y, half);

            solve(x + half, y + half, half);
            System.out.print(")");
        }

    }
}
