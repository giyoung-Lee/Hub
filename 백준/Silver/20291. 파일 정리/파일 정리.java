import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            StringBuilder str = new StringBuilder();
            String temp2 = "";
            int count = 0;

            for (int j = 0; j < temp.length; j++) {
                if (temp[j].equals(".")) {
                    count = j+1;

                    for (int k = count; k < temp.length; k++) {
                        str.append(temp[k]);
                    }
                    temp2 = str.toString();
                    break;
                }
            }

            if (map.containsKey(temp2)) {
                map.put(temp2, map.get(temp2) + 1);
            } else {
                map.put(temp2, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}