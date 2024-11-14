package week9.PROG92344;

import java.io.IOException;

public class Seorim {

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();

        int[][] board = new int[4][5];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = 5;
            }
        }

        int[][] skill = {
                {1,0,0,3,4,4},
                {1,2,0,2,3,2},
                {2,1,0,3,1,2},
                {1,0,1,3,3,1}
        };

        System.out.println(sol.solution(board, skill));
    }

    static class Solution {
        public int solution(int[][] board, int[][] skill) {
            n = board.length;
            m = board[0].length;

            int[][] imos = imos(board, skill);

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] + imos[i][j] > 0) cnt++;
                }
            }

            return cnt;
        }

        public int[][] imos(int[][] board, int[][] skill) {
            int[][] arr = new int[n+1][m+1];

            for(int[] s: skill) {
                int type = s[0] == 1 ? 1 : -1; // 적의 공격 = 1, 아군의 회복 = -1
                int r1 = s[1], c1 = s[2];
                int r2 = s[3], c2 = s[4];
                int degree = s[5];

                arr[s[1]][s[2]] += (-type) * degree;
                arr[s[3]+1][s[2]] += type * degree;
                arr[s[1]][s[4]+1] += type * degree;
                arr[s[3]+1][s[4]+1] += (-type) * degree;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    arr[i][j] += arr[i][j-1];
                }
            }

            for (int j = 0; j < m; j++) {
                for (int i = 1; i < n; i++) {
                    arr[i][j] += arr[i-1][j];
                }
            }

            return arr;
        }
    }

}
