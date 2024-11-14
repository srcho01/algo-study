package week10.BOJ1738;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Seorim {

    static int n, m;
    static List<int[]> graph;

    static int[] dist;
    static int[] prevNode;

    static int MIN = -1000 * 20000;
    static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        prevNode = new int[n+1];
        dist = new int[n+1];
        Arrays.fill(dist, MIN);

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new int[] {u, v, cost});
        }

        bellman();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n+1];
        path(list, visited, n);
        for (int i = list.size()-1; i >= 0; i--) {
            bw.write(String.valueOf(list.get(i)));
            bw.write(' ');
        }

        bw.flush();
    }

    static void bellman() {
        dist[1] = 0;

        for (int loop = 1; loop <= n; loop++) {
            for (int[] edge: graph) {
                int curr = edge[0];
                int next = edge[1];
                int cost = edge[2];

                if (dist[curr] != MIN && (dist[next] < dist[curr] + cost || dist[curr] == MAX)) {
                    dist[next] = dist[curr] + cost;
                    prevNode[next] = curr;
                    if (loop == n) {
                        dist[next] = MAX;
                    }
                }
            }
        }
    }

    static void path(List<Integer> list, boolean[] visited, int node) {
        if (node == 0) return;

        if (visited[node]) {
            list.clear();
            list.add(-1);
            return;
        }

        list.add(node);
        visited[node] = true;

        path(list, visited, prevNode[node]);
    }

}
