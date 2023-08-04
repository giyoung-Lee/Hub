import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Queue q = new ArrayDeque<>();
		
		
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		
		while (q.size() != 1) {
			int tmp = 0;
			q.poll();
			tmp = (int) q.poll();
			q.offer(tmp);
		}
		System.out.println(q.poll());
	}
}
