package week3.BOJ1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Seorim {

    static int[] seq;
    static int cnt = 0;
    static int n;
    static int targetSum;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        targetSum = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        seq = new int[n];
        for (int i = 0; i < n; i++)
            seq[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        System.out.println(cnt);

    }

    private static void dfs(int curr, int currSum) {
        if (curr == n) return;

        if (currSum + seq[curr] == targetSum) cnt++;

        dfs(curr + 1, currSum); // 이번 원소 포함시키고 다음으로
        dfs(curr + 1, currSum + seq[curr]); // 이번 원소 포함 안 시키고 다음으로
    }
}