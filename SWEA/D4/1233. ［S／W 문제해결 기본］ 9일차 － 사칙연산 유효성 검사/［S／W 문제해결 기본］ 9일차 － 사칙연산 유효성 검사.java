import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
        int T = 10;
        for (int test = 1; test <= 10; test++) {
    		st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	boolean flag = true;
        	
        	for(int i = 0; i < N; i ++ ) {
        		st = new StringTokenizer(br.readLine());
        		if (st.countTokens() > 2) {
        			int count = Integer.parseInt(st.nextToken());
        			String comand = st.nextToken();
        			if (isnumber(comand)) {
        				flag = false;
        				continue;
        			}
        		} else if (st.countTokens() == 2) {
        			int count = Integer.parseInt(st.nextToken());
        			String comand = st.nextToken();
        			if(!isnumber(comand)) {
        				flag = false;
        				continue;
        			}
        		}
        	}
        	if (flag) {
        		System.out.printf("#%d 1\n", test);	
        	} else {
        		System.out.printf("#%d 0\n", test);        		
        	}
        }
        
	}
	
	public static boolean isnumber(String st) {
		String[] simbol = {"+", "-", "/", "*"}; 
		for (int i = 0 ; i < 4; i++) {
			if (st.equals(simbol[i])) {
				return false;
			}
		}
		return true;
	}
}
