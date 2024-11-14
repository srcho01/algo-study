package week10.BOJ16562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Seorim {

    static int[] friendFee;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        friendFee = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            friendFee[i] = Integer.parseInt(st.nextToken());
        }

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            uf.union(v, w);
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (uf.parent[i] == i) {
                sum += uf.cost[i];
            }
        }

        System.out.println(sum <= k ? sum : "Oh no");
    }


    static class UnionFind {
        int[] parent;
        int[] cost;

        public UnionFind(int size) {
            this.parent = new int[size+1];
            for (int i = 0; i <= size; i++) {
                parent[i] = i;
            }

            this.cost = new int[size+1];
            for (int i = 0; i <= size; i++) {
                cost[i] = friendFee[i];
            }
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX < rootY) {
                parent[rootY] = rootX;
                cost[rootX] = Math.min(cost[rootX], cost[rootY]);
            } else {
                parent[rootX] = rootY;
                cost[rootY] = Math.min(cost[rootY], cost[rootX]);
            }

        }

        public int find(int node) {
            while (parent[node] != node) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }

            return node;
        }

    }
}
