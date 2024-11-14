package week9.BOJ16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static int n, l, r;
    static int[][] A;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        A = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(migration());
    }

    static int migration() {
        boolean flag;
        List<int[]> union = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;

        while (true) {
            flag = false;
            for (boolean[] row: visited) {
                Arrays.fill(row, false);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        union.clear();
                        int population = findUnion(union, visited, i, j);
                        if (union.size() > 1) {
                            flag = true;
                            move(population, union);
                        }
                    }
                }
            }

            if (!flag) break;
            cnt++;
        }

        return cnt;
    }

    static int findUnion(List<int[]> union, boolean[][] visited, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;
        int sum = A[x][y];

        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int cx = polled[0], cy = polled[1];

            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

                int diff = Math.abs(A[cx][cy] - A[nx][ny]);
                if (!visited[nx][ny] && (l <= diff && diff <= r)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    sum += A[nx][ny];
                }
            }
        }

        return sum / union.size();
    }

    static void move(int population, List<int[]> union) {
        for (int[] point: union) {
            int x = point[0], y = point[1];
            A[x][y] = population;
        }
    }

}
