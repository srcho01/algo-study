package week9.BOJ9019;

import java.io.*;
import java.util.*;

public class Seorim {

    static char[] command = {'D', 'S', 'L', 'R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            bw.write(bfs(x, y));
            bw.newLine();
        }

        bw.flush();
    }

    static String bfs(int start, int target) {
        boolean[] visited = new boolean[10000];
        Queue<Item> q = new LinkedList<>();
        q.add(new Item(start, ""));
        visited[start] = true;

        while (!q.isEmpty()) {
            Item item = q.poll();

            if (item.num == target) {
                return item.cmd;
            }

            for (char cmd: command) {
                int converted = DSLR(item.num, cmd);
                if (!visited[converted]) {
                    q.add(new Item(converted, item.cmd + cmd));
                    visited[converted] = true;
                }
            }
        }

        return "";
    }


    static int DSLR(int num, char cmd) {
        if (cmd == 'D') {
            return num * 2 % 10000;
        } else if (cmd == 'S') {
            return num == 0 ? 9999 : num - 1;
        } else if (cmd == 'L') {
            return (num % 1000) * 10 + (num / 1000);
        } else if (cmd == 'R') {
            return (num / 10) + (num % 10) * 1000;
        }

        return 0;
    }

    static class Item {
        int num;
        String cmd;

        Item(int num, String cmd) {
            this.num = num;
            this.cmd = cmd;
        }
    }

}
