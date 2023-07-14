import java.util.Scanner;

public class Main {
    /**
     * <pre>
     *     백준 1057번 토너먼트
     *     https://www.acmicpc.net/problem/1057
     *     
     *     토너먼트를 진행해 가면서 김지민과 임한수가 언제 만날지 구하는 문제입니다.
     *     핵심 아이디어
     *     1. n강 전이 끝나면 2/n강전이 된다.
     *     2. 1을 더한뒤 2로 나눈 몫이 다음 대진 순번이 된다.
     *     ( 1의 경우 -> 1+1 / 2 -> 1
     *       2의 경우 -> 2+1 / 2 -> 1
     *       3의 경우 -> 3+1 / 2 -> 2
     *       4의 경우 -> 4+1 / 2 -> 2
     *       ....................... )
     *       
     *      그렇기 때문에 (num + 1) / 2의 연산을 계속 진행하며
     *      라운드 카운팅을 해주고, 만약 지민과 한수가 값이 같아진다면
     *      서로 만나게 됩니다.
     *
     * </pre>
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 참가자 수
        int kim = scanner.nextInt(); // 김지민의 번호
        int im = scanner.nextInt(); // 임한수의 번호
        
        int round = 0; // 대결이 일어나는 라운드
        
        // 김지민과 임한수의 번호가 같아질 때까지 반복
        while (kim != im) {
            kim = (kim + 1) / 2; 
            im = (im + 1) / 2; 
            round++; 
        }

        System.out.println(round);

    }
}