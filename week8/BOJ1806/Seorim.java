package week8.BOJ1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Seorim {

    static int[] seq;
    static int MAX_LEN = 100_000 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        seq = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            seq[i] = seq[i-1] + Integer.parseInt(st.nextToken());
        }

        System.out.println(prefixSum(n, s));
    }

    static int prefixSum(int n, int s) {
        int len = MAX_LEN;
        int pt1 = 1, pt2 = 1;

        while (pt1 <= n && pt2 <= n) {
            int currSum = seq[pt2] - seq[pt1 -1];

            if (currSum >= s) {
                len = Math.min(len, pt2 - pt1 + 1);
                pt1++;
            } else {
                pt2++;
            }

        }

        return len == MAX_LEN ? 0 : len;
    }

}
