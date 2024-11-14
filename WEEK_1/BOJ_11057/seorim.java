import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] d = new int[n][10];
        for (int i = 0; i < 10; i++) {
            d[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum = (d[i-1][j] + sum) % 10007;
                d[i][j] = sum;
            }
        }

        System.out.println(Arrays.stream(d[n-1]).sum() % 10007);
    }
}