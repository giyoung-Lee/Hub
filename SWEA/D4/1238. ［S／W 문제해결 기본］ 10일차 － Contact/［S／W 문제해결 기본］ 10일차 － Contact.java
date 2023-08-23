import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    /**
     * D4 1238 문제해결 기본 10일차 - Contact
     *
     * bfs를 통해 문제를 해결하였습니다.
     * 저는 클래스를 선언해주고, 이를 이용해서 풀이하였는데,
     * visited 배열을 처리하는곳에서 애를 먹었습니다.
     *
     * 메모리 : 20,748 kb
     * 시간 : 126 ms
     *
     */

    // 필요한 변수들 선언
    static int N, start;              // 정점 수와 시작 정점
    static List<Node> arr;            // 간선 정보를 저장하는 리스트
    static int max;                   // 최대 카운트 값
    static boolean[] visited;         // 정점 방문 여부를 저장하는 배열
    static int[] count;               // 카운트 값을 저장하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = 10;  // 테스트 케이스 수
        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            arr = new ArrayList<>();
            max = 0;
            visited = new boolean[101];
            count = new int[101];

            // 간선 정보 입력
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                arr.add(new Node(from, to, 0));
            }

            bfs(start);  // BFS 탐색 수행

            int result = 0;
            // 최대 카운트 값과 일치하는 경우 중에서 최대 'to' 값을 찾음
            for (Node temp : arr) {
                if (temp.count == max) {
                    result = Math.max(result, temp.to);
                }
            }

            System.out.println("#" + test + " " + result);
        }
    }

    public static void bfs(int start) {
        Queue<Node> q = new ArrayDeque<>();
        // 시작 정점과 연결된 간선을 큐에 추가하고 방문 표시
        for (Node temp : arr) {
            if (temp.from == start) {
                temp.count = 1;
                // 이부분이 없어도 코드가 돌아가는데,
                // 아마 제약사항에 한번 연락받은 사람에게 다시 연락을 하는일이 없다.
                // 라는 부분때문에 없어도 되는것 같습니다. 만약 그 조건이없을때
                // 아래 방문처리를 하지않으면 아마 최초 사이클이 발생했을때의 예외 처리가 안될것입니다.
                visited[temp.from] = true;
                q.add(temp);
            }
        }

        visited[start] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            // 현재 정점과 연결된 간선을 확인하여 방문하지 않은 경우 카운트 증가 후 큐에 추가
            for (Node node : arr) {
                if (now.to == node.from && !visited[node.to]) {
                    node.count = now.count + 1;
                    visited[node.to] = true;
                    q.offer(node);
                }
            }
        }

        // 모든 간선에 대한 탐색이 끝난 후, 최대 카운트 값을 찾음
        for (Node temp : arr) {
            max = Math.max(temp.count, max);
        }
    }

    // 간선 정보를 저장하는 클래스
    static class Node {
        int from, to, count;

        public Node(int from, int to, int count) {
            this.from = from;
            this.to = to;
            this.count = count;
        }
    }
}