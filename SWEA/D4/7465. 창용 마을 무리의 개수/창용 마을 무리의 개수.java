import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    static int[] parent;
    static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int test = 1; test <= T; test++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 사람 수
            M = Integer.parseInt(st.nextToken()); // 관계 수

            // Union-Find 데이터 구조 초기화
            UnionFind(N);

            int[][] relationships = new int[M][2];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                relationships[i][0] = Integer.parseInt(st.nextToken());
                relationships[i][1] = Integer.parseInt(st.nextToken());
            }

            // 무리의 개수 계산
            int result = countGroups(N, relationships);

            System.out.println("#" + test + " " + result);
        }
    }

    // 무리의 개수를 계산하는 함수
    public static int countGroups(int N, int[][] relationships) {
        int groups = N; // 처음에는 각 사람이 자신의 무리이므로 N개의 무리가 존재한다고 가정

        for (int[] relationship : relationships) {
            int person1 = relationship[0] - 1; // 배열 인덱스와 번호의 차이를 조정
            int person2 = relationship[1] - 1;

            int root1 = find(person1);
            int root2 = find(person2);

            if (root1 != root2) {
                // 두 사람이 다른 무리에 속해 있을 경우 두 무리를 합침
                union(root1, root2);
                groups--; // 무리의 개수를 하나 줄임
            }
        }

        return groups;
    }

    // Union-Find 데이터 구조 초기화 함수
    public static void UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 초기에는 자기 자신을 부모로 가리킴
            rank[i] = 0;   // 초기 랭크는 0으로 설정
        }
    }

    // 원소가 속한 집합의 대표 원소를 찾는 함수
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // 경로 압축(Path Compression)을 통해 루트를 찾음
        }
        return parent[x];
    }

    // 두 집합을 합치는 함수
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
