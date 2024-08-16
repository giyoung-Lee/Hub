import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            String[] tokens = input.split(" ");

            if (tokens.length == 1) {
                int val = Integer.parseInt(tokens[0]);

                if (val == 2) {
                    if (stack.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(stack.pop());
                    }
                } else if (val == 3) {
                    System.out.println(stack.size());
                } else if (val == 4) {
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                } else if (val == 5) {
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                }

            } else {
                int code = Integer.parseInt(tokens[0]);
                int val = Integer.parseInt(tokens[1]);

                stack.push(val);
            }
        }

    }
}