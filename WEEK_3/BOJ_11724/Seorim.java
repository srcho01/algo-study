package week3.BOJ11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numNode = Integer.parseInt(st.nextToken());
        int numEdge = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<Integer>> matrix = new HashMap<>();
        for (int i = 1; i <= numNode; i++)
            matrix.put(i, new ArrayList<>());

        for (int i = 0; i < numEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            matrix.get(u).add(v);
            matrix.get(v).add(u);
        }

        boolean[] visited = new boolean[numNode+1];
        int cnt = 0;
        for (int i = 1; i <= numNode; i++) {
            if (!visited[i]) {
                dfs(i, visited, matrix);
                cnt++;
            }
        }

        System.out.println(cnt);
    }


    private static void dfs(int start, boolean[] visited, Map<Integer, ArrayList<Integer>> matrix) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);

        while(!stack.isEmpty()) {
            int curr = stack.pop();
            if(visited[curr]) continue;

            visited[curr] = true;

            for(int next: matrix.get(curr)) {
                if(!visited[next])
                    stack.push(next);
            }
        }
    }
}