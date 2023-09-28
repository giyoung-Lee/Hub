import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pos {
    int y, x, time;

    public Pos(int y, int x) {
        super();
        this.y = y;
        this.x = x;
    }

    public Pos(int y, int x, int time) {
        super();
        this.y = y;
        this.x = x;
        this.time = time;
    }
}

public class Main {
    static int r, c;
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };
    static int answer = Integer.MAX_VALUE;
    static char[][] map;

    // 고슴도치와 물의 위치를 저장하는 큐
    static Queue<Pos> q = new LinkedList<Pos>();
    static Queue<Pos> water = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        map = new char[r][c];

        // map을 초기화 해주면서 고슴도치와 물의 상태를 처음 q에 넣어줌
        for (int i = 0; i < r; i++) {
            String s = sc.next();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'S') {
                    q.add(new Pos(i, j, 0));
                } else if (map[i][j] == '*') {
                    water.add(new Pos(i, j));
                }
            }
        }

        solve();

        // 정답 출력
        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);

        sc.close();
    }

    private static void solve() {
        while (!q.isEmpty()) {
            int waterSize = water.size();

            // 물을 먼저 퍼뜨림
            for (int i = 0; i < waterSize; i++) {
                Pos cur = water.poll();
                int y = cur.y;
                int x = cur.x;
                for (int k = 0; k < 4; k++) {
                    int yy = y + dy[k];
                    int xx = x + dx[k];
                    if (xx < 0 || yy < 0 || xx >= c || yy >= r)
                        continue;
                    if (map[yy][xx] == 'D' || map[yy][xx] == 'X' || map[yy][xx] == '*')
                        continue;
                    map[yy][xx] = '*';
                    water.add(new Pos(yy, xx));
                }
            }
            
            // 고슴도치를 이동시킴
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Pos cur = q.poll();
                int y = cur.y;
                int x = cur.x;
                int time = cur.time;
                for (int k = 0; k < 4; k++) {
                    int yy = y + dy[k];
                    int xx = x + dx[k];
                    if (xx < 0 || yy < 0 || xx >= c || yy >= r)
                        continue;
                    if (map[yy][xx] == 'D') {
                        answer = Math.min(answer, time + 1);
                        return;
                    } else if (map[yy][xx] == '.') {
                        map[yy][xx] = 'S';
                        q.add(new Pos(yy, xx, time + 1));
                    }
                }
            }
        }
    }
}