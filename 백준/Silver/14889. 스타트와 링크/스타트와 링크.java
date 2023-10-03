import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visited = new boolean[N];
        min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 조합
        comb(0, 0);
        System.out.println(min);
    }

    static void comb(int index, int count) {
        // 기저조건
        if (count == N/2) {
            // 각팀의 점수
            int start = 0;
            int link = 0;

            // 전부 돌면서(중복해서 더하지 않기위해 범위를 지정)
            for (int i = 0; i < N - 1; i++) {
                for (int j = i+1; j < N; j++) {

                    if (visited[i] && visited[j]) {
                        // 만약 둘다 true라면 한쪽팀에 더해줌
                        start += arr[i][j];
                        start += arr[j][i];

                    } else if (!visited[i] && !visited[j]) {
                        // 둘다 false라면 나머지 팀이므로, 더해줌
                        link += arr[i][j];
                        link += arr[j][i];
                    }
                }
            }

            // 차이값
            int temp = Math.abs(start - link);
            // 0이면 가장 최선이므로 더이상 비교할 필요가없음
            if (temp == 0) {
                System.out.println(temp);
                System.exit(0);
            } else {
                // 아니면 갱신
                min = Math.min(temp, min);
            }
            return;
        }

        // 조합
        for (int i = index; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                comb(i+1, count+1);
                visited[i] = false;
            }
        }
    }


}