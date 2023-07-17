import java.util.Scanner;

public class Main {
    /**
     * <pre>
     * 백준 1138번 한 줄로 서기
     * https://www.acmicpc.net/problem/1138
     *
     * </pre>
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 키의 순서를 저장할 배열
        int[] order = new int[N];

        for (int i = 0; i < N; i++) {
            int taller = sc.nextInt();

            // order 배열을 순회하면서 taller보다 큰 수가 나오면
            // 해당 위치에 키를 삽입한다.
            for (int j = 0; j < N; j++) {
                if (taller == 0 && order[j] == 0) {
                    order[j] = i + 1;
                    break;
                } else if (order[j] == 0) {
                    taller--;
                }
            }
        }

        // order 배열을 순회하면서 줄을 선 순서대로 키를 출력한다.
        for (int i = 0; i < N; i++) {
            System.out.print(order[i] + " ");
        }
    }
}
