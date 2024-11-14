package week7.BOJ1700;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static int[] order;
    static int MAX = 200;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        order = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        int capacity = 0;
        boolean[] powerStrip = new boolean[k+1];
        int[] dist = new int[k+1];
        for (int i = 0; i < k; i++) {
            int appliance = order[i];

            if (!powerStrip[appliance]) { // 현재 꽂혀 있지 않고
                if (capacity < n) { // 남은 콘센트가 있을 때
                    powerStrip[appliance] = true;
                    capacity++;
                } else { // 남은 콘센트가 없을 때
                    cnt++;
                    int takeOut = getTakeOut(dist, powerStrip);
                    powerStrip[takeOut] = false;
                    powerStrip[appliance] = true;
                }
            }

            updateDist(i, appliance, dist);

        }

        System.out.println(cnt);

    }

    static void updateDist(int curr, int target, int[] dist) {
        dist[target] = MAX;
        for (int i = curr + 1; i < order.length; i++) {
            if (order[i] == target) {
                dist[target] = i;
                break;
            }
        }
    }

    static int getTakeOut(int[] dist, boolean[] powerStrip) {
        int ret = 0;
        int max = -1;

        for (int i = 0; i < powerStrip.length; i++) {
            if (powerStrip[i]) {
                if (dist[i] > max) {
                    max = dist[i];
                    ret = i;
                }
            }
        }

        return ret;
    }


}
