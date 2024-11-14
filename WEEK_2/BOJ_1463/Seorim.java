import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int[] d = new int[x+1];
        d[1] = 0;

        for(int i=2; i<=x; i++) {
            d[i] = d[i-1] + 1;

            if(i % 3 == 0)
                d[i] = Math.min(d[i/3] + 1, d[i]);
            if(i % 2 == 0)
                d[i] = Math.min(d[i/2] + 1, d[i]);
        }

        System.out.println(d[x]);

    }
}