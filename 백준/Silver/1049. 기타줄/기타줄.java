import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * <pre>
     * 백준 1049번 기타줄
     * https://www.acmicpc.net/problem/1049
     * 사야하는 기타줄을 가장 저렴하게 구매해야합니다.
     *
     * 기타줄을 구매하는 경우는
     * 1. 패키지로만 구매하기
     * 2. 낱개로만 구매하기
     * 3. 패키지와 낱개로 구매하기
     * 이와같이 3가지 방법이 있습니다.
     *
     * 상식적으로 저렴하게 구매하려면, 패키지가 되었건 낱개가 되었건
     * 가장 저렴한곳에서 구매하는게 이상적입니다.
     *
     * 그러니, 입력받아 배열에 저장되어있는 값을 정렬해줍니다.
     *
     * 정렬을 마친뒤에 기타줄을 구매하는 3가지 경우에 수에 대하여 값을 구합니다.
     * 각 방법에서 구한 최소값 3가지를 가지고 그중에서도 가장 작은값을 고르면
     * 문제에서 원하는 최소값을 구할 수 있을것입니다.
     *
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        int[] packageP = new int[m];
        int[] singleP = new int[m];

        for (int i = 0; i < m; i++) {
            packageP[i] = scanner.nextInt();
            singleP[i] = scanner.nextInt();
        }

        //정렬해줍니다. 최솟값을 맨 앞으로 보내기 위해서
        Arrays.sort(packageP);
        Arrays.sort(singleP);

        // 패키지만 살경우, 낱개만 살경우, 섞어서, 몫, 몫2
        int onlyPackege, onlySingle, mix, num, num2;

        // 패키지만 구매할경우 필요한 패키지의 수를 구하기 위함
        if (n%6 != 0) {
            num = (n/6) + 1;
        } else {
            num = (n/6);
        }
        
        num2 = (n/6);

        onlyPackege = num * packageP[0];
        onlySingle = n * singleP[0];
        mix = (num2 * packageP[0]) + (n % 6) * singleP[0];

        // 3개중 최솟값을 구함. 한줄에 출력하기 위해 Math.min을 두번 사용
        int result = Math.min(onlyPackege, Math.min(onlySingle, mix));
        System.out.println(result);

    }
}
