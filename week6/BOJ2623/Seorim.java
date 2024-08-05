package week6.BOJ2623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static int[] inDegree;
    static List<Integer>[] order;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        inDegree = new int[n+1];

        order = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            order[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            int curr = Integer.parseInt(st.nextToken());
            int prev = curr;

            for (int j = 2; j <= k; j++) {
                curr = Integer.parseInt(st.nextToken());
                inDegree[curr]++;
                order[prev].add(curr);
                prev = curr;
            }
        }

        StringBuilder sb = new StringBuilder();
        List<Integer> list = topology(n);
        for (int i: list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    static List<Integer> topology(int n) {

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
            }
        }

        while(!queue.isEmpty()) {

            int curr = queue.poll();
            list.add(curr);

            for(int next: order[curr]) {
                if (!visited[next] && --inDegree[next] == 0) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }

        if (list.size() < n) {
            List<Integer> newList = new ArrayList<>();
            newList.add(0);
            return newList;
        } else {
            return list;
        }
    }

}
