import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /**
     * 백준 18310 안테나
     * https://www.acmicpc.net/problem/18310
     * 
     * 그리디 알고리즘을 가볍게 풀어보고자 그리디 항목에서
     * 한문제 골라봤습니다.
     * 
     * 문제의 아이디어는 어떤 상황에서든 집들중 가운데 있는집에
     * 안테나를 설치하는것이 모든 집까지의 거리의 총합이 가장 작을 것
     * 이라는 것입니다. 정렬을 한 뒤, 홀수 짝수에 맞게 가운데 값을 출력해 주었습니다.
     *
     *
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (arr.length % 2 == 0) {
            System.out.println(arr[N/2 - 1]);
        } else {
            System.out.println(arr[N/2]);
        }
    }
}