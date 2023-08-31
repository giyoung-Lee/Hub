import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            long num = (long) Math.pow(a, b);
            long result =1;

            for (int j = 1; j <= b; j++)
            {
                result = result * a % 10;
            }

            // 0일 경우 10으로 처리
            result = result == 0 ? 10 : result;

            System.out.println(result);
        }

    }
}