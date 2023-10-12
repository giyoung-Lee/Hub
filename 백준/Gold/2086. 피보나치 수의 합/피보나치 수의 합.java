import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long mod = 1_000_000_000; // 모듈러 연산에 사용할 값

        // a부터 b까지의 피보나치 수열 합을 계산하고 모듈러 연산을 적용하여 결과를 구함
        long result = (fibonacciSum(B, mod) - fibonacciSum(A - 1, mod) + mod) % mod;
        System.out.println(result);
    }

    // 두 행렬의 곱셈을 계산
    public static long[][] matrixMultiply(long[][] a, long[][] b, long mod) {
        int n = a.length;
        long[][] result = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // 모듈러 연산을 적용하여 곱셈 결과를 구함
                    result[i][j] = (result[i][j] + (a[i][k] * b[k][j]) % mod) % mod;
                }
            }
        }

        return result;
    }

    // 행렬을 거듭제곱하여 계산
    public static long[][] matrixPower(long[][] matrix, long exponent, long mod) {
        int n = matrix.length;
        if (exponent == 1) {
            return matrix;
        }

        if (exponent % 2 == 0) {
            long[][] halfPower = matrixPower(matrix, exponent / 2, mod);
            return matrixMultiply(halfPower, halfPower, mod);
        } else {
            long[][] halfPower = matrixPower(matrix, (exponent - 1) / 2, mod);
            long[][] temp = matrixMultiply(halfPower, halfPower, mod);
            return matrixMultiply(matrix, temp, mod);
        }
    }

    // 분할 정복을 사용하여 n번째 피보나치 수를 계산
    public static long fibonacci(long n, long mod) {
        if (n <= 1) {
            return n;
        }

        long[][] baseMatrix = {{1, 1}, {1, 0}};
        long[][] resultMatrix = matrixPower(baseMatrix, n - 1, mod);
        return resultMatrix[0][0];
    }

    // a부터 b까지의 피보나치 수열 합을 계산
    public static long fibonacciSum(long n, long mod) {
        return (fibonacci(n + 2, mod) - 1) % mod;
    }
}