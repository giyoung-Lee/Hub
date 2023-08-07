import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		List<Integer> answer = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		while (q.size() > 0) {
			for (int i = 1; i < K; i ++) {
				int tmp = q.poll();
				q.offer(tmp);
			}
			
			answer.add(q.poll());
		}
		
		System.out.print("<");
		for (int i = 0; i < answer.size(); i ++) {
			if (i == answer.size()-1) {
				System.out.print(answer.get(i));				
			} else {
				System.out.print(answer.get(i) + ", ");				
			}
		}
		System.out.print(">");
		sc.close();
	}
}