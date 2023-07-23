import java.util.*;

public class Main {
    /**
     * 백준 2468번 안전 영역
     *  https://www.acmicpc.net/problem/2468
     *  이 문제에서 말하는 안전영역이 연결요소와 비슷합니다.(같은가..?)
     *  1부터, 입력받은 값중 최대치까지 물높이를 높여가면서
     *  안전영역 수를 카운트 합니다.
     *  
     *  그 안전영역 수의 최대값을 구하는 문제입니다.
     *  저는 bfs로 풀었지만, dfs로도 가능할 것 같습니다.
     *  순회를 하지 못하게 하는 예외처리가 중요합니다.
     *
     */

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        // max 값만큼 탐색을 해야하므로
        int max = 0;

        // 배열에 값 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                // 배열에 값을 넣는김에, max값도 찾기
                if (a > max) {
                    max = a;
                }
                arr[i][j] = a;
            }
        }

        //결과값
        int result = 1;


        for (int i = 1; i <= max; i++) {
            // 방문여부
            boolean[][] visited = new boolean[n][n];
            // 카운트
            int count = 0;
            // 탐색 시작
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // 방문하지 않았으며, 물의 제한 높이보다 높은 값이라면 bfs
                    if (!visited[j][k] && arr[j][k] > i) {
                        bfs(arr, j, k, i, n, visited);
                        count ++;
                    }
                }
            }
            // 최대값을 구하기 위해서
            if (result < count) {
                result = count;
            }
        }

        System.out.println(result);
    }

    // bfs
    public static void bfs(int[][] arr, int x, int y, int water, int size, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});


        while (!q.isEmpty()) {
            int[] point = q.poll();
            x = point[0];
            y = point[1];

            // 위 아래 왼쪽 오른쪽 검사
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 배열 범위 밖이라면 continue
                if (nx >= size || nx < 0 || ny >= size || ny < 0) {
                    continue;
                }

                // 주변에 값이 물 높이보다 낮거나, 방문한적이 있다면 continue
                if (arr[nx][ny] <= water || visited[nx][ny]) {
                    continue;
                }

                // 걸리는 조건이없다면 방문처리후, q에 값 추가
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}

