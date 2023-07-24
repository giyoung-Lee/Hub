import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

class Solution
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            long n = sc.nextLong(); // long 타입으로 입력 받음
            List<Pair> arr = new ArrayList<>();

            for (long i = 1; i <= (long) Math.sqrt(n); i++) { // long 타입으로 연산
                // 곱해서 n이 되는 두 수 찾기
                if (n % i == 0) {
                    arr.add(new Pair(i, n / i));
                }
            }

            for (int i = 0; i < arr.size(); i++) {
                Pair pair = arr.get(i);
                arr.set(i, new Pair(pair.x - 1, pair.y - 1));
            }

            long min = Long.MAX_VALUE; // long 타입의 최대값으로 초기화
            for (Pair pair : arr) {
                long sum = pair.x + pair.y; // long 타입으로 연산
                if (sum < min) {
                    min = sum;
                }
            }

            System.out.println("#" + test_case + " " + min);
        }

        sc.close();
    }

    static class Pair {
        long x; // long 타입으로 변경
        long y; // long 타입으로 변경

        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}