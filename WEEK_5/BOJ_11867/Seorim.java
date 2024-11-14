package week5.BOJ11867;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Seorim {

    static int[][] dp = new int[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(game(n, m) == 1 ? "A" : "B");

    }

    private static int game(int box1, int box2) {

        if (box1 == 1 && box2 == 1) return 0;

        if (dp[box1][box2] != -1) return dp[box1][box2];

        int ret = 0;
        for (int i=1; i<box1; i++) {
            ret = Math.max(ret, 1 - game(i, box1-i));
        }

        for (int i=1; i<box2; i++) {
            ret = Math.max(ret, 1 - game(i, box2-i));
        }

        dp[box1][box2] = dp[box2][box1] = ret;
        return ret;
    }

}
