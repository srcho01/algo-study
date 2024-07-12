import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Map<Long, Long> tree = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long t = Long.parseLong(st.nextToken());
            if (!tree.containsKey(t))
                tree.put(t, 1L);
            else
                tree.put(t, tree.get(t) + 1);
        }

        Set<Long> keySet = tree.keySet();
        long start = 1;
        long end = keySet.stream().max(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);

        long mid;
        while (start <= end) {
            mid = (start + end) / 2;

            long height = 0;
            for (Long key: keySet)
                height += Math.max(tree.get(key) * (key-mid), 0);

            if (height >= m)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(end);
    }
}