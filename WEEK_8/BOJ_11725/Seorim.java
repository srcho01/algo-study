package week8.BOJ11725;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Seorim {

    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[p].add(c);
            graph[c].add(p);
        }

        int[] ans = new int[n+1];
        boolean[] visited = new boolean[n+1];
        visited[1] = true;
        dfs(ans, visited, 1);

        for (int i = 2; i <= n; i++) {
            bw.write(String.valueOf(ans[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int[] ans, boolean[] visited, int curr) {
        for (int next: graph[curr]) {
            if (!visited[next]) {
                ans[next] = curr;
                visited[next] = true;
                dfs(ans, visited, next);
            }
        }
    }

}
