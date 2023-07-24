import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 단어의 개수 N 입력
        sc.nextLine(); // 개행 문자 제거

        int count = 0; // 그룹 단어의 개수를 세는 변수

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine(); // 단어 입력 받기
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count); // 그룹 단어의 개수 출력

        sc.close();
    }

    // 그룹 단어인지 판별하는 메소드
    public static boolean isGroupWord(String word) {
        boolean[] visited = new boolean[26]; // 알파벳 소문자 개수만큼 방문 여부를 저장할 배열
        char prev = ' '; // 이전 문자를 저장할 변수

        for (char c : word.toCharArray()) {
            if (prev != c) { // 이전 문자와 다른 문자인 경우
                if (visited[c - 'a']) { // 이미 방문한 문자인 경우 그룹 단어가 아님
                    return false;
                }
                visited[c - 'a'] = true; // 방문 체크
            }
            prev = c; // 이전 문자를 현재 문자로 업데이트
        }

        return true; // 그룹 단어인 경우 true 반환
    }
}

