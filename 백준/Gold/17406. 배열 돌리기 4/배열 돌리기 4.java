import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static Data[] cals;
    // 시계방향 우 하 좌 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, K 입력받음
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 배열 초기화
        arr = new int[N][M];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // r, c, s를 담을 Data 클래스로 초기화
        cals = new Data[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            cals[i] = new Data(r, c, s);
        }

        min = Integer.MAX_VALUE;
        boolean[] visited = new boolean[K];
        Data[] temp = new Data[K];
        permutation(0, temp, visited);

        System.out.print(min);

    }

    public static int[][] rotate(int r, int c, int s, int[][] temp_arr) {
        int[][] new_temp = copyArr(temp_arr);
        for (int i = 1; i < s + 1; i++) {
            int start_x = r - i - 1;
            int start_y = c - i - 1;
            int x = start_x;
            int y = start_y;
            int row_length = start_x + i * 2;
            int cal_length = start_y + i * 2;

            int index = 0;
            while (index < 4) {
                int nx = x + dx[index];
                int ny = y + dy[index];

                if (nx >= start_x && nx <= row_length && ny >= start_y && ny <= cal_length) {
                    new_temp[nx][ny] = temp_arr[x][y];
                    x = nx;
                    y = ny;
                } else {
                    index++;
                }
            }
        }
        return new_temp;
    }

    public static int[][] copyArr(int[][] array) {
        int[][] tmp = new int[array.length][array[0].length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                tmp[i][j] = array[i][j];
            }
        }
        return tmp;
    }

    public static void permutation(int current, Data[] temp, boolean[] visited) {
        if (current == K) {
            int[][] tmp = copyArr(arr);
            for (int i = 0; i < K; i++) {
                tmp = rotate(temp[i].r, temp[i].c, temp[i].s, tmp);
            }
            searchMin(tmp);
            return;
        }
        for (int i = 0; i < cals.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                temp[current] = cals[i];
                permutation(current + 1, temp, visited);
                visited[i] = false;
            }

        }
    }

    private static void searchMin(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = 0;
            for (int j = 0; j < arr[0].length; j++) {
                temp += arr[i][j];
            }
            if (temp < min) {
                min = temp;
            }
        }
    }

    // 테스트용
    private static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
class Data {
    public int r;
    public int c;
    public int s;

    public Data(int r, int c, int s){
        this.r = r;
        this.c = c;
        this.s = s;
    }
}