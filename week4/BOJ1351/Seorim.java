package week4.BOJ1351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Seorim {

    static Map<Long, Long> d;
    static long p;
    static long q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        d = new HashMap<Long, Long>();
        d.put(0L, 1L);

        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        System.out.println(seq(n));
    }

    private static long seq(long i) {
        if (d.containsKey(i)) return d.get(i);

        d.put(i, seq(i/p) + seq(i/q));
        return d.get(i);
    }

}
