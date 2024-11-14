package week6.BOJ2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] cheese;
    static boolean[][] outside;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cheese = new int[n][m];
        outside = new boolean[n][m];

        int numCheese = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
                if (cheese[i][j] == 1) numCheese++;
            }
        }

        System.out.println(melting(numCheese));
    }

    static int melting(int numCheese) {
        int hour = 0;
        while (numCheese > 0) {
            List<int[]> disappear = new ArrayList<>();

            findOutside();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (cheese[i][j] == 1) { // 치즈 찾기
                        // 공기와 맞닿은 면 세기
                        int airCount = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k], ny = j + dy[k];
                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (cheese[nx][ny] == 0 && outside[nx][ny]) airCount++;
                        }

                        // 공기와 2면 이상 맞닿으면 치즈 녹일 곳으로 지정
                        if (airCount >= 2) {
                            disappear.add(new int[]{i, j});
                        }

                    }
                }
            }

            // 치즈 녹이기
            numCheese -= disappear.size();
            for (int[] point: disappear) {
                cheese[point[0]][point[1]] = 0;
            }

            hour++;
        }

        return hour;
    }

    static void findOutside() {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Arrays.fill(outside[i], false);
        }

        queue.offer(new int[]{0, 0});
        outside[0][0] = true;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nx = point[0] + dx[k], ny = point[1] + dy[k];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

                if (cheese[nx][ny] == 0 && !outside[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    outside[nx][ny] = true;
                }
            }
        }
    }

}
