import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	/**
	 * BJ 15686 치킨 배달
	 * https://www.acmicpc.net/problem/15686
	 * 
	 * 저는 좌표를 저장할 수 있는 클래스를 만들고,
	 * 그 클래스를 리스트에 넣어서 치킨집 리스트와 그냥 집 리스트를 가지고
	 * 치킨집 리스트를 조합으로 M만큼 경우의 수를 뽑아서
	 * 각 집에서 갈 수 있는 최소값을 저장해 답으로 출력하였습니다.
	 * 
	 * 메모리 : 18052 KB
	 * 시간 : 224 ms
	 * 
	 */
	
	static int N;
	static int M;
	// 치킨집
	static List<data> dat;
	// 집 
	static List<data> house;
	// 치킨집 조합을 담을 배열
	static data[] temp;
	// 정답 초기화
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dat = new ArrayList<data>();
		house = new ArrayList<data>();

		// 집일경우와 치킨집일 경우를 찾아서 add
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp_n = Integer.parseInt(st.nextToken());

				if (temp_n == 2) {
					dat.add(new data(i, j));
				} else if (temp_n == 1) {
					house.add(new data(i, j));
				}
			}
		}
		
		// M 크기의 치킨집을 담을 배열
		temp = new data[M];
		// 시작
		combi(0, 0);
		System.out.println(ans);

	}

	static void combi(int size, int cnt) {
		// 기저조건. nCm에서 m이 채워지면
		if (size == M) {
			int sum = 0;
			// 집 전부를 돌아
			for(data now_house : house) {
				// 치킨집
				int chick_min = Integer.MAX_VALUE;
				
				// 집에서 갈 수 있는 조합에 담긴 치킨집의 모든 경우를 비교함
				for(data now_dat : temp) {
					chick_min = Math.min((Math.abs(now_house.x - now_dat.x) + Math.abs(now_house.y - now_dat.y)), chick_min); 
				}
				// 최소값을 sum에 더함
				sum += chick_min;
			}
			// 최종 정답보다 더 작다면 갱신
			if (sum < ans) {
				ans = sum;
			}

			return;
		}

		for (int i = cnt; i < dat.size(); i++) { // 조합 구하기
			temp[size] = dat.get(i);
			combi(size + 1, i + 1);
		}
	}
}

// 좌표를 넣을 클래스
class data {
	int x;
	int y;

	public data(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
