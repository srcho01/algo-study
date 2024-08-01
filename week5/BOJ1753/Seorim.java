package week5.BOJ1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static List<Item>[] graph;
    static int MAX = (int) 1e6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numNode = Integer.parseInt(st.nextToken());
        int numEdge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        graph = new ArrayList[numNode+1];
        for (int i = 0; i <= numNode; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < numEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Item(v, w));
        }

        int[] dist = dijkstra(numNode, start);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=numNode; i++) {
            sb.append(dist[i] == MAX ? "INF" : dist[i]).append("\n");
        }
        System.out.println(sb);

    }

    static private int[] dijkstra(int numNode, int start) {
        boolean[] visited = new boolean[numNode+1];
        int[] dist = new int[numNode+1];
        Arrays.fill(dist, MAX);
        PriorityQueue<Item> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Item(start, 0));

        while (!pq.isEmpty()) {
            Item item = pq.poll();
            if (visited[item.node()]) continue;

            int curr = item.node();
            int weight = item.weight();

            visited[item.node()] = true;

            for (Item next: graph[curr]) {
                if (!visited[next.node()]) {
                    dist[next.node()] = Math.min(dist[next.node()], weight + next.weight());
                    pq.offer(new Item(next.node(), dist[next.node()]));
                }
            }
        }

        return dist;
    }
}

class Item implements Comparable<Item> {
    private final int node;
    private final int weight;

    public Item(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int weight() {
        return weight;
    }

    public int node() {
        return node;
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(this.weight, o.weight);
    }
}
