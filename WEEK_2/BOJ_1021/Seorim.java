import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int popNum = Integer.parseInt(st.nextToken());

            int index = list.indexOf(popNum);

            List<Integer> newList = new ArrayList<>();
            newList.addAll(list.subList(index+1, list.size()));
            newList.addAll(list.subList(0, index));

            if (index <= list.size() / 2)
                cnt += index;
            else
                cnt += list.size() - index;

            list = newList;
        }

        System.out.println(cnt);
    }
}