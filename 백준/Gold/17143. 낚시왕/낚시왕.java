import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int R, C, M;
	static ArrayList<shark>[][] list;
	// [0] 비워두고 [1] : 상 [2] : 하 [3] : 우 [4] : 좌
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				list[i][j] = new ArrayList<shark>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// r , c
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			// 속력
			int s = Integer.parseInt(st.nextToken());

			// 방향
			int d = Integer.parseInt(st.nextToken());

			// 크기
			int z = Integer.parseInt(st.nextToken());

			list[r][c].add(new shark(r, c, s, d, z));
		}

		int result = 0;
		for (int i = 0; i < C; i++) {
//			for (int t1 = 0; t1 < R; t1++) {
//				for (int t2 = 0; t2 < C; t2++) {
//					System.out.print(list[t1][t2].size() + " |");
//				}
//				System.out.println();
//			}
			
			
			for (int j = 0; j < R; j++) {
				if (list[j][i].size() == 1) {
					result += list[j][i].get(0).z;
					list[j][i].clear();
					break;
				}
			}
//			System.out.println(result);
			ArrayList<shark> shark_list = new ArrayList<shark>();
			for (int j = 0; j < R; j++) {
				for (int k = 0; k < C; k++) {
					if (list[j][k].size() == 1) {
						shark new_shark = shark_move(list[j][k].get(0));
						shark_list.add(new_shark);
						list[j][k].clear();
					}
				}
			}

			for (shark now_shark : shark_list) {
				list[now_shark.r][now_shark.c].add(now_shark);
			}
			refresh();

		}
		System.out.println(result);
	}

	private static shark shark_move(shark now) {
		int direction = now.d;
		int distance = now.s;

		if (now.r == 0 && direction == 1) {
			direction = 2;
		} else if (now.r == R - 1 && direction == 2) {
			direction = 1;
		} else if (now.c == C - 1 && direction == 3) {
			direction = 4;
		} else if (now.c == 0 && direction == 4) {
			direction = 3;
		}

		int nr = now.r;
		int nc = now.c;

		while (distance != 0) {
			nr = nr + dr[direction];
			nc = nc + dc[direction];
			
			if (nr < R && nr >= 0 && nc < C && nc >= 0) {
				distance--;
//				nr += dr[direction];
//				nc += dc[direction];
			} else {
//				distance++;

				if (direction == 1) {
					nr -= dr[direction];
					nc -= dc[direction];
					direction = 2;
				} else if (direction == 2) {
					nr -= dr[direction];
					nc -= dc[direction];
					direction = 1;
				} else if (direction == 3) {
					nr -= dr[direction];
					nc -= dc[direction];
					direction = 4;
				} else if (direction == 4) {
					nr -= dr[direction];
					nc -= dc[direction];
					direction = 3;
				}
			}
		}
		now.d = direction;
		now.r = nr;
		now.c = nc;

		return now;
	}

	private static void refresh() {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (list[i][j].size() > 1) {
					int max_size = 0;
					shark max_shark = null;

					for (shark temp : list[i][j]) {
						if (max_size < temp.z) {
							max_size = Math.max(max_size, temp.z);
							max_shark = temp;
						}
					}

					list[i][j].clear();
					list[i][j].add(max_shark);
				}

			}
		}
	}

	static class shark {
		int r, c, s, d, z;

		public shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}