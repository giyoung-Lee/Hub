import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static String[] arr;
    static String[] temp;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[C];
        temp = new String[L];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken();
        }

        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
        comb(0, 0);

    }

    public static void comb(int count, int start) {
        if (count == L) {
            boolean flag = true;
            int temp_count = 0;
            int temp_count2 = 0;
            for (int i = 0; i < L; i++) {
                if (temp[i].equals("a") || temp[i].equals("i") || temp[i].equals("u") || temp[i].equals("e")
                        || temp[i].equals("o")) {
                    temp_count++;
                } else {
                    temp_count2++;
                }
            }

            for (int i = 1; i < L; i++) {
                if (temp[i].compareTo(temp[i - 1]) < 0) {
                    flag = false;
                }
            }

            if (temp_count >= 1 && flag && temp_count2 >= 2) {
                for (int i = 0; i < temp.length; i++) {
                    System.out.print(temp[i]);
                }
                System.out.println();
            }

            return;
        }

        for (int i = start; i < C; i++) {
            if (visited[i]) {
                continue;
            }
            temp[count] = arr[i];
            visited[i] = true;
            comb(count + 1, i + 1);
            visited[i] = false;
        }
    }
}