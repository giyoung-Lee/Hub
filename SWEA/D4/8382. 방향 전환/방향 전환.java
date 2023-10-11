import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int dx = Math.abs(x1 - x2);
			int dy = Math.abs(y1 - y2);

			int min = Math.min(dx, dy);
			int diff = Math.abs(dx - dy);
			
			int temp = 0;
			while(diff > 0) {
				if (diff %2 == 1) {
					temp += 1;
					diff--;
				} else {
					temp += 3;
					diff--;
				}
			}

			int result = min * 2 + temp;
			System.out.println("#" + test + " " + result);
		}

	}
}