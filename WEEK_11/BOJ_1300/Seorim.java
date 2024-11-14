package week11.BOJ1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seorim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1;
        int end = k;
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(mid / i, n);
            }

            if (cnt >= k) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
    }

}
