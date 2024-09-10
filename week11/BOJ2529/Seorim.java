package week11.BOJ2529;

import java.io.*;

public class Seorim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        String[] inequality = br.readLine().split(" ");

        bw.write(biggest(inequality));
        bw.newLine();
        bw.write(smallest(inequality));
        bw.flush();
    }

    static String biggest(String[] ineqaulity) {
        int num = 9;
        int stack = 0;
        StringBuilder ret = new StringBuilder();

        for (String ineq : ineqaulity) {
            if (ineq.equals("<")) {
                stack++;
            } else {
                for (int i = stack; i >= 0; i--) {
                    ret.append(num - i);
                }

                num -= stack + 1;
                stack = 0;
            }
        }

        for (int i = stack; i >= 0; i--) {
            ret.append(num - i);
        }

        return ret.toString();
    }

    static String smallest(String[] ineqaulity) {
        int num = 0;
        int stack = 0;
        StringBuilder ret = new StringBuilder();

        for (String ineq : ineqaulity) {
            if (ineq.equals(">")) {
                stack++;
            } else {
                for (int i = stack; i >= 0; i--) {
                    ret.append(num + i);
                }

                num += stack + 1;
                stack = 0;
            }
        }

        for (int i = stack; i >= 0; i--) {
            ret.append(num + i);
        }

        return ret.toString();
    }

}
