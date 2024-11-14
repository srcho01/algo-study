package week3.BOJ2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Seorim {

    static int START = 0;
    static int MAX = (int) 1e9;

    static int n;
    static int[][] cost;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n][(1 << n)];
        for(int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);

        System.out.println(tsp(START, 1));
    }

    private static int tsp(int curr, int visited) {
        if (visited == (1<<n)-1) return (cost[curr][START] != 0) ? cost[curr][START] : MAX;
        if (dp[curr][visited] != -1) return dp[curr][visited];

        dp[curr][visited] = MAX; // 초기화

        for (int i = 0; i < n; i++)
            if ((visited >> i & 1) == 0 && cost[curr][i] != 0)
                dp[curr][visited] = Math.min(dp[curr][visited], cost[curr][i] + tsp(i, visited | (1 << i)));

        return dp[curr][visited];
    }

}