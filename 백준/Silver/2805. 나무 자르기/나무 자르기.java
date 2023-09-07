import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = -1;
        int min = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }


        while(min <= max) {
            int mid = (min+max) / 2;
            long temp = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] > mid){
                    temp += arr[i] - mid;
                }
            }

            if (temp>= M) {
                min = mid+1;
            } else {
                max = mid-1;
            }
        }

        System.out.println(max);

    }
}