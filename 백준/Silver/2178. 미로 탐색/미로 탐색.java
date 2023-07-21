import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    /**
     * 백준 2178번 미로탐색
     *  https://www.acmicpc.net/problem/2178
     *
     *  이름 그대로 미로를 탐색하는 문제입니다.
     *  저는 BFS 알고리즘을 사용해서 문제를 해결 하였습니다.
     *  첫번째 좌표부터 이동을 하며, 배열의 자리에 최소값을 입력해 줍니다.
     *
     *  모든 자리에서 각 최소값을 입력하게 된다면 마지막 (N, M)의 값이 정답이됩니다.
     *  (* 여기서는 0,0 부터 시작하므로, (N-1, M-1)이 정답입니다.
     *
     *  탐색하면서 배열에 값을 저장하면서 가기때문에 방문여부를 확인하는 배열이
     *  따로 필요없습니다.
     */

    static int a, b;
    static int[][] arr;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 미로의 크기
        a = sc.nextInt();   //행
        b = sc.nextInt();   //열

        // 미로의 상태를 저장할 배열
        arr = new int[a][b];

        // 미로의 값을 저장
        for (int i = 0; i < a; i++) {
            String input = sc.next();
            for (int j = 0; j < b; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }

        // 0, 0 에서 시작
        int result = bfs(0, 0);
        System.out.println(result);
    }

    // bfs 탐색
    public static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y}); // 시작점을 큐에 추가

        while (!q.isEmpty()) {
            int[] point = q.poll();
            x = point[0];
            y = point[1];

            // 상하좌우 네 방향에서 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; // 새로운 x 좌표
                int ny = y + dy[i]; // 새로운 y 좌표

                // 범위를 벗어났거나, 이동할 수 없는 위치인 경우 건너뜀
                if (nx >= a || nx < 0 || ny >= b || ny < 0) {
                    continue;
                }

                // 이동할 수 있는 칸인 경우
                if (arr[nx][ny] == 1) {
                    // 최단 경로의 길이를 저장하고, 이동 가능한 위치를 큐에 추가
                    // 배열에 값을 저장해 버리면서 방문 처리를 해버림!
                    arr[nx][ny] = arr[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        // (a-1, b-1) 위치에 저장된 최단 경로 길이를 반환
        return arr[a - 1][b - 1];
    }
}
