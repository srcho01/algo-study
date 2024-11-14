package week11.BOJ3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static int[][] map;
    static Map<Integer, Character> command;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 우하좌상

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            map[x][y] = 2;
        }

        command = new HashMap<>();
        int l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            command.put(x, c);
        }

        System.out.println(snakeGame(n));
    }

    static int snakeGame(int n) {
        int[] head = {0, 0};
        int[] tail = {0, 0};
        map[head[0]][head[1]] = 1;

        Queue<Integer> tailDirection = new LinkedList<>();
        int headDirection = 0;

        int time = 0;
        while (true) {
            time++;

            int nx = head[0] + dir[headDirection][0];
            int ny = head[1] + dir[headDirection][1];

            // wall or body
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 1) {
                return time;
            }

            // add direction
            tailDirection.add(headDirection);

            // no apple - tail remove
            if (map[nx][ny] == 0) {
                map[tail[0]][tail[1]] = 0;
                int polled = tailDirection.poll();
                tail[0] += dir[polled][0]; tail[1] += dir[polled][1];
            }

            // move head
            map[nx][ny] = 1;
            head[0] = nx; head[1] = ny;

            // change direction
            if (command.containsKey(time)) {
                char c = command.get(time);
                if (c == 'L') {
                    headDirection = (headDirection + 3) % 4;
                } else {
                    headDirection = (headDirection + 1) % 4;
                }
            }
        }
    }

}
