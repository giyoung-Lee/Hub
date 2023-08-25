import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    /**
     * 
     * 
     */

    static int N, size, min;
    static int[][] arr;
    static core[] Core;
    static boolean used_core[], visited[][];
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            // 초기화
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            // 최대 12개이므로
            Core = new core[12];
            used_core = new boolean[12];
            visited = new boolean[N][N];
            // 코어의 개수
            size = 0;
            // 정답
            min = Integer.MAX_VALUE;

            // 값과 코어 등록
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());

                    if (i > 0 && i < N-1 && j > 0 && j < N-1) {
                        if(arr[i][j] == 1){
                            Core[size++] = new core(i, j);
                        }
                    }
                }
            }

            for(int i = size; i >= 0; i--) {
                comb(0, 0, i);
                // 한번이라도 갱신 되었다면
                if(min < Integer.MAX_VALUE){
                    break;
                }
            }
            System.out.println("#"+ test + " " + min);
        }

    }

    public static void dfs(int index, int count) {
        if (index == size) {
            min = Math.min(min, count);
            return;
        }
    
        // comb에서 걸러낸 애들만 dfs 실행
        if (!used_core[index]) {
            dfs(index+1, count);
            return;
        }

        // 4방향 dfs 탐색할건데
        for (int i = 0; i < 4; i++) {
            int nx = Core[index].x;
            int ny = Core[index].y;
            // 현재위치 방문처리
            visited[nx][ny] = true;
            int temp = 0;

            // 탐색을 끝까지 했는지 체크하는 flag
            boolean flag = false;
            while (true) {
                nx = nx + dx[i];
                ny = ny + dy[i];

                // 끝까지 간 경우
                if ( nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    flag = true;
                    break;
                }

                // 중간에 전선이나 코어를 만난경우
                if(arr[nx][ny] == 1 || visited[nx][ny]) {
                    break;
                }

                // 지나온 길을 방문처리
                visited[nx][ny] = true;

                // 전선의 수 ++
                temp++;
            }

            // 성공했으면 전선의 수를 넘기며 다음 dfs 실행
            if(flag) {
                dfs(index + 1, count + temp);
            }

            // 다 돌고 왔으면 방문처리 원상태로 돌려놓기
            while (true) {
                // 한칸씩돌아가면서
                nx -= dx[i];
                ny -= dy[i];
                if(nx == Core[index].x && ny == Core[index].y) {
                    break;
                }
                // false처리
                visited[nx][ny] = false;
            }
        }
    }

    // 조합. r 은 nCr 의 r
    public static void comb(int index, int count, int r) {
        // 기저조건. 개수가 다 채워지면
        // dfs 실행
        if(count == r) {
            dfs(0, 0);
            return;
        }
        for (int i = index; i < size; i++) {
            used_core[i] = true;
            comb(i+1, count+1, r);
            used_core[i] = false;
        }
    }

    static class core {
        int x, y;

        public core(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}