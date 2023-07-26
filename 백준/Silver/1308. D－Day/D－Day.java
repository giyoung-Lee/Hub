import java.util.Scanner;

public class Main {
    /**
     * 백준 1308번 D-Day
     *
     * 날짜 계산을 하는 문제입니다.
     * 연 월 일로 표기된 날짜를 모두 일로 바꾸고,
     * 그값을 빼버리면됩니다.
     *
     * 예외로 1000년 이상 차이난다면 gg를 입력합니다.
     *
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int y1 = sc.nextInt();
        int m1 = sc.nextInt();
        int d1 = sc.nextInt();
        int y2 = sc.nextInt();
        int m2 = sc.nextInt();
        int d2 = sc.nextInt();

        int total1 = calcDay(y1, m1, d1);
        int total2 = calcDay(y2, m2, d2);

        if(y2 - y1 > 1000 || y2 - y1 == 1000 && (m1 < m2 || m1 == m2 && d1 <= d2)) {
            System.out.println("gg");
        } else {
            System.out.println("D-" + (total2 - total1));
        }
    }

    // 날짜 계산. 모든 연 월을 일 로 바꿈
    static int calcDay(int y, int m, int d){
        int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int days = 0;

        // 윤년일경우는 더해줌
        for(int i = 1; i < y; i++){
            days += 365 + checkYear(i);
        }

        // 마찬가지로 윤년일 경우 1 을 더해줌
        for(int i = 1; i < m; i++){
            if(i == 2) {
                days += checkYear(y);
            }
            days += day[i];
        }

        days += d;

        return days;
    }

    // 윤년인지 검사
    static int checkYear(int y){
        if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) return 1;
        else return 0;
    }
}
