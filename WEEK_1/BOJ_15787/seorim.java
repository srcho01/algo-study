import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ15787 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trains = new int[n];
        int mask = (1 << 20) - 1;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            int train = Integer.parseInt(st.nextToken()) - 1;
            int seat;

            switch (cmd) {
                case 1:
                    seat = 20 - Integer.parseInt(st.nextToken());
                    trains[train] = trains[train] | (1 << seat);
                    break;
                case 2:
                    seat = 20 - Integer.parseInt(st.nextToken());
                    trains[train] = trains[train] & ~(1 << seat);
                    break;
                case 3:
                    trains[train] = trains[train] >> 1;
                    break;
                case 4:
                    trains[train] = (trains[train] << 1) & mask;
                    break;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int num : trains) set.add(num);
        System.out.println(set.size());
    }
}