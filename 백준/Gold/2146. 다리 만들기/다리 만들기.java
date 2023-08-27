import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, min;
    static int[][] arr, sea;
    static int count;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        sea = new int[N][N];
        visited = new boolean[N][N];
        count = 2;
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    bfs(i, j, count);
                    count++;
                }
            }
        }

        int start_island = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == start_island) {
                    bfs2(i, j, start_island);
//                    visited = new boolean[N][N];
                    sea = new int[N][N];
                    start_island++;
                }
            }
        }

        System.out.println(min);
    }

    // 섬을 구분해서 섬 번호로 색칠하기
    public static void bfs(int start_x, int start_y, int island_num) {

        Queue<Integer[]> q = new ArrayDeque<>();
        q.offer(new Integer[]{start_x, start_y});
        arr[start_x][start_y] = island_num;

        while (!q.isEmpty()) {
            Integer[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = island_num;
                    q.offer(new Integer[]{nx, ny});
                }

            }
        }
    }

    // 섬을 기준으로 탐색
    public static void bfs2(int start_x, int start_y, int island_num) {

        Queue<Integer[]> q = new ArrayDeque<>();
        q.offer(new Integer[]{start_x, start_y, 0});
        visited[start_x][start_y] = true;

        while (!q.isEmpty()) {
            Integer[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int now_count = now[2];

                if (now_count >= min) {
//                    visited[nx][ny] = false;
                    continue;
                }

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                    // 같은 섬일 경우
                if (arr[nx][ny] == island_num && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Integer[]{nx, ny, now_count});

                    // 바다인 경우
                } else if (arr[nx][ny] == 0) {
//                    visited[nx][ny] = true;
                    // 처음 온 장소라면,
                    if (sea[nx][ny] == 0) {
                        sea[nx][ny] = now_count;
                        q.offer(new Integer[]{nx, ny, now_count + 1});

                    // 더 빨리왔다면, 그 값을 갱신하고 다시 탐색
                    } else if (sea[nx][nx] > now_count) {
                        sea[nx][ny] = now_count;
                        q.offer(new Integer[]{nx, ny, now_count + 1});

                    // 이미 더 빠른 방법으로 방문했을경우 무시
                    } else if (sea[nx][nx] <= now_count) {
                        // 아무것도 안해도 되나...
                    }


                  // 다른 섬에 도착한 경우
                } else if (arr[nx][ny] != 0 && arr[nx][ny] != island_num) {
                    min = Math.min(min, now_count);
                }

            }
        }
    }

}