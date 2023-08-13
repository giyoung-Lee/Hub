import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int n = 100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int test = 1; test <= 10; test++) {
            int T = Integer.parseInt(br.readLine());
            arr = new int[100][100];


            int y = 0;

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if (arr[i][j] == 2) {
                        y = j;
                    }
                }
            }


            System.out.println("#"+ test + " " + solve(y));

        }
    }

    public static int solve(int y) {
        int x = n - 1;
        while (x-- != 0) {
            boolean check = false;

            if (y + 1 < n && arr[x][y + 1] == 1) {
                check = true;
                while (y + 1 < n && arr[x][y + 1] == 1) y++;
            }

            if (!check) {
                while ((y - 1 >= 0) && arr[x][y - 1] == 1) y--;
            }
        }
        return y;
    }

}