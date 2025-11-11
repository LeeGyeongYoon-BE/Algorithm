import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String[] input = st.nextToken().split("");
        
        int result = 0;
        for (int i = 0; i < n; i++) {
        	result += Integer.parseInt(input[i]);
        } // for
        System.out.println(result);
	} // main

} // class
