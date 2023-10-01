import java.io.*;
import java.util.*;

public class Main {
    static int[][] map; // 학생들의 좌석 배열
    static HashMap<Integer, Integer[]> hashMap = new HashMap<>(); // 학생별 선호하는 친구 목록
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 좌석의 크기
        map = new int[n][n];

        for (int i = 0; i < n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int studentId = Integer.parseInt(st.nextToken());
            int friend1 = Integer.parseInt(st.nextToken());
            int friend2 = Integer.parseInt(st.nextToken());
            int friend3 = Integer.parseInt(st.nextToken());
            int friend4 = Integer.parseInt(st.nextToken());

            // 학생의 선호 친구 목록을 해시맵에 저장
            hashMap.put(studentId, new Integer[]{friend1, friend2, friend3, friend4});

            // 현재 학생의 좌석 배치
            placeStudent(studentId);
        }

        // 만족도 계산
        int satisfaction = calculateSatisfaction();
        System.out.println(satisfaction);
    }

    // 학생을 좌석에 배치하는 메서드
    public static void placeStudent(int studentId) {
        Integer[] friends = hashMap.get(studentId);
        int friend1 = friends[0];
        int friend2 = friends[1];
        int friend3 = friends[2];
        int friend4 = friends[3];

        ArrayList<Integer[]> emptySeats = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                int friendCount = 0;
                int emptyCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];

                    if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map.length)
                        continue;

                    int now = map[nextY][nextX];

                    if (now == friend1 || now == friend2 || now == friend3 || now == friend4)
                        friendCount++;

                    if (now == 0)
                        emptyCount++;
                }

                emptySeats.add(new Integer[]{friendCount, emptyCount, i, j});
            }
        }

        // 좌석 배치 기준 정렬
        Collections.sort(emptySeats, new Comparator<>() {
            @Override
            public int compare(Integer[] seat1, Integer[] seat2) {
                if (seat1[0] < seat2[0]) return 1;
                else if (seat1[0] == seat2[0]) {
                    if (seat1[1] < seat2[1]) return 1;
                    else if (seat1[1] == seat2[1]) {
                        if (seat1[2] > seat2[2]) return 1;
                        else if (seat1[2] == seat2[2]) {
                            return Integer.compare(seat1[3], seat2[3]);
                        }
                    }
                }
                return -1;
            }
        });

        // 첫 번째 빈 자리에 학생 배치
        for (Integer[] seat : emptySeats) {
            int y = seat[2];
            int x = seat[3];

            if (map[y][x] == 0) {
                map[y][x] = studentId;
                return;
            }
        }
    }

    // 만족도 계산 메서드
    public static int calculateSatisfaction() {
        int sum = 0;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                int count = 0;
                Integer[] friends = hashMap.get(map[i][j]);

                for (int k = 0; k < 4; k++) {
                    int nextY = i + dy[k];
                    int nextX = j + dx[k];

                    if (nextY < 0 || nextX < 0 || nextY >= map.length || nextX >= map.length)
                        continue;

                    int now = map[nextY][nextX];

                    // 상,하,좌,우가 친구면 count 증가
                    for (int p = 0; p < 4; p++)
                        if (now == friends[p]) count++;
                }

                // count 개수에 따라 sum 증가
                switch (count) {
                    case 1:
                        sum += 1;
                        break;
                    case 2:
                        sum += 10;
                        break;
                    case 3:
                        sum += 100;
                        break;
                    case 4:
                        sum += 1000;
                        break;
                }
            }
        }

        return sum;
    }
}