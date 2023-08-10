import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    /**
     * 4012 [모의 SW 역량테스트] 요리사
     * 
     */

    static int n;   // N
    static int[][] synergy;     // 시너지~
    static boolean[] selected;  // 방문 여부 확인 배열
    static int mindiff;         // 정답이 되는 최소값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 입력받아서
        int T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {
            n = Integer.parseInt(br.readLine());

            // 초기화
            selected = new boolean[n];
            mindiff = Integer.MAX_VALUE;

            // 시너지~ 배열초기화
            synergy = new int[n][n];
            for (int r = 0; r < n; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int c = 0; c < n; c++) {
                    synergy[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            // 조합 드가자
            comb(0, 0);
            System.out.println("#" + test + " " + mindiff );
        }

    }

    static void comb(int start, int cnt) {
        // 기저조건
        if (cnt == n/2) {
            // 고른것중
            int choose = 0;
            for(int r=0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    // true true 인부분만 더해주고
                    if (selected[r] && selected[c]) {
                        choose += synergy[r][c];
                    }
                }
            }

            // 안고른것중
            int notchoose = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    // false false 인것만 더해주고
                    if (!selected[r] && !selected[c]) {
                        notchoose += synergy[r][c];
                    }
                }
            }

            // 만약 그 차이의 절대값이 더 작다면
            if (Math.abs(choose - notchoose) < mindiff) {
                // 갱신해주고~
                mindiff = Math.abs(choose - notchoose);
            }
            return;
        }

        // 조합 순회~
        for (int i = start; i < n; i++) {
            selected[i] = true;
            comb(i+1, cnt+1);

            selected[i] = false;
        }
    }
}