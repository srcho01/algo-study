package week10.BOJ3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Seorim {

    static int[][] map;
    static int n, m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        int x = 0, y = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);

                switch (c) {
                    case 'D':
                        map[i][j] = -1;
                        break;
                    case '*':
                        map[i][j] = 0;
                        q.offer(new int[]{i, j, 0});
                        break;
                    case 'S':
                        x = i; y = j;
                    case '.':
                        map[i][j] = 10000;
                }
            }
        }

        water(q);
        int ret = bfs(x, y);
        System.out.println(ret == -1 ? "KAKTUS" : ret);
    }

    static void water(Queue<int[]> q) {
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int cx = point[0], cy = point[1];
            int time = point[2];

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k], ny = cy + dy[k];
                if ((0 <= nx && nx < n && 0 <= ny && ny < m) && map[nx][ny] == 10000) {
                    map[nx][ny] = time + 1;
                    q.offer(new int[]{nx, ny, time + 1});
                }
            }
        }
    }

    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int cx = point[0], cy = point[1];
            int time = point[2];

            time++;
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k], ny = cy + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (map[nx][ny] == -1) {
                    return time;
                }

                if (!visited[nx][ny] && time < map[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, time});
                }
            }
        }

        return -1;
    }

}
