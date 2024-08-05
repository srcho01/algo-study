package week6.BOJ11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Seorim {

    static char[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];
        for (int i = 0; i < 12; i++) {
            field[i] = br.readLine().toCharArray();
        }

        System.out.println(puyo());

    }

    static int puyo() {
        int cnt = 0;

        while (pang()) {
            falling();
            cnt++;
        }

        return cnt;
    }

    static boolean pang() {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[12][6];
        boolean isPang = false;

        // 뿌요 탐색
        for (int i=0; i<12; i++) {
            for (int j=0; j<6; j++) {
                if (!visited[i][j] && field[i][j] != '.') { // 뿌요 발견
                    Queue<int[]> queue = new LinkedList<>();
                    List<int[]> group = new ArrayList<>();

                    queue.offer(new int[]{i, j});
                    group.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) { // bfs : 그룹 탐색
                        int[] curr = queue.poll();

                        for (int k=0; k<4; k++) {
                            int nx = curr[0] + dx[k], ny = curr[1] + dy[k];
                            if (nx < 0 || ny < 0 || nx >= 12 || ny >= 6) continue;

                            if (!visited[nx][ny] && field[nx][ny] == field[i][j]) {
                                queue.offer(new int[]{nx, ny});
                                group.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }

                    if (group.size() >= 4) {
                        isPang = true; // 뿌요 터트리기
                        for(int[] point: group) {
                            field[point[0]][point[1]] = '.';
                        }
                    }
                }
            }
        }

        return isPang;
    }

    static void falling() {
        for (int j = 0; j < 6; j++) {

            Queue<Character> col = new LinkedList<>();
            for (int i = 11; i >= 0; i--) {
                if (field[i][j] != '.') {
                    col.add(field[i][j]);
                }
                field[i][j] = '.'; // 초기화
            }

            int i = 11;
            while (!col.isEmpty()) {
                char color = col.poll();
                field[i--][j] = color;
            }

        }
    }

}
