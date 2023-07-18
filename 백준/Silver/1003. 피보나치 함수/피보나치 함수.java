import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        int[][] d = new int[41][2];

        d[0][0] = 1;
        d[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            d[i][0] = d[i - 1][0] + d[i - 2][0];
            d[i][1] = d[i - 1][1] + d[i - 2][1];
        }

        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            System.out.println(d[n][0] + " " + d[n][1]);
        }
    }
}