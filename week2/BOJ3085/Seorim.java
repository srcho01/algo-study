import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Seorim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        char[][] candy = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = new StringTokenizer(br.readLine()).nextToken();
            for (int j = 0; j < n; j++) {
                candy[i][j] = s.charAt(j);
            }
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                ans = Math.max(ans, maxCandy(candy, i, j, i, j+1));
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n-1; i++) {
                ans = Math.max(ans, maxCandy(candy, i, j, i+1, j));
            }
        }

        System.out.println(ans);
    }

    public static int maxCandy(char[][] candy, int i1, int j1, int i2, int j2) {
        swap(candy, i1, j1, i2, j2);

        int ret = 0;
        char prev;
        int cnt;

        for (int i=i1; i<=i2; i++) {
            prev = 'a';
            cnt = 1;
            for (int j=0; j<candy[i].length; j++) {
                if (candy[i][j] == prev) {
                    cnt++;
                } else {
                    prev = candy[i][j];
                    ret = Math.max(ret, cnt);
                    cnt = 1;
                }
            }
            ret = Math.max(ret, cnt);
        }

        for (int j=j1; j<=j2; j++) {
            prev = 'a';
            cnt = 1;
            for (int i=0; i<candy[j].length; i++) {
                if (candy[i][j] == prev) {
                    cnt++;
                } else {
                    prev = candy[i][j];
                    ret = Math.max(ret, cnt);
                    cnt = 1;
                }
            }
            ret = Math.max(ret, cnt);
        }

        swap(candy, i1, j1, i2, j2);

        return ret;
    }

    public static void swap(char[][] candy, int i1, int j1, int i2, int j2) {
        char tmp = candy[i1][j1];
        candy[i1][j1] = candy[i2][j2];
        candy[i2][j2] = tmp;
    }
}