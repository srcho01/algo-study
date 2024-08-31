package week9.BOJ2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static int n;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        map = new int[n][n];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                set.add(a);
            }
        }

        int ret = 1;
        for (int water: set) {
            ret = Math.max(ret, safeArea(water));
        }

        System.out.println(ret);
    }

    static int safeArea(int water) {
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] > water) {
                    bfs(visited, i, j, water);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static void bfs(boolean[][] visited, int x, int y, int water) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int cx = polled[0];
            int cy = polled[1];

            for (int k=0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if ((0 <= nx && nx < n && 0 <= ny && ny < n) && !visited[nx][ny] && map[nx][ny] > water) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

}
