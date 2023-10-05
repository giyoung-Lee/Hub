import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {
    static int N, W, H, min;
    static int[] number;
    static int[][] arr, temp;
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            arr = new int[H][W];
            temp = new int[H][W];
            number = new int[N];

            min = Integer.MAX_VALUE;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    // 처음은 원본배열 arr과 복사본인 temp 같이 넣어줌
                    arr[i][j] = temp[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            permutation(0);
            System.out.println("#" + test + " " + min);
        }
    }

    public static void permutation(int cnt) {
        // 기저조건
        if (cnt == N) {
            block(number);

            int count = 0;
            // 벽돌의 숫자를 세어주고
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (temp[i][j] != 0) {
                        count ++;
                    }
                }
            }
            // 최소값 갱신
            min = Math.min(min, count);
            
            // 복사해둔 배열 다시 초기화
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    temp[i][j] = arr[i][j];
                }
            }
        } else {
            // 중복순열
            for (int i = 0; i < W; i++) {
                number[cnt] = i;
                permutation(cnt + 1);
            }
        }
    }

    // 블록을 폭파시키기 위한 메서드
    public static void block(int[] number) {
        int x = 0;
        int y = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < H; j++) {
                if(temp[j][number[i]] != 0) {

                    // 해당열에 블록을 만나면, 저장해주고 break
                    x = j;
                    y = number[i];
                    break;
                }
            }
            // 해당 블록의 좌표를가지고 bfs
            bfs(x, y);
            // 하고 블록을 아래로 내려줌
            down();
        }
    }

    // 진짜로 폭파 시키는 bfs
    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {temp[x][y], x, y});
        temp[x][y] = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int power = now[0];

            // 폭발범위는 블록의 숫자 -1 이고, i를 1 부터 시작해서 곱하기 쉽게함.
            for (int i = 1; i < power; i++) {
                for (int j = 0; j < 4; j++) {
                    // 블록의 숫자만큼 폭발 시켜야 하므로 i를 곱해줌
                    int nx = now[1] + dx[j] * i;
                    int ny = now[2] + dy[j] * i;

                    // 범위를 벗어나거나 블록이 아니거나
                    if (nx < 0 || nx >= H || ny < 0 || ny >= W || temp[nx][ny] == 0) {
                        continue;
                    }

                    if (temp[nx][ny] != 0) {
                        // 블록을 추가해주고
                        q.add(new int[] {temp[nx][ny], nx, ny});
                        // 0으로 만들어줌
                        temp[nx][ny] = 0;
                    }

                }
            }
        }
    }


    public static void down() {
        Stack<Integer> stack = new Stack<>();

        // 열을 기준으로
        for (int i = 0; i < W; i++) {
            // 행으로 증가시키면서 비교(그림상에서는 위에서 아래로)
            for (int j = 0; j < H; j++) {
                // 벽돌인 경우 스택에 넣어줌
                if (temp[j][i] != 0) {
                    stack.add(temp[j][i]);
                }
            }
            // 밑에서 부터 행을 감소시키면서 비교
            for (int j = H-1; j >= 0; j--) {
                if (stack.isEmpty()) {
                    // 스택이 비었으면 0
                    temp[j][i] = 0;
                } else {
                    // 스택에 있는 벽돌을 넣어줌
                    temp[j][i] = stack.pop();
                }
            }

        }
    }

}
