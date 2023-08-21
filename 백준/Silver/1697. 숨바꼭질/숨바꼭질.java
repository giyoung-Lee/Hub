import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		result = 0;
		visited = new boolean[100001];
		
		if(N == K) {
			System.out.println(result);
		} else {
			bfs(N);			
			System.out.println(result);
		}
		
	}
	
	private static void bfs(int n) {
		Queue<position> q = new ArrayDeque();
		q.offer(new position(n, 0));
		visited[n] = true;
		
		while(!q.isEmpty()) {
			position temp = q.poll();
			
			int multiply = temp.now * 2;
			int plus = temp.now + 1;
			int minus = temp.now - 1;
			
			if (multiply == K || plus == K || minus == K) {
				result = temp.count+1;
				break;
			}
			
			if (multiply <= 100000 && !visited[multiply]) {
				q.offer(new position(multiply, temp.count+ 1));
				visited[multiply] = true;
			}
			
			if (plus <= 100000 && !visited[plus]) {
				q.offer(new position(plus, temp.count+ 1));
				visited[plus] = true;
			}
			
			if (0 <= minus &&  minus <= 100000 && !visited[minus]) {
				q.offer(new position(minus, temp.count+ 1));
				visited[minus] = true;
			}
			
		}
		
	}
	
	static class position {
		int now;
		int count;
		
		public position(int now, int count) {
			super();
			this.now = now;
			this.count = count;
		}
	}
}