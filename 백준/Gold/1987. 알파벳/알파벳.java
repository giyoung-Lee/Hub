import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int R; // 세로 R칸
    static int C; // 가로 C칸
    static char[][] arr; // 알파벳을 저장할 배열
    static boolean[] alphabet; // 이동한 경로를 따라 알파벳이 사용되었는지를 저장할 배열
    static int result; // 말이 지날 수 있는 최대 칸 수
    
    
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken()); // 세로 R칸
        C = Integer.parseInt(st.nextToken()); // 가로 C칸
        
        arr = new char[R][C]; // 알파벳을 저장할 배열
        alphabet = new boolean[26];
        result = 0;
        
        // 알파벳 입력받기
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for(int j=0; j<C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        
        dfs(0, 0, 1);
        
        System.out.println(result);
        
    }
    
    private static void dfs(int x, int y, int count) {

        alphabet[arr[x][y] - 65] = true; // 사용한 알파벳 체크
        
        
        for(int i=0; i<4; i++) {
            int temp_x = x + dx[i];
            int temp_y = y + dy[i];
            
            // 배열의 범위를 벗어나면 다음 탐색
            if(temp_x < 0 || temp_x >= R || temp_y < 0 || temp_y >= C) {
                continue;
            }
            
            // 이미 사용한 알파벳이면 리턴
            if( alphabet[ arr[temp_x][temp_y] - 65 ] ) { // 이미 사용한 알파벳
                continue;
            }
            
            // 사용한 알파벳이 아니라면 다음 탐색 (재귀 호출)
            dfs(temp_x, temp_y, count + 1);
            alphabet[ arr[temp_x][temp_y] - 65] = false;
        }
        result = Math.max(result, count);
    }

}