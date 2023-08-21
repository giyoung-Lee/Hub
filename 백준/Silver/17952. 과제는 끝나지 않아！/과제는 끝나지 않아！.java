import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 일감을 저장할 스택
        Stack<work> stack = new Stack<>();
        // 현재 일의 정보를 담을 변수
        int now_A = 0, now_T = 0;
        // 결과값
        int result = 0;
        
        // N분만큼 실행
        int N = Integer.parseInt(br.readLine());
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            
            // 입력받은 줄의 개수가 1개일때. 즉 0일때
            if (st.countTokens() == 1) {
                // 현재 일감이 0 0 상태가 아니면
                if(now_A !=0 && now_T != 0) {
                    // 현재 일감의 시간을 -1 해주고,
                    now_T --;
                    // 만약 0에 도달했다면 일을 끝냄
                    if (now_T == 0) {
                        // 결과값에 평가점수를 더해주고
                        result += now_A;
                        
                        // 스택이 비어있지 않다면 꺼내서 갱신해줌
                        if(!stack.isEmpty()) {
                            work temp = stack.pop();
                            now_A = temp.score;
                            now_T = temp.time;
                        } else {
                            // 스택이 비어있다면 0 과 0으로 초기화
                            now_A = 0;
                            now_T = 0;
                        }
                    }    
                }
                
            } else {    // 입력받은 줄의 개수가 1개가 아닐때, 즉 업무를 받았을 때
                // 사실상 num은 사용하지 않음
                int num = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                
                // 만약 T가 1이라면 그냥 바로 일처리를 하고 다음 분으로 넘어감
                if (T == 1) {
                    result += A;
                } else {    // T가 1이 아니라면?
                    
                    // 하던일이 있다면
                    if(now_A != 0 && now_T !=0) {
                        // 현재 하던일을 stack에 담아두고
                        stack.push(new work(now_A, now_T));
                        // 새로 받은 일을 시작
                        now_A = A;
                        now_T = T-1;
                        
                    // 하던일이 없다면
                    } else {
                        // 현재 일감 갱신
                        now_A = A;
                        now_T = T-1;
                    }
                }
            }
        }
        
        // 결과 출력
        System.out.println(result);
        
        
    }
    
    
    
    // 값을 저장하기 위한 클래스
    static class work {
        // 평가점수
        int score;
        // 걸리는 시간
        int time;
        
        public work(int score, int time) {
            super();
            this.score = score;
            this.time = time;
        }
    }
}