package week9.BOJ3482;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Seorim {

    static int[][] map;
    static int c, r;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());

            map = new int[r][c];

            for (int j = 0; j < r; j++) {
                String line = br.readLine();
                for (int k = 0; k < c; k++) {
                    map[j][k] = line.charAt(k) == '#' ? 0 : 1;
                }
            }

            bw.write("Maximum rope length is ");
            bw.write(String.valueOf(labyrinth()));
            bw.write('.');
            bw.newLine();
        }

        bw.flush();
    }

    static int labyrinth() {
        int[] pointX = new int[2];

        Loop:
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 1) { // pointX
                    pointX[0] = i;
                    pointX[1] = j;
                    break Loop;
                }
            }
        }

        int[] pointY = bfs(pointX[0], pointX[1]);
        int[] pointZ = bfs(pointY[0], pointY[1]);
        return pointZ[2];
    }

    static int[] bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        q.add(new int[]{x, y, 0});
        visited[x][y] = true;

        int[] ret = new int[]{x, y, 0};

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int cx = point[0];
            int cy = point[1];
            int cd = point[2];

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;

                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cd+1});

                    if (cd + 1 > ret[2]) {
                        ret[0] = nx; ret[1] = ny;
                        ret[2] = cd + 1;
                    }
                }
            }
        }

        return ret;
    }

}
