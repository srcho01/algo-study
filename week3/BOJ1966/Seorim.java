package week3.BOJ1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Integer> doc = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                doc.add(Integer.parseInt(st.nextToken()));
            }

            int cnt = 0;
            while (!doc.isEmpty()) {
                int x = doc.poll();

                if (isPrincipal(x, doc)) {
                    if (m == 0) {
                        System.out.println(++cnt);
                        break;
                    } else {
                        m--;
                        cnt++;
                    }
                } else {
                    doc.add(x);
                    m = m == 0 ? doc.size() - 1 : m - 1;
                }

            }

        }

    }

    private static boolean isPrincipal(int target, Queue<Integer> q) {
        for(int i: q)
            if (target < i)
                return false;
        return true;
    }

}
