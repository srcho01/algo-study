package week9.BOJ6236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Seorim {

    static int n, m;
    static int[] withdraw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        withdraw = new int[n];
        int start = -1;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            withdraw[i] = num;
            if (num > start) start = num;
        }

        System.out.println(binarySearch(start));
    }

    static int binarySearch(int start) {
        int mid = 0;
        int end = 0;
        for (int x: withdraw) {
            end += x;
        }

        while (start < end) {
            mid = (start + end) / 2;

            int cnt = count(mid);

            if (cnt <= m) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int count(int k) {
        int cnt = 0;
        int curr = 0;
        for (int i = 0; i < n; i++) {
            if (withdraw[i] <= curr) {
                curr -= withdraw[i];
            } else {
                curr = k - withdraw[i];
                cnt++;
            }
        }

        return cnt;
    }

}
