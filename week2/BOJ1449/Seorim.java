import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int tape = Integer.parseInt(st.nextToken());

        int[] loc = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            loc[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(loc);

        int cnt = 0;
        double end = 0;
        for (int leak: loc) {
            if (leak - 0.5 >= end) { // leak - 0.5부터 테이프 새로 시작
                cnt++;
                end = (leak - 0.5) + tape;
            } else if (leak + 0.5 > end) { // 기존 거에 이어 붙여서 물 막기
                cnt++;
                end += tape;
            }
        }

        System.out.println(cnt);
    }
}
