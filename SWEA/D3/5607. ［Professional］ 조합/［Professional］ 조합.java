import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        int p = 1234567891; // 모듈로 연산에 사용할 소수 p

        // 미리 계산된 팩토리얼 값 저장
        BigInteger[] factorial = new BigInteger[1000001];
        factorial[0] = BigInteger.ONE;
        for (int i = 1; i <= 1000000; i++) {
            factorial[i] = factorial[i - 1].multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(p));
        }

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            // 페르마의 소정리를 적용하여 역수 계산
            BigInteger rInverse = factorial[R].modPow(BigInteger.valueOf(p - 2), BigInteger.valueOf(p));
            BigInteger nMinusRInverse = factorial[N - R].modPow(BigInteger.valueOf(p - 2), BigInteger.valueOf(p));

            // 조합 계산
            BigInteger result = factorial[N];
            result = result.multiply(rInverse);
            result = result.multiply(nMinusRInverse);
            result = result.mod(BigInteger.valueOf(p));

            System.out.println("#" + test + " " + result);
        }
	}
}