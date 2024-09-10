package week11.BOJ5430;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Seorim {

    static List<Integer> list = new ArrayList<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            list.clear();

            char[] func = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());

            String data = br.readLine();
            if (n > 0) {
                String[] split = data.substring(1, data.length() - 1).split(",");
                for (String s : split) {
                    list.add(Integer.parseInt(s));
                }
            }

            AC(n, func);
        }

        bw.flush();
    }

    static void AC(int n, char[] func) throws IOException {
        int isForward = 1;
        int start = 0;
        int end = n - 1;

        for (char f: func) {
            if (f == 'R') {
                isForward *= -1;
            } else {
                if (end < start) {
                    bw.write("error");
                    bw.newLine();
                    return;
                } else if (isForward == 1) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        printArray(isForward, start, end);
    }

    static void printArray(int isForward, int start, int end) throws IOException {
        bw.write('[');

        if (start <= end) {
            if (isForward == 1) {
                for (int i = start; i < end; i++) {
                    bw.write(String.valueOf(list.get(i)));
                    bw.write(',');
                }
                bw.write(String.valueOf(list.get(end)));
            } else {
                for (int i = end; i > start; i--) {
                    bw.write(String.valueOf(list.get(i)));
                    bw.write(',');
                }
                bw.write(String.valueOf(list.get(start)));
            }
        }

        bw.write(']');
        bw.newLine();
    }

}
