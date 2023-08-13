import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static int[][] arr;
    // 좌상 상 우상 우 우하 하 좌하 좌
    static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
    static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
    static int[] dx2 = { 1, -1, 0, 0 };
    static int[] dy2 = { 0, 0, -1, 1 };
    static int N;

    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            // 배열 초기화
            arr = new int[N][N];
            visited = new boolean[N][N];

            // 배열 입력 받기
            for (int i = 0; i < N; i++) {
                String row = br.readLine();
                for (int j = 0; j < N; j++) {
                    char tmp = row.charAt(j);
                    // * 이면
                    if (tmp == '*') {
                        // 해당 자리는 9로 초기화
                        arr[i][j] = 9;

                        // 주변 방향을 검색해서
                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            // 배열을 벗어나지 않으면 ++
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N ) {
                                arr[nx][ny] ++;
                            }

                        }
                    }

                }
            }
            int count = 0;
            // 배열 탐색 우선 0일때
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] == 0 && !visited[i][j]) {
                        bfs(i, j);
                        count ++;
                    }
                }
            }

            // 0을 다 탐색하고도 남은 경우를 찾기 위해
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] < 9 && !visited[i][j]) {
                        bfs(i, j);
                        count ++;
                    }
                }
            }

            System.out.println("#" + test + " "  + count);

        }
    }

    // 0 일때만 탐색해서 방문 처리해주고, 그 다음은 9보다 작을때 방문처리
    public static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (arr[now[0]][now[1]] == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if(nx < 0 || nx >= N || ny < 0 || ny >= N || arr[nx][ny] >= 9 || visited[nx][ny]) {
                        continue;
                    }

                    visited[nx][ny] = true;
                    if (arr[nx][ny] == 0 ) {
                        q.add(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}