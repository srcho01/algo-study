package week4.BOJ11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Seorim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd > 0) {
                pq.add(-cmd);
            } else {
                sb.append(pq.isEmpty() ? 0 : -pq.poll()).append("\n");
            }
        }

        System.out.println(sb);
    }
}