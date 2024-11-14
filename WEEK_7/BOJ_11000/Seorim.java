package week7.BOJ11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        List<int[]> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lectures.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        lectures.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(lectures.getFirst()[1]);

        for (int i = 1; i < lectures.size(); i++) {
            int[] lecture = lectures.get(i);

            int earliestEnd = pq.peek();
            if (earliestEnd <= lecture[0]) {
                pq.poll();
            }
            pq.offer(lecture[1]);
        }

        System.out.println(pq.size());
    }

}
