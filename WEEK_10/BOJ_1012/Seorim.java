package week10.BOJ1012;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Seorim {

    static boolean[][] field;
    static int n, m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            field = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[x][y] = true;
            }

            bw.write(String.valueOf(countWorm()));
            bw.newLine();
        }

        bw.flush();
    }

    static int countWorm() {
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        field[x][y] = false;

        while (!q.isEmpty()) {
            int[] point = q.poll();
            int cx = point[0];
            int cy = point[1];

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if ((0 <= nx && nx < n && 0 <= ny && ny < m) && field[nx][ny]) {
                    field[nx][ny] = false;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

}
