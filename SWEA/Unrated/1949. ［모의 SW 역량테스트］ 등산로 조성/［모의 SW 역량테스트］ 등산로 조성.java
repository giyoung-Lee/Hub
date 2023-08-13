import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    /**
     * SWEA 1949 등산로 조성
     *
     * dfs 알고리즘을 사용해서 해결 했습니다.
     * 1.  우선 산의 높이를 저장하는 배열을 기록하면서 고점(int max)을 찾습니다.
     * 1.1 배열에서 max값인 경우에 dfs를 시행하면서 result 값을 갱신합니다.
     * 
     * 2.  방향벡터를 이용하여 4방향을 탐색합니다.
     * 탐색할 다음 지역인 nx, ny의 값이 배열의 범위를 넘어가지 않으면서 !visited 했다면
     * 
     * 2.1   현재 높이보다 높은가?
     * 2.1.1 산의 높이를 깎을 수 있는 기회가 아직 있는가?
     * 2.1.2 기회를 -1 하고, 산높이를 깎은 후 다시 새로운 좌표로 dfs 탐색, move_count ++
     * 2.1.3 여기서 얼만큼 깎아야 하나? - 현재높이보다 1낮은 상태까지 깎아야 이상적
     * 
     * 2.2   현재 산의 높이보다 낮다면
     * 2.2.1 그냥 dfs 탐색, move_count ++ 
     *
     */


    static int N, K, result;
    static int[][] arr;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            visited = new boolean[N][N];
            result = 0;

            arr = new int[N][N];
            int max = 0;
            // 산의 높이를 배열에 저장
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    // 최대값 갱신
                    max = Math.max(max, arr[i][j]);
                }
            }

            // 최고점일때 dfs 탐색
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == max) {
                        visited[i][j] = true;
                        // K 만큼 깎을 기회는 1번
                        dfs(i,j, arr[i][j], 1, 1);
                        visited[i][j] = false;
                    }
                }
            }
            System.out.println("#" + test + " " + result);
        }
    }

    public static void dfs (int x, int y, int h, int chance, int move_count) {
        // 4방향으로 탐색할것.
        for (int i = 0; i < 4; i++) {
            // result를 갱신
            if(result < move_count) {
                result = move_count;
            }
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 안에 들고, 방문하지 않았다면,
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                // 만약 가야할 곳의 높이가 현재 높이보다 높다면?
                if (h <= arr[nx][ny]) {
                    // 기회가 남아있으면서, k를 뺐을때 현재 높이보다 낮아진다면
                    if (chance >= 1 && h > arr[nx][ny] - K) {
                        visited[nx][ny] = true;
                        // 현재높이보다 1 작은값만큼 깎아야 최대 경우의 수를 따질 수 있음
                        dfs(nx, ny, h - 1, chance - 1, move_count + 1);
                        // 재귀가 끝나면 다시 방문 false 처리
                        visited[nx][ny] = false;
                    }

                    // 가야할 곳이 현재 높이보다 낮다면
                } else {
                    visited[nx][ny] = true;
                    dfs(nx, ny, arr[nx][ny], chance, move_count + 1);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}