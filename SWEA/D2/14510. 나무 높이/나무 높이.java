import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N;
    static int[] arr;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            max = 0;
            int even = 0;
            int odd = 0;
            int result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());

                max = Math.max(arr[i], max);
            }

            for (int i = 0; i < N; i++) {
                int temp = max - arr[i];

                even += temp / 2;
                odd += temp % 2;
            }

            while (odd + 1 < even) {
                even--;
                odd += 2;
            }

            if (odd + 1 == even) {
                result = odd + even + 1;
            } else if (odd > even) {
                result = (even) * 2 + ((odd - even) * 2 - 1);
            } else {
                result = odd + even;
            }
            System.out.println("#" + test + " " + result);
        }
    }
}