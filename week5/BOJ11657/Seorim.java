package week5.BOJ11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Seorim {

    static List<int[]> graph;
    static int MAX = 10000 * 6000 + 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numNode = Integer.parseInt(st.nextToken());
        int numEdge = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < numEdge; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.add(new int[]{u, v, w});
        }

        long[] dist = new long[numNode+1];
        Arrays.fill(dist, MAX);

        boolean isNegativeCycle = timeMachine(dist, numNode);
        StringBuilder sb = new StringBuilder();
        if (isNegativeCycle) {
            sb.append(-1);
        } else {
            for (int i=2; i<=numNode; i++)
                sb.append((dist[i] < MAX) ? dist[i] : -1).append('\n');
        }

        System.out.println(sb);
    }

    private static boolean timeMachine(long[] dist, int numNode) {
        dist[1] = 0;

        for (int i = 1; i <= numNode; i++) {
            for (int[] edge : graph) {
                int curr = edge[0];
                int next = edge[1];
                int cost = edge[2];

                if (dist[curr] < MAX && dist[curr] + cost < dist[next]) {
                    dist[next] = dist[curr] + cost;
                    if (i == numNode) return true;
                }
            }
        }

        return false;
    }

}
