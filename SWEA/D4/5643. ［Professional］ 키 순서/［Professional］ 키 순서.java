import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            // Initialize the adjacency matrix with a large value
            int max = Integer.MAX_VALUE / 4;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j) {
                        arr[i][j] = 0;
                    } else {
                        arr[i][j] = max;
                    }
                }
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken()) - 1;
                int to = Integer.parseInt(st.nextToken()) - 1;
                arr[from][to] = 1;
            }

            // Floyd-Warshall algorithm optimization
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || arr[i][j] == 1) continue;
                    for (int k = 0; k < N; k++) {
                        if (j == k || i == k) continue;

                        if (arr[j][k] > arr[j][i] + arr[i][k]) {
                            arr[j][k] = arr[j][i] + arr[i][k];
                        }
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean isConnected = true;
                for (int j = 0; j < N; j++) {
                    if (i != j && (arr[i][j] == max && arr[j][i] == max)) {
                        isConnected = false;
                        break;
                    }
                }
                if (isConnected) {
                    count++;
                }
            }

            System.out.println("#" + test + " " + count);
        }
    }
}