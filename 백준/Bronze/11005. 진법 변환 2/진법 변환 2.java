import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        char[] result = new char[32];
        int index = 0;

        while (N > 0) {
            int remainder = N % B;
            if (remainder < 10) {
                result[index++] = (char) ('0' + remainder);
            } else {
                result[index++] = (char) ('A' + (remainder - 10));
            }
            N /= B;
        }

        for (int i = index - 1; i >= 0; i--) {
            bw.write(result[i]);
        }

        bw.flush();
        bw.close();
    }
}
