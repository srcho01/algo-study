package week4.BOJ4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Seorim {

    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        setPrime();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            sb.append(countPrime(n)).append("\n");
        }

        System.out.println(sb);
    }

    private static void setPrime() {
        int num = 123456 * 2 + 1;
        prime = new boolean[num];
        Arrays.fill(prime, true);
        prime[1] = false;

        for(int i=2; i<prime.length; i++)
            for(int j=i*2; j<prime.length; j+=i)
                prime[j] = false;
    }

    private static int countPrime(int n) {
        int cnt = 0;
        for (int i=n+1; i<=2*n; i++)
            cnt += prime[i] ? 1 : 0;

        return cnt;
    }

}
