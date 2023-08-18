import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * <D3_1872_상호의배틀필드>

    구현했으나 아직 통과하지 못했습니다................
    수정 후 다시 제출하겠습니다................ㅠㅠ
    (테스트케이스 86개 통과)

 * 
 * 문자    동작
 * U    Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.
 * D    Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.
 * L    Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.
 * R    Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.
 * S    Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
 * 
 * @author 유세진
 *
 */

public class Solution {
    
    static int x; // x좌표
    static int y; // y좌표
    static int H; // 게임 맵의 높이
    static int W; // 게임 맵의 너비
    static String[][] map; // 게임 맵
    static String direction = ""; // 전차가 바라보는 방향 (^, v, <, >)
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수
        
        for(int test_case=1; test_case<=T; test_case++) {
            str = br.readLine().split(" ");
            H = Integer.parseInt(str[0]); // 게임 맵의 높이
            W = Integer.parseInt(str[1]); // 게임 맵의 너비
            
            map = new String[H][W]; // 게임 맵
            
            // 게임 맵의 값 입력받기
            for(int i=0; i<H; i++) {
                str = br.readLine().split("");
                for(int j=0; j<W; j++) {
                    map[i][j] = str[j];
                }
            }
            
            int N = Integer.parseInt(br.readLine()); // 사용자가 넣을 입력의 개수
            
            String[] input = new String[N]; // 사용자 입력값을 저장할 배열
            str = br.readLine().split("");
            for(int i=0; i<N; i++) {
                input[i] = str[i];
            }
            
            // 1. 전차 찾기 (전차는 하나뿐)
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    if(map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<") || map[i][j].equals(">")) {
                        x = i; // 전차의 처음 x좌표
                        y = j; // 전차의 처음 y좌표
                    }
                }
            }
            
            // 2. 사용자의 입력값 실행
            for(int i=0; i<N; i++) {
                play(input[i], x, y);
            }
            
            // 3. 현재 게임 맵의 상태 출력
            System.out.printf("#%d ", test_case);
            for(int i=0; i<H; i++) {
                for(int j=0; j<W; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            
        }
        
    }
    
    // 사용자의 입력값을 하나 실행할 때 호출되는 함수
    // command : 입력 명령(방향), px/py : 현재 전차가 있는 맵의 x좌표/y좌표
    private static void play(String command, int px, int py) {
        
        int[] dx = { -1, 1, 0, 0 }; // 행
        int[] dy = { 0, 0, -1, 1 }; // 열
        
        if(command.equals("U")) {
            
            // 전차가 바라보는 방향을 바꾸고 -> direction : ^
            direction = "^";
            
            // 윗칸이 게임 맵의 공간을 벗어나려고 하면 이동하지 않음
            if(px+dx[0] < 0 || px+dx[0] >= H || py+dy[0] < 0 || py+dy[0] >= W) {
            	map[px][py] = direction;
                return;
            }
            
            // 게임 맵의 공간을 벗어나지 않고, 한 칸 위의 칸이 평지라면 그 칸으로 이동
            if(map[px+dx[0]][py+dy[0]].equals(".")) {
                map[px][py] = "."; // 원래 있던 칸은 평지로 만들고
                x = px + dx[0];
                y = py + dy[0];
                map[x][y] = direction; // 다음 칸에 전차를 넣어줌
            } else { // 한 칸 위의 칸이 평지가 아니라면
                map[px][py] = direction;
            }
            
        } else if(command.equals("D")) {
            
            // 전차가 바라보는 방향을 바꾸고 -> direction : v
            direction = "v";
            
            // 아래칸이 게임 맵의 공간을 벗어나려고 하면 이동하지 않음
            if(px+dx[1] < 0 || px+dx[1] >= H || py+dy[1] < 0 || py+dy[1] >= W) {
            	map[px][py] = direction;
                return;
            }
            
            // 게임 맵의 공간을 벗어나지 않고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동
            if(map[px+dx[1]][py+dy[1]].equals(".")) {
                map[px][py] = "."; // 원래 있던 칸은 평지로 만들고
                x = px + dx[1];
                y = py + dy[1];
                map[x][y] = direction; // 다음 칸에 전차를 넣어줌
            } else { // 한 칸 밑의 칸이 평지가 아니라면
                map[px][py] = direction;
            }
            
        } else if(command.equals("L")) {
            
            // 전차가 바라보는 방향을 바꾸고 -> direction : <
            direction = "<";
            
            // 왼쪽 칸이 게임 맵의 공간을 벗어나려고 하면 이동하지 않음
            if(px+dx[2] < 0 || px+dx[2] >= H || py+dy[2] < 0 || py+dy[2] >= W) {
            	map[px][py] = direction;
                return;
            }
            
            // 게임 맵의 공간을 벗어나지 않고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동
            if(map[px+dx[2]][py+dy[2]].equals(".")) {
                map[px][py] = "."; // 원래 있던 칸은 평지로 만들고
                x = px + dx[2];
                y = py + dy[2];
                map[x][y] = direction; // 다음 칸에 전차를 넣어줌
            } else { // 한 칸 왼쪽의 칸이 평지가 아니라면
                map[px][py] = direction;
            }
            
        } else if(command.equals("R")) {
            
            // 전차가 바라보는 방향을 바꾸고 -> direction : >
            direction = ">";
            
            // 오른쪽 칸이 게임 맵의 공간을 벗어나려고 하면 이동하지 않음
            if(px+dx[3] < 0 || px+dx[3] >= H || py+dy[3] < 0 || py+dy[3] >= W) {
            	map[px][py] = direction;
                return;
            }
            
            // 게임 맵의 공간을 벗어나지 않고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동
            if(map[px+dx[3]][py+dy[3]].equals(".")) {
                map[px][py] = "."; // 원래 있던 칸은 평지로 만들고
                x = px + dx[3];
                y = py + dy[3];
                map[x][y] = direction; // 다음 칸에 전차를 넣어줌
            } else { // 한 칸 오른쪽의 칸이 평지가 아니라면
                map[px][py] = direction;
            }
            
        } else { // S일 때 (Shoot)
            
            direction = map[px][py]; // 현재 전차가 어느 방향을 향하고 있는지 확인
            
            if(direction.equals("^")) {
                
                for(int i=px-1; i >= 0; i--) {
                    if(map[i][py].equals("*")) { // 포탄이 벽돌을 만나면
                        map[i][py] = "."; // 평지로 바뀜
                        break;
                    } else if(map[i][py].equals("#")) { // 포탄이 강철을 만나면
                        break; // 아무 일도 일어나지 않음
                    } else if(map[i][py].equals("-") || map[i][py].equals(".")) { // 포탄이 물을 만나거나 평지를 만나면
                        continue; // 아무 일도 일어나지 않고 다음 칸 확인
                    }
                }
                
            } else if(direction.equals("v")) {
                
                for(int i=px+1; i < H; i++) {
                    if(map[i][py].equals("*")) { // 포탄이 벽돌을 만나면
                        map[i][py] = "."; // 평지로 바뀜
                        break;
                    } else if(map[i][py].equals("#")) { // 포탄이 강철을 만나면
                        break; // 아무 일도 일어나지 않음
                    } else if(map[i][py].equals("-") || map[i][py].equals(".")) { // 포탄이 물을 만나거나 평지를 만나면
                        continue; // 아무 일도 일어나지 않고 다음 칸 확인
                    }
                }
                
            } else if(direction.equals("<")) {
                
                for(int i=py-1; i >= 0; i--) {
                    if(map[px][i].equals("*")) { // 포탄이 벽돌을 만나면
                        map[px][i] = "."; // 평지로 바뀜
                        break;
                    } else if(map[px][i].equals("#")) { // 포탄이 강철을 만나면
                        break; // 아무 일도 일어나지 않음
                    } else if(map[px][i].equals("-") || map[px][i].equals(".")) { // 포탄이 물을 만나거나 평지를 만나면
                        continue; // 아무 일도 일어나지 않고 다음 칸 확인
                    }
                }
                
            } else { // direction : >
                
                for(int i=py+1; i < W; i++) {
                    if(map[px][i].equals("*")) { // 포탄이 벽돌을 만나면
                        map[px][i] = "."; // 평지로 바뀜
                        break;
                    } else if(map[px][i].equals("#")) { // 포탄이 강철을 만나면
                        break; // 아무 일도 일어나지 않음
                    } else if(map[px][i].equals("-") || map[px][i].equals(".")) { // 포탄이 물을 만나거나 평지를 만나면
                        continue; // 아무 일도 일어나지 않고 다음 칸 확인
                    }
                }
                
            }
            
        }
        
    }

}