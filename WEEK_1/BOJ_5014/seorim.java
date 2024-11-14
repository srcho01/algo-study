import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ5014 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int total = Integer.parseInt(st.nextToken());
        int curr = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());


        boolean flag = true;
        boolean[] visited = new boolean[total+1];
        Queue<Integer[]> queue = new ArrayDeque<>();

        queue.add(new Integer[]{curr, 0}); // 층, cnt
        visited[curr] = true;

        while (!queue.isEmpty()) {
            Integer[] temp = queue.poll();
            int loc = temp[0];
            int cnt = temp[1];

            if (loc == target) {
                System.out.println(cnt);
                flag = false;
                break;
            }

            int goDown = loc - down;
            int goUp = loc + up;

            if (goDown >= 1 && !visited[goDown]) {
                queue.add(new Integer[]{goDown, cnt+1});
                visited[goDown] = true;
            }
            if (goUp <= total && !visited[goUp]) {
                queue.add(new Integer[]{goUp, cnt+1});
                visited[goUp] = true;
            }
        }
        if (flag) System.out.println("use the stairs");
    }
}