import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());
        for (int test = 1; test <= tc; test++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Integer[] arr= new Integer[N];
            int start = 0;
            int end = N-1;
            int result = -1;

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr, Collections.reverseOrder());
            while (start < end) {
                int tmp = arr[start] + arr[end];
                if (tmp > M) {
                    start ++;
                } else {
                    if (result < tmp) {
                        result = tmp;
                        end --;
                    } else {
                        end --;
                    }
                }

            }
            System.out.printf("#%d %d\n", test, result);
        }
    }
}
