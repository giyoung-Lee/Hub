import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());

        boolean flag = false;
        for (int i = 0; i < R; i++) {
            int rotate = Integer.parseInt(st.nextToken());

            switch (rotate) {
                case 1:
                    arr = command1(arr.length, arr[0].length);
                    break;

                case 2:
                    arr = command2(arr.length, arr[0].length);
                    break;

                case 3:
                    arr = command3(arr.length, arr[0].length);
                    flag = !flag;
                    break;

                case 4:
                    arr = command4(arr.length, arr[0].length);
                    flag = !flag;
                    break;

                case 5:
                    arr = command5(arr.length, arr[0].length);
                    break;

                case 6:
                    arr = command6(arr.length, arr[0].length);
                    break;
            }

        }

        if (flag) {
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j ++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j ++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] command1(int N, int M) {
        int row = N/2;
        for (int i = 1; i <= row; i ++) {
            for (int j = 0; j < M; j ++) {
                int tmp = arr[row - i][j];
                arr[row - i][j] = arr[row+i-1][j];
                arr[row+i-1][j] = tmp;
            }
        }

        return arr;
    }

    public static int[][] command2(int N, int M) {
        int cal = M/2;
        for (int i = 1; i <= cal; i ++) {
            for (int j = 0; j < N; j ++) {
                int tmp = arr[j][cal - i];
                arr[j][cal - i] = arr[j][cal+i-1];
                arr[j][cal+i-1] = tmp;
            }
        }
        return arr;
    }

    public static int[][] command3(int N, int M) {
        int[][] now = new int[M][N];

        for (int i = 0; i < M; i++) {
            for(int j = N; j > 0; j--) {
                now[i][N-j] = arr[j-1][i];
            }
        }
        return now;
    }

    public static int[][] command4(int N, int M) {
        int[][] now = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = N-1; j >= 0; j--) {
                now[i][j] = arr[j][M-i-1];
            }
        }

        return now;
    }

    public static int[][] command5(int N, int M) {
        int[][] now = new int[N][M];
        int cal = M/2;
        int row = N/2;

        // 2번 영역
        for (int i = 0; i < row; i++) {
            for (int j = cal; j < M; j++) {
                now[i][j] = arr[i][j-cal];
            }
        }

        // 3번 영역
        for (int i = row; i < N; i++) {
            for (int j = cal; j < M; j++) {
                now[i][j] = arr[i-row][j];
            }
        }

        // 4번 영역
        for (int i = row; i < N; i++) {
            for (int j = 0; j < cal; j++) {
                now[i][j] = arr[i][j+cal];
            }
        }

        // 1번 영역
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cal; j++) {
                now[i][j] = arr[i+row][j];
            }
        }

        return now;
    }

    public static int[][] command6(int N, int M) {
        int[][] now = new int[N][M];
        int cal = M/2;
        int row = N/2;

        // 2번 영역
        for (int i = 0; i < row; i++) {
            for (int j = cal; j < M; j++) {
                now[i][j] = arr[i+row][j];
            }
        }

        // 3번 영역
        for (int i = row; i < N; i++) {
            for (int j = cal; j < M; j++) {
                now[i][j] = arr[i][j-cal];
            }
        }

        // 4번 영역
        for (int i = row; i < N; i++) {
            for (int j = 0; j < cal; j++) {
                now[i][j] = arr[i-row][j];
            }
        }

        // 1번 영역
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cal; j++) {
                now[i][j] = arr[i][j+cal];
            }
        }

        return now;
    }
}