import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, L, R, result;
    // 국가
    static int[][] nation;
    // 방향벡터
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 값 초기화 및 입력받기
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        result = 0;

        nation = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                nation[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 종료조건을 만날때까지 연합을 만들어봄
        while (true) {
            // 한 차례마다 쓸 방문배열
            boolean[][] visited = new boolean[N][N];
            // 탈출 조건
            boolean isMoved = false;

            // 배열 전체를 탐색하는데
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 방문했으면 continue
                    if (visited[i][j]) {
                        continue;
                    }

                    // bfs 탐색을 실행할 queue와
                    Queue<int[]> q = new LinkedList<>();
                    // 연합국 끼리의 좌표를 담아둘 queue
                    Queue<int[]> save = new LinkedList<>();

                    // 방문처리해주고
                    visited[i][j] = true;
                    // 같이 넣어줌
                    q.offer(new int[] {i, j});
                    save.offer(new int[] {i, j});

                    // 평균값으로 바꿔줘야 하므로
                    int sum = 0;
                    int count = 0;

                    while (!q.isEmpty()) {
                        // 하나꺼내서
                        int[] now = q.poll();
                        int x = now[0];
                        int y = now[1];

                        // sum과 count 갱신
                        sum += nation[x][y];
                        count++;

                        // 4방 탐색
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            // 조건에 안맞으면 continue
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                                continue;
                            }

                            // 차이값을 계산해서
                            int dif = Math.abs(nation[x][y] - nation[nx][ny]);

                            // 그 범위 안에 들어가 있다면 실행
                            if ( L <= dif && dif <= R) {
                                // 한번이라도 연합국을 만났으니, true
                                isMoved = true;
                                // 방문처리
                                visited[nx][ny] = true;
                                // queue에 값을 넣어줌
                                q.offer(new int[] {nx, ny});
                                save.offer(new int[] {nx, ny});
                            }
                        }
                    }
                    // 한번의 bfs가 끝났다면 평균값으로 갱신해줌
                    sum /= count;
                    while (!save.isEmpty()) {
                        int[] now = save.poll();
                        nation[now[0]][now[1]] = sum;
                    }
                }
            }
            // 한번도 연합을 만들지 않았다면 break
            if (!isMoved) {
                break;
            } else {
                // 아니면 결과값 ++
                result ++;
            }
        }

        // 정답 출력
        System.out.println(result);
    }
}