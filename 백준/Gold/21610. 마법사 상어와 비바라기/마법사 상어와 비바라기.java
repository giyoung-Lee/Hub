import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M, d, s;
    static int[][] bucket;
    static boolean[][] visited;
    static List<int[]> cloud;
    static int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        
        // 값을 입력받고 초기화
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());

        bucket = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            stringTokenizer = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                bucket[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        // 초기 구름
        cloud = new ArrayList<>();
        cloud.add(new int[]{N-2,0});
        cloud.add(new int[]{N-2,1});
        cloud.add(new int[]{N-1,0});
        cloud.add(new int[]{N-1,1});

        // 이동 명령
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            d = Integer.parseInt(stringTokenizer.nextToken());
            s = Integer.parseInt(stringTokenizer.nextToken());
            
            // 이동하고, 물복사 버그가 일어나고, 구름을 만듬
            visited = new boolean[N][N];
            MoveCloud(d, s);
            waterCopyBug();
            makeCloud();
        }

        int result = result();
        System.out.println(result);
    }

    // 결과 총량 계산
    private static int result() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += bucket[i][j];
            }
        }
        return sum;
    }

    // 구름 만들기
    private static void makeCloud() {
        cloud = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (bucket[i][j] >= 2 && !visited[i][j]) {
                    bucket[i][j] -= 2;
                    cloud.add(new int[]{i, j});
                }
            }
        }
    }

    // 물복사 버그
    private static void waterCopyBug() {
        for (int[] c : cloud) {
            int cnt = 0;
            for (int d = 2; d < 9; d += 2) {
                int nx = c[0] + dx[d];
                int ny = c[1] + dy[d];

                if (nx < 0 || ny < 0 || N <= nx || N <= ny) continue;
                if(bucket[nx][ny] > 0) cnt++;
            }
            bucket[c[0]][c[1]] += cnt;
        }
    }

    // 구름 이동
    private static void MoveCloud(int d, int s) {
        for (int[] c : cloud) {
            int nx = (c[0] + N + dx[d] * s % N) % N;
            int ny = (c[1] + N + dy[d] * s % N) % N;

            visited[nx][ny] = true;
            bucket[nx][ny] += 1;
            c[0] = nx;
            c[1] = ny;
        }
    }
}