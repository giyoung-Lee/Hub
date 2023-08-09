import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<Value> heap = new PriorityQueue<>();
		
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			
			if (k == 0) {
				if(!heap.isEmpty()) {
					result.add(heap.poll().real);
				} else {
					result.add(0);
				}
			} else {
				heap.add(new Value(k, Math.abs(k)));
			}
		}
		
		for (int data : result) {
			System.out.println(data);
		}

	}
	
}

class Value implements Comparable<Value>{
	int real;
	int abs;
	
	Value(int real, int abs) {
		this.real = real;
		this.abs = abs;
	}
	
	@Override
	public int compareTo(Value other) {
		if (Math.abs(this.real) ==  Math.abs(other.real)) {
			return Integer.compare(this.real, other.real);
		}
		
		return Integer.compare(Math.abs(this.real), Math.abs(other.real));
	}
}



