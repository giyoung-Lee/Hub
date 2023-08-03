import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력값 받아오기
        int S_length = sc.nextInt(); // DNA 문자열 길이 |S|
        int P_length = sc.nextInt(); // 비밀번호로 사용할 부분문자열의 길이 |P|
        sc.nextLine(); // 개행 문자 제거

        String DNA_string = sc.nextLine(); // DNA 문자열
        String[] min_count = sc.nextLine().split(" "); // 부분문자열에 포함되어야 할 문자의 최소 개수들

        // 가능한 비밀번호 종류 계산하기
        // 가능한 비밀번호 개수를 저장할 변수
        int count = 0;

        // DNA 문자열에 대한 문자별 개수를 저장하는 배열
        int[] countArray = new int[4];
        int left = 0;
        int right = left + P_length -1;

        // 부분문자열의 첫번째 인덱스부터 시작하여 P_length만큼의 부분문자열을 검사
        for (int i = 0; i < P_length; i++) {
            char currentChar = DNA_string.charAt(i);
            switch (currentChar) {
                case 'A':
                    countArray[0]++;
                    break;
                case 'C':
                    countArray[1]++;
                    break;
                case 'G':
                    countArray[2]++;
                    break;
                case 'T':
                    countArray[3]++;
                    break;
            }
        }

        while (true) {
            // 비밀번호로 사용 가능한 경우인지 체크
            if (countArray[0] >= Integer.parseInt(min_count[0]) &&
                    countArray[1] >= Integer.parseInt(min_count[1]) &&
                    countArray[2] >= Integer.parseInt(min_count[2]) &&
                    countArray[3] >= Integer.parseInt(min_count[3])) {
                count++;
            }

            if (right +1 == S_length) {
                break;
            }

            // 왼쪽 포인터를 1 증가 시키기 위한 처리
            if(DNA_string.charAt(left)=='A') {
                countArray[0] --;
            } else if (DNA_string.charAt(left)=='C') {
                countArray[1] --;
            } else if (DNA_string.charAt(left)=='G') {
                countArray[2] --;
            } else if (DNA_string.charAt(left)=='T') {
                countArray[3] --;
            }
            
            // 왼쪽 포인터 증가
            left ++;

            // 오른쪽 포인터 증가하시키기
            right += 1;
            if(DNA_string.charAt(right)=='A') {
                countArray[0] ++;
            } else if (DNA_string.charAt(right)=='C') {
                countArray[1] ++;
            } else if (DNA_string.charAt(right)=='G') {
                countArray[2] ++;
            } else if (DNA_string.charAt(right)=='T') {
                countArray[3] ++;
            }
        }
        System.out.println(count);
    }
}