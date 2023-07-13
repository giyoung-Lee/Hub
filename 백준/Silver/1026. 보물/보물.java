import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    /**
     * <pre>
     *     백준 1026번 보물
     *     https://www.acmicpc.net/problem/1026
     *
     *     정수가 담겨있는 두 배열 A * B가 있다.
     *     이 배열의 index가 같은 값끼리 곱하여 더한 값이 최소가 되야하는데,
     *     그러기 위해서는 한 배열은 오름차순으로 정렬을 하고, 나머지 한 배열은 내림차순으로 정렬을하여
     *     곱해주면 최소값을 구할 수 있을것입니다.
     *
     *     문제에서는 배열 A는 정렬하되, B는 정렬하지 말라 하였지만
     *     최소값일 경우를 구하는게 아니라 최소값을 구하는 것이므로
     *     사실상 정렬해도 상관없다고 생각합니다.
     *
     *     !!! 알게된점 !!!
     *     !! java에서 int타입은 기본자료형(primitive type)이고,
     *     Integer는 객체 타입(object type) 으로 comparable 인터페이스를 구현하고 있습니다.
     *
     *     그렇기 때문에, int로 배열을 지정하면 Arrays.sort()와 Collections.reverseOrder()를
     *     함께 사용할 수 없지만, Integer로 선언하게 되면 정렬을 사용할 수 있습니다. !!
     *
     *     좀 더 자세하게 알고 싶다면 Comparable 인터페이스가 정의하고 있는 단일 메서드인
     *     compareTo() 를 알아보면 좋을것 같습니다.
     *
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();

        Integer[] A = new Integer[n];
        Integer[] B = new Integer[n];

        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            B[i] = scanner.nextInt();
        }

        Arrays.sort(A);
        // 배열 내림차순으로 정렬
        Arrays.sort(B, Collections.reverseOrder());


        int sum = 0;
        // 결과를 구함
        for (int i = 0; i < n; i++) {
            sum += A[i] * B[i];
        }


        System.out.println(sum);
    }
}
