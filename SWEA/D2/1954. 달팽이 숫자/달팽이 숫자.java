import java.util.Scanner;

class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int test = 1; test <= T; test++) {
            int N = sc.nextInt();

            // 배열의 크기만큼 초기화
            int[][] snail = new int[N][N];

            // 진행할 x, y
            int x = 0, y = 0;
            // 방향을 나타내기 위한 변수
            int dist = 0;

            for (int n = 1; n <= N * N; n++) {
                snail[x][y] = n;
                // 일단 dx ,dy만큼 더해줌
                x += dx[dist];
                y += dy[dist];

                // 그랬는데, 범위가 벗어나거나, 이미 입력된 배열을 만나면
                if (x < 0 || y < 0 || x >= N || y >= N || snail[x][y] != 0) {
                    // 한칸뒤 상태로 되돌리고
                    x -= dx[dist];
                    y -= dy[dist];

                    // (중요) 방향에 +1을해주는데, 이를 4로 나눔으로써
                    // 0 1 2 3을 평생 돌게됨
                    // 0 우 1 하 2 좌 3 상
                    dist = (dist + 1) % 4;

                    // 오른쪽으로 돌렸으니, x y는 막히지않고 탐색가능
                    x += dx[dist];
                    y += dy[dist];
                }
            }

            // 테스트 케이스 출력
            System.out.printf("#%d\n", test);
            // 배열의 값 출력
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}