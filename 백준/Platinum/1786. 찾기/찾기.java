import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 텍스트와 패턴을 입력받음
        String text = br.readLine();
        String pattern = br.readLine();
        
        // search 함수를 호출하여 패턴을 텍스트에서 검색하고 결과를 dq에 저장
        ArrayDeque<Integer> dq = search(text, pattern); 
        
        // 검색 결과 중 첫 번째 값 출력
        System.out.println(dq.pollFirst());
        
        // 나머지 검색 결과 출력
        while (!dq.isEmpty()) {
            System.out.println(dq.pollFirst());
        }
    }
    
    // 패턴 문자열의 최대 일치 접두사 접미사 배열을 계산하는 함수
    public static int[] computeLPSArray(String pattern) {
        int len = 0;  // 패턴 내에서 일치한 문자 수
        int i = 1;

        int[] lps = new int[pattern.length()];
        lps[0] = 0;  // 첫 번째 문자는 항상 0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP 알고리즘을 사용하여 패턴을 텍스트에서 검색하는 함수
    public static ArrayDeque<Integer> search(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int textIndex = 0;
        int patternIndex = 0;
        int result = 0;  // 패턴이 텍스트에서 발견된 횟수를 저장
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        while (textIndex < text.length()) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                textIndex++;
                patternIndex++;
            }

            if (patternIndex == pattern.length()) {
                result++;  // 패턴이 텍스트에서 발견됨
                dq.offer((textIndex - patternIndex) + 1);  // 패턴의 시작 위치를 dq에 추가
                patternIndex = lps[patternIndex - 1];
            } else if (textIndex < text.length() && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0) {
                    patternIndex = lps[patternIndex - 1];
                } else {
                    textIndex++;
                }
            }
        }
        dq.offerFirst(result);  // 결과 횟수를 dq의 첫 번째 위치에 추가
        return dq;
    }
}