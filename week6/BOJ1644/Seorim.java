package week6.BOJ1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Seorim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Long> prime = findPrimeCumulative(n);
        System.out.println(countPrimeSum(n, prime));

    }

    static List<Long> findPrimeCumulative(int n) {

        boolean[] eratos = new boolean[n+1];
        Arrays.fill(eratos, true);
        List<Long> prime = new ArrayList<>();
        prime.add(0L);

        for (int i=2; i<=n; i++) {
            if (eratos[i]) {
                for (int j=i*2; j<=n; j+=i) {
                    eratos[j] = false;
                }
                prime.add(prime.getLast() + i);
            }
        }

        return prime;
    }

    static int countPrimeSum(int n, List<Long> prime) {

        int cnt = 0;
        for (int i = 1; i < prime.size(); i++) {
            for (int j = i-1; j >= 0; j--) {
                long primeSum = prime.get(i) - prime.get(j);

                if (primeSum == n) cnt++;
                if (primeSum >= n) break;
            }
        }

        return cnt;
    }

}
