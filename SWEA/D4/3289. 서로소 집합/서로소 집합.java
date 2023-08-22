import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, M;
	static int parents[];
	
	private static void make() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			// 모든 요소는 자기만 원소로 갖는 단위의 서로소 집합이 되게 한다.
			// (자신이 곧 대표자인 루트로 표현)
			parents[i] = i; 
		}
	}
	
	private static int find(int a) {
		if (a == parents[a]) {
			return a;
		}
		// path compression
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		// a가 속한 집합과 b가 속한 집합을 합치고
		// 합칠수 있다면 합치고 true 반환
		// 아니면 false 반환
		int aRoot = find(a);
		int bRoot = find(b);
		
		// 서로의 대표자가 같은 집합의 상황이므로, union하지 않음
		if (aRoot == bRoot) {
			return false;
		}
		
		// union 처리(bRoot를 aRoot아래로 붙이기 (임의로))
		parents[bRoot] = aRoot;
		return true;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test=1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			StringBuilder sb = new StringBuilder();
			sb.append("#"+test+" ");
			make();
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if (num == 0) {
					union(a, b);
				} else {
					if (find(a) == find(b)) {
						sb.append("1");
					} else {
						sb.append("0");
					}
				}
				
			}
			System.out.println(sb);
		}
	}
}
