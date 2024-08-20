import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] arr;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int imgCount = 1;
    static int maxCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 1) {
                    imgCount += 1;
                    bfs(i, j, imgCount);
                }
            }
        }

        System.out.println(imgCount-1);
        System.out.println(maxCount);
    }

    public static void bfs(int x, int y, int count) {
        Queue<int[]> q = new LinkedList<>();
        arr[x][y] = count;
        q.add(new int[] {x, y});
        int tempCount = 0;

        while (!q.isEmpty()){
            int[] now = q.poll();
            tempCount += 1;

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || arr[nx][ny] != 1) {
                    continue;
                }

                arr[nx][ny] = count;
                q.add(new int[] {nx, ny});
            }

        }
        if (tempCount > maxCount) {
            maxCount = tempCount;
        }
    }
}