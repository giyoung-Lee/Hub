import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[100][100];

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    arr[j][k] = 1;
                }
            }
        }

        int count = 0;
        for (int[] num1 : arr) {
            for (int num2 : num1) {
                if (num2 == 1) {
                    count ++;
                }
            }
        }
        System.out.println(count);
    }
}
