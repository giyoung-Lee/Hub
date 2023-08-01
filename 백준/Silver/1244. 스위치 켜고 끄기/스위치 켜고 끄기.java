import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            arr[i] = sc.nextInt();
        }

        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {

            // 1. 남 2. 여
            int gender = sc.nextInt();
            // switch
            int sw = sc.nextInt();

            if (gender == 1) {
                // 스위치 번호를 저장
                // 하지만, 스위치는 1부터 시작하고, 배열은 0부터 이므로 하나 빼줌
                int now = sw;
                // 범위동안
                while (now <= n) {
                    // 해당 번호의 스위치가 1이면 0으로
                    if (arr[now] == 1) {
                        arr[now] = 0;
                    } else if (arr[now] == 0) { // 해당 번호의 스위치가 0이면 1로
                        arr[now] = 1;
                    }
                    // 남자는 해당받은 스위치 번호의 배수를 전부 바꿔줘야 하므로
                    now = now + sw;
                }
            } else if (gender == 2) {   // 여자일때
                int now = sw;  
                int L = now - 1;     // 왼쪽
                int R = now + 1;     // 오른쪽
                while (L >= 1 && R <= n && arr[L] == arr[R]) {  // 확장된 양옆 값이 같다면 더 확장 시도
                    L--;
                    R++;
                }
                // 정리된 범위로 값을 갱신
                for (int j = L + 1; j < R; j++) {
                    if (arr[j] == 0) {
                        arr[j] = 1;
                    } else if (arr[j] == 1) {
                        arr[j] = 0;
                    }
                }
            }

        }
        // 출력인데, 20줄 넘어가면 줄바꿈 해주고 출력
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i]+" ");
            if ((i)%20 == 0) {
                System.out.println();
            }
        }
    }
}