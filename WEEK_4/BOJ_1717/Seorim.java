package week4.BOJ1717;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Seorim {

    static int[] set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        set = new int[n+1];
        for (int i = 1; i <= n; i++)
            set[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (cmd) {
                case 0:
                    union(a, b);
                    break;
                case 1:
                    sb.append(isSame(a, b)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int find(int x) {
        while (x != set[x]) {
            set[x] = set[set[x]];
            x = set[x];
        }

        return x;
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot < bRoot)
            set[bRoot] = aRoot;
        else
            set[aRoot] = bRoot;
    }

    private static String isSame(int a, int b) {
        return (find(a) == find(b)) ? "YES" : "NO";
    }

}