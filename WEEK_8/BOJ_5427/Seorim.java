package week8.BOJ5427;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Seorim {

    static int[][] map;
    static int MAX = (int) 1e8;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            map = new int[h][w];
            int x = 0, y = 0;
            for (int j = 0; j < h; j++) {
                String line = br.readLine();
                for (int k = 0; k < w; k++) {
                    switch (line.charAt(k)) {
                        case '#':
                            map[j][k] = -1;
                            break;
                        case '*':
                            map[j][k] = 0;
                            break;
                        case '@':
                            x = j; y = k;
                        case '.':
                            map[j][k] = MAX;
                    }
                }
            }

            fire(w, h);
            int ret = escape(x, y, w, h);
            bw.write(ret != -1 ? String.valueOf(ret) : "IMPOSSIBLE");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }


    static int escape(int x, int y, int w, int h) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int cx = polled[0], cy = polled[1];
            int time = polled[2];

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
                    return time + 1;
                }

                if (!visited[nx][ny] && time + 1 < map[nx][ny]) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, time+1});
                }
            }
        }

        return -1;
    }

    static void fire(int w, int h) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                    q.add(new int[] {i, j, 0});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int x = polled[0], y = polled[1];
            int time = polled[2];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (0 <= nx && nx < h && 0 <= ny && ny < w && !visited[nx][ny] && map[nx][ny] > 0) {
                    map[nx][ny] = time+1;
                    q.add(new int[] {nx, ny, time+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }

}
