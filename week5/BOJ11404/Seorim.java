package week5.BOJ11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Seorim {

    static int MAX = 100_000 * 100 + 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] graph = new int[n][n];
        for (int[] row : graph)
            Arrays.fill(row, MAX);
        for (int i = 0; i < n; i++)
            graph[i][i] = 0;

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(graph[a][b], c);
        }

        floyd(graph, n);

        StringBuilder sb = new StringBuilder();
        for (int[] row : graph) {
            for (int val : row)
                sb.append((val >= MAX) ? 0 : val).append(' ');
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static private void floyd(int[][] graph, int n) {
        for (int stopover = 0; stopover < n; stopover++)
            for (int start = 0; start < n; start++)
                for (int end = 0; end < n; end++)
                    graph[start][end] = Math.min(graph[start][end], graph[start][stopover] + graph[stopover][end]);
    }

}
