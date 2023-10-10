import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int X, Y, T;
	static int x1, x2, y1, y2;
	
	// 공기청정기 상
	static int[] dx1 = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dy1 = { 0, 1, 0, -1 };
	
	// 공기청정기 하
	static int[] dx2 = { 1, 0, -1, 0 }; // 하 우 상 좌 
	static int[] dy2 = { 0, 1, 0, -1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		x1 = x2 = y1 = y2 = -1;
		
		int[][] arr = new int[X][Y];
		for(int i = 0; i < X; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Y; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				
				if(arr[i][j] == -1 && x1 == -1) {
					x1 = i;
					y1 = j;
				} else if (arr[i][j] == -1 && x1 != -1) {
					x2 = i;
					y2 = j;
				}
			}
		}

		for(int i = 0; i < T; i ++) {
			arr = spread(arr);
			arr = rotate(arr);
		}
		
		int result = 0;
		for (int i = 0; i < X; i++) {
			for (int j = 0; j < Y; j++) {
				result += arr[i][j];
			}
		}
		
		System.out.println(result+2);
	}
	
	static int[][] spread(int[][] arr) {
		int[][] temp = new int[X][Y];
		for(int i = 0; i < X; i++) {
			for(int j = 0; j < Y; j++) {
				
				// 0이 아닌경우를 만났다면
				if(arr[i][j] != 0 && arr[i][j] != -1) {
					int count = 0;
					int val = arr[i][j]/5;
					
					// 4방향으로 뿌림
					for(int k = 0; k < 4; k++) {
						int nx = i + dx1[k];
						int ny = j + dy1[k];
						
						if (nx < 0 || nx >= X || ny < 0 || ny >= Y || arr[nx][ny] == -1) continue;
						
						temp[nx][ny] += val;
						count ++;
					}
					temp[i][j] += arr[i][j] - (count * val);
				}
				
			}
		}
		temp[x1][y1] = -1;
		temp[x2][y2] = -1;
		
		return temp;
	}
	
	static int[][] rotate(int[][] arr) {
		int index = 0;
		int x = x1;
		int y = y1;
		
		while(index < 4) {
			int nx = x + dx1[index];
			int ny = y + dy1[index];
			
			if(nx >= 0 && nx <= x1 && ny >= 0 && ny < Y) {
				if(arr[nx][ny] == -1) {
					arr[x][y] = 0;
					index ++;
				} else {
					if (arr[x][y] == -1) {
						x = nx;
						y = ny;
					} else {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					}					
				}
				
			} else {
				index++;
			}
			
		}
		
		index = 0;
		x = x2;
		y = y2;
		
		while(index < 4) {
			int nx = x + dx2[index];
			int ny = y + dy2[index];
			
			if(nx >= x2 && nx < X && ny >= 0 && ny < Y) {
				if(arr[nx][ny] == -1) {
					arr[x][y] = 0;
					index ++;
				} else {
					if (arr[x][y] == -1) {
						x = nx;
						y = ny;
					} else {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					}					
				}
				
			} else {
				index++;
			}
			
		}

		return arr;
	}
}