package week3.BOJ1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static Map<Integer, ArrayList<Integer>> matrix = new HashMap<>(); // Adjacency matrix
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numNode = Integer.parseInt(st.nextToken());
        int numEdge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= numNode; i++)
            matrix.put(i, new ArrayList<>());

        for (int i = 0; i < numEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            matrix.get(u).add(v);
            matrix.get(v).add(u);
        }

        for (ArrayList<Integer> list : matrix.values())
            Collections.sort(list);


        boolean[] visited = new boolean[numNode+1];
        dfs(start, visited);
        sb.append("\n");
        bfs(start, numNode);

        System.out.println(sb);
    }


    private static void dfs(int node, boolean[] visited) {
        sb.append(node).append(" ");
        visited[node] = true;

        for(int next: matrix.get(node)) {
            if (!visited[next]) {
                dfs(next, visited);
            }
        }
    }

    private static void bfs(int start, int numNode) {
        boolean[] visited = new boolean[numNode+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(visited[curr]) continue;

            visited[curr] = true;
            sb.append(curr).append(" ");

            for(int next: matrix.get(curr)) {
                if(!visited[next])
                    queue.add(next);
            }
        }
    }
}
