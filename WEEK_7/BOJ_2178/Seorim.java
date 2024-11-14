package week7.BOJ2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Seorim {

    static int n, m;
    static int[][] maze;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        for (int i=0; i<n; i++) {
            String line = br.readLine();
            for (int j=0; j<m; j++) {
                if (line.charAt(j) == '1') {
                    maze[i][j] = -1;
                }
            }
        }

        bfs();
        System.out.println(maze[n-1][m-1]);

    }

    static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        maze[0][0] = 1;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if (maze[nx][ny] == -1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

}
