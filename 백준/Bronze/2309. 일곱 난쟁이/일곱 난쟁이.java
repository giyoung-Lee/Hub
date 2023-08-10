import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] N = new int[9];
    static int sum = 0;
    static int answer1 = 0, answer2 = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < N.length; i++) {
            N[i] = Integer.parseInt(br.readLine());
            sum += N[i]; // 난쟁이 키의 합을 계산
        }
        Arrays.sort(N); //

        for (int i = 0; i < N.length; i++) { // 핵심
            for (int j = i + 1; j < N.length; j++) {
                if (sum - N[i] - N[j] == 100) {
                    answer1 = N[i];
                    answer2 = N[j];
                }
            }
        }
        for (int i = 0; i < N.length; i++) {
            if (answer1 == N[i] || answer2 == N[i]) continue;
            System.out.println(N[i]);
        }
    }
}