package week7.BOJ6497;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Seorim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numHouse = Integer.parseInt(st.nextToken());
            int numRoad = Integer.parseInt(st.nextToken());

            if (numHouse == 0 && numRoad == 0) break;

            List<Edge> graph = new ArrayList<>();
            int wholeCost = 0;
            for (int i = 0; i < numRoad; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                wholeCost += z;
                graph.add(new Edge(x, y, z));
            }

            int saving = kruskal(graph, numHouse, wholeCost);
            bw.write(String.valueOf(saving));
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static int kruskal(List<Edge> graph, int numHouse, int wholeCost) {
        UnionFind uf = new UnionFind(numHouse);
        Collections.sort(graph);

        int cost = 0;
        int cnt = 0;
        for (Edge edge : graph) {
            if (!uf.isSame(edge.u, edge.v)) {
                cost += edge.cost;
                cnt++;
                uf.union(edge.u, edge.v);
                if (cnt == numHouse-1) break;
            }
        }

        return wholeCost - cost;
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int numNode) {
            this.parent = new int[numNode];

            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
        }

        public void union(int x, int y) {
            int xRoot = findRoot(x);
            int yRoot = findRoot(y);

            if (xRoot < yRoot) parent[yRoot] = xRoot;
            else parent[xRoot] = yRoot;
        }

        public int findRoot(int node) {
            while (node != parent[node]) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }

            return node;
        }

        public boolean isSame(int x, int y) {
            return findRoot(x) == findRoot(y);
        }
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

}
