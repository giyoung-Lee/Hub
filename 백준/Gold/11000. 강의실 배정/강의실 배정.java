import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] intervals = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            intervals[i][0] = Integer.parseInt(st.nextToken());
            intervals[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // 시작 시간을 기준으로 정렬

        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.add(intervals[0][1]); // 첫 수업의 끝 시간을 큐에 추가

        for (int i = 1; i < N; i++) {
            int[] interval = intervals[i];
            int startTime = interval[0];
            int endTime = interval[1];

            // 현재 수업의 시작 시간이 가장 빠른 끝 시간보다 크면
            // 새로운 강의실이 필요하므로 큐에서 가장 빠른 끝 시간을 제거
            if (startTime >= endTimes.peek()) {
                endTimes.poll();
            }

            // 현재 수업의 끝 시간을 큐에 추가
            endTimes.add(endTime);
        }

        System.out.println(endTimes.size()); // 큐에 남아 있는 끝 시간의 개수가 필요한 강의실의 개수
    }
}