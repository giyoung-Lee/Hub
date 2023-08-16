import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int x, y, result;
    static String[][] arr;
    static boolean[][] visited;
    // 방향 벡터. 어디부터 탐색하는게 옳을지 다시 생각할것
    // 최대한 오른쪽으로 안가려고 해야한다.
    // 우선 순위 : 오른쪽 위 -> 오른쪽 -> 오른쪽 아래
    static int[] dx = { -1, 0, 1 };
    static int[] dy = {  1, 1, 1 };
    static boolean flag;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        // R
        x = Integer.parseInt(st.nextToken());
        // C
        y = Integer.parseInt(st.nextToken());
        result = 0;

        arr = new String[x][y];
        visited = new boolean[x][y];

        for(int i = 0; i < x; i++) {
            String temp = br.readLine();
            String[] temp2 = temp.split("");
            for (int j = 0; j < y; j++) {
                arr[i][j] = temp2[j];
            }
        }

        flag = false;
        for(int i = 0; i < x; i++) {
            if (arr[i][0].equals(".")) {
                if(dfs(i, 0)) {
                    result ++;
                }
            }
        }
        System.out.println(result);


    }


    private static boolean dfs(int temp_x, int temp_y) {
        if (temp_y == y-1) {
            return true;
        } else {
            for (int i = 0; i < 3; i++) {
                int nx = temp_x + dx[i];
                int ny = temp_y + dy[i];

                if (nx < 0 || nx >= x || ny < 0 || ny >= y || arr[nx][ny].equals("x")) {
                    continue;
                }

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    boolean flag = dfs(nx, ny);
                    if(flag) {
                        return flag;
                    }
                }
            }
        }

        return false;
    }
}