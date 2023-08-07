import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    /**
     * BJ 2493 탑
     *
     * Stack 자료구조를 아주 잘 활용해야 합니다....
     * 값을 입력받고, 뒤에서 부터 push, pop 하는 등의 경우를 생각했지만
     * 너무 복잡하였고,
     *
     * 입력받은 스택을 복사(clone)해서 하나씩 깎아가며 비교하려고했으나,
     * 메모리 초과 처분을 받았으며....
     *
     * 배열로 처리해보려고 하였으나, 시간초과를 받았습니다.....
     * 
     * 그래서 결론은
     * 해결 방법
     * 1. 앞에서부터 탑을 쌓아가고, 
     * 2. 스택에 마지막에 쌓여있는 값이 그 뒷 값보다 작은 경우는 pop하여 비교대상에서 제외하고
     * ( 더이상 전파를 받을 수 없음 )
     * -> 그 뒷값이 더 크다는것은, 그뒤의 탑은 적어도 그 탑에서 걸리게됨.
     *
     * 3. 만약 현재 스택에 있는 값이 담을 탑의 크기보다 크다면,
     * 큰 탑의 위치를 출력하기위해 저장해주고 Stack에 담음
     * 
     * Ex) 9 가 Stack에 들어있는데, 7이 들어있다면 Stack에 저장해서
     * 9, 7 인상태이가 될 것이고, "이 뒤에 들어올 값의 경우는"
     * 
     * 1. 7보다 작을경우, (당연히 7에 전파가 닿기때문에 7의 index를 출력 및 그 탑을 Stack에 저장)
     * -> 왜냐하면, 7보다 작은 값이지만, 더 작은값이 또 뒤에 올 수도 있거든
     * 
     * 2. 7보다 크지만, 9보다 작은경우 (7은 무시하고, 9의 인덱스를 출력)
     * -> 7? 비켜 / 9? 죄송합니다. -> 9의 index 저장
     * 
     * 3. 9보다 큰경우 -> 7? 비켜. / 9? 너도 비켜. -> 전파를 받을 탑이 없음. -> 0
     * 
     * 9보다 큰 탑이 들어온 경우에 그 탑이 기준이 되고, 또 계속 비교함
     *
     *
     */

    public static void main(String[] args) throws IOException{
        // 버퍼를 쓰지않으면 무조건 메모리 초과됨;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N
        int N = Integer.parseInt(st.nextToken());

        // 스택
        Stack<Top> stack = new Stack<>();
        // 정답을 담을 스트링 빌더
        StringBuilder answer = new StringBuilder();
        // 한줄 읽어서
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            // 비교하려는 현재 높이
            int height = Integer.parseInt(st.nextToken());

            // 스택이 비어있다면, 비교할 대상이 없으므로 0
            if (stack.isEmpty()) {
                answer.append("0 ");
                // index 번호 i 와 현재 높이 height를 넣어줌
                stack.push(new Top(i, height));
            } else {
                // 비어있지 않다면
                while (true) {
                    // 아래 if문을 돌고와서 비어있을 수 있기 때문에
                    if (stack.isEmpty()) { // 스택이 비어있다면, 0을 출력하고 탑을 push
                        answer.append("0 ");
                        stack.push(new Top(i, height));
                        break;
                    }

                    // 현재 스택에 가장 마지막 값 슬쩍 보고
                    Top top = stack.peek();

                    if (top.height > height) { // peek한 탑의 높이가 현재 탑의 높이보다 높다면,
                        answer.append(top.num + " "); // peek한 탑의 번호를 출력하고,
                        stack.push(new Top(i, height)); // 현재 탑을 스택에 push
                        break;
                    } else { // peek한 탑의 높이가 현재 탑의 높이보다 낮다면,
                        // 전파를 막는 높이가 아니기 때문에, 비교할 필요가없으므로
                        stack.pop(); // 스택에서 pop하고 다시 반복문을 돌린다.
                    }
                }
            }
        }
        bw.write(answer.toString() + "\n");
        bw.flush();
    }
}

// 스택에 자료를 한번에 넣기 위해 Top 클래스를 만들어서 사용
// num은 index, height는 말 그대로 높이
class Top {
    int num;
    int height;

    Top(int num, int height) {
        this.num = num;
        this.height = height;
    }
}