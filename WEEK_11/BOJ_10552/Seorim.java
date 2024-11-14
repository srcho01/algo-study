package week11.BOJ10552;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Seorim {

    static Map<Integer, Integer> tv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int curr = Integer.parseInt(st.nextToken());

        tv = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int fav = Integer.parseInt(st.nextToken());
            int hated = Integer.parseInt(st.nextToken());

            if (!tv.containsKey(hated)) {
                tv.put(hated, fav);
            }
        }

        boolean[] visited = new boolean[m+1];
        int cnt = 0;
        while (true) {
            if (visited[curr]) {
                cnt = -1;
                break;
            }

            visited[curr] = true;
            if (tv.containsKey(curr)) {
                curr = tv.get(curr);
                cnt++;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }

}
