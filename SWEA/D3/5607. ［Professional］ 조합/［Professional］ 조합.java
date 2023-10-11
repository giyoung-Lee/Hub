import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        int p = 1234567891; // 모듈로 연산에 사용할 소수 p

        // 미리 계산된 팩토리얼 값 저장
        long[] factorial = new long[1000001];
        factorial[0] = 1;
        for (int i = 1; i <= 1000000; i++) {
            factorial[i] = (factorial[i - 1] * i) % p;
        }

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // 페르마의 소정리를 적용하여 역수 계산
            long rInverse = modPow(factorial[R], p - 2, p);
            long nMinusRInverse = modPow(factorial[N - R], p - 2, p);

            // 조합 계산
            long result = (factorial[N] * rInverse) % p;
            result = (result * nMinusRInverse) % p;

            System.out.println("#" + test + " " + result);
        }
    }

    // a^b % p 계산
    private static long modPow(long a, int b, int p) {
        long result = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * a) % p;
            }
            a = (a * a) % p;
            b /= 2;
        }
        return result;
    }
}