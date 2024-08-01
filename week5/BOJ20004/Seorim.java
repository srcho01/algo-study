package week5.BOJ20004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Seorim {

    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        for (int n=1; n<=a; n++) {
            dp = new int[32];
            Arrays.fill(dp, -1);
            if (canWin(0, n) == 1) {
                System.out.println(n);
            }
        }

    }

    private static int canWin(int now, int n) {

        if (now == 31) return 0;
        if (dp[now] != -1) return dp[now];

        int ret = 1;
        for (int i=1; i<=n; i++) {
            if (now + i > 31) continue;

            ret = Math.min(ret, 1 - canWin(now + i, n));
        }

        dp[now] = ret;
        return ret;
    }

}
