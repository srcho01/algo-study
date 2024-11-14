package week8.BOJ4386;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static List<double[]> coordinate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        coordinate = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coordinate.add(new double[]{Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken())});
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(i, j));
            }
        }
        Collections.sort(edges);

        System.out.println(kruskal(n, edges));
    }

    static double kruskal(int n, List<Edge> edges) {
        UnionFind uf = new UnionFind(n);
        double cost = 0;

        for (Edge edge : edges) {
            if (!uf.isSame(edge.u, edge.v)) {
                cost += edge.cost;
                uf.union(edge.u, edge.v);
            }
        }

        return cost;
    }

    static class UnionFind {
        int[] parent;

        public UnionFind(int size) {
            this.parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            while (parent[node] != node) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }

            return parent[node];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }

        public boolean isSame(int x, int y) {
            return find(x) == find(y);
        }
    }

    static class Edge implements Comparable<Edge> {
        int u;
        int v;
        double cost;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
            this.cost = dist(u, v);
        }

        private double dist(int u, int v) {
            return Math.sqrt(Math.pow(coordinate.get(u)[0] - coordinate.get(v)[0], 2) + Math.pow(coordinate.get(u)[1] - coordinate.get(v)[1], 2));
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(cost, o.cost);
        }
    }

}
