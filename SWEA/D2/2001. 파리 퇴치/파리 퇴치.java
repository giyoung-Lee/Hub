import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(sc.nextInt());
                }
                arr.add(row);
            }

            int result = 0;
            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {
                    int tmp = 0;
                    for (int a = i; a < i + m; a++) {
                        for (int b = j; b < j + m; b++) {
                            tmp += arr.get(a).get(b);
                        }
                    }
                    result = Math.max(result, tmp);
                }
            }

            System.out.println("#" + test_case + " " + result);
        }
    }
}