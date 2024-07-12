import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(daq(a%c, b, c));
    }

    private static long daq(long num, long cnt, long mod) {
        if (cnt == 1) {
            return num;
        }

        long half = daq(num, cnt/2, mod) % mod;
        long pow = (half * half) % mod;

        if (cnt % 2 == 0)
            return pow;
        else
            return (pow * num) % mod;
    }
}