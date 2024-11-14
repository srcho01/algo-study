package week6.BOJ1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numComputer = Integer.parseInt(br.readLine());
        int numLine = Integer.parseInt(br.readLine());

        List<Edge> graph = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < numLine; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.add(new Edge(u, v, cost));
        }

        System.out.println(kruskal(numComputer, graph));


    }

    static int kruskal(int numComputer, List<Edge> graph) {
        UnionFind uf = new UnionFind(numComputer);
        int ret = 0;

        Collections.sort(graph);

        for (Edge edge : graph) {
            if (!uf.isSameSet(edge.u, edge.v)) {
                ret += edge.cost;
                uf.union(edge.u, edge.v);
            }
        }

        return ret;
    }

    static class UnionFind {
        int[] parents;

        public UnionFind(int size) {
            this.parents = new int[size+1];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        public int findRoot(int x) {
            while (parents[x] != x) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }

            return parents[x];
        }

        public void union(int u, int v) {
            int uRoot = findRoot(u);
            int vRoot = findRoot(v);

            if (uRoot < vRoot) {
                parents[vRoot] = uRoot;
            } else {
                parents[uRoot] = vRoot;
            }
        }

        public boolean isSameSet(int u, int v) {
            return findRoot(u) == findRoot(v);
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
            return Integer.compare(cost, o.cost);
        }
    }
}
