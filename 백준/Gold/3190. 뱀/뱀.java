import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N, K, L, time, index;
    static int[][] map;
    static HashMap<Integer, Character> direction;
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        // 뱀이 돌아다니고, 사과가 있어야할 맵
        map = new int[N][N];
        direction = new HashMap<>();

        for (int i = 0; i < K; i++) {
            // 사과 추가
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = 2;
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            // 방향과 시간 받기
            st = new StringTokenizer(br.readLine());
            direction.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        // Deque를 이용
        Deque<int[]> dq = new ArrayDeque<>();
        // 초기값 설정
        map[0][0] = 1;
        dq.offerFirst(new int[] {0, 0});
        int direct = 1;
        time = 0;

        while (true) {
            // 시간증가
            time++;
            // 머리
            int[] head = dq.peekFirst();
            // 머리 좌표
            int now_x = head[0];
            int now_y = head[1];
            // 이동한 좌표
            int nx = now_x + dx[direct];
            int ny = now_y + dy[direct];

            // 벗어난 경우
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] == 1) {
                break;
            }

            // 이동하는곳에 사과가 없는경우
            if (map[nx][ny] != 2) {
                int[] tail = dq.pollLast();
                int t1 = tail[0];
                int t2 = tail[1];
                map[t1][t2] = 0;
            }

            // 예외 조건에 걸리지 않는다면 다음칸으로 이동시켜줌
            map[nx][ny] = 1;
            dq.offerFirst(new int[] {nx, ny});

            // 고개를 꺾을 시간이되었을 경우.
            if (index < L && direction.containsKey(time)) {
                Character now_direct = direction.get(time);
                if (now_direct == 'L') { // 뱀일 바라보는 방향 변환시켜줌
                    direct = (direct + 3) % 4;
                } else if (now_direct == 'D') {
                    direct = (direct + 1) % 4;
                }
            }
        }

        System.out.println(time);
    }
}