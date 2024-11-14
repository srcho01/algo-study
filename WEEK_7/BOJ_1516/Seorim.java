package week7.BOJ1516;

import java.io.*;
import java.util.*;

public class Seorim {

    static Set<Integer>[] order;
    static int[] inDegree;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        time = new int[n];
        inDegree = new int[n];

        order = new HashSet[n];
        for (int i = 0; i < n; i++) {
            order[i] = new HashSet<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) break;
                order[i].add(x-1);
            }

            inDegree[i] = order[i].size();
        }

        topology(n);
        for (int t: time) {
            bw.write(String.valueOf(t));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static void topology(int n) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                inDegree[i]--;
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            updateInDegree(n, curr);

            for (int i = 0; i < n; i++) {
                if (inDegree[i] == 0) {
                    queue.offer(i);
                    time[i] += maxTime(i);
                    inDegree[i]--;
                }
            }
        }
    }

    static void updateInDegree(int n, int building) {
        for (int i = 0; i < n; i++) {
            if (order[i].contains(building)) {
                inDegree[i]--;
            }
        }
    }

    static int maxTime(int building) {
        int max = -1;

        for (int needToPrev: order[building]) {
            max = Math.max(max, time[needToPrev]);
        }

        return max;
    }

}
