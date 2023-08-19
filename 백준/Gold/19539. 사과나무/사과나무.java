import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int wartering_can = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            int temp = arr[i];
            if (temp % 2 == 1) {
                wartering_can++;
            }
            sum += temp;
        }

        if (sum % 3 == 0 && wartering_can <= sum/3) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}