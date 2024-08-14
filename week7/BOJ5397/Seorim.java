package week7.BOJ5397;

import java.io.*;
import java.util.Stack;

public class Seorim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String keyLogger = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int j = 0; j < keyLogger.length(); j++) {
                char c = keyLogger.charAt(j);

                switch (c) {
                    case '<' -> {
                        if (!left.isEmpty()) {
                            right.push(left.pop());
                        }
                    }
                    case '>' -> {
                        if (!right.isEmpty()) {
                            left.push(right.pop());
                        }
                    }
                    case '-' -> {
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                    }
                    default -> left.push(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            while (!left.isEmpty()) {
                sb.append(left.pop());
            }
            bw.write(sb.reverse().toString());
            while(!right.isEmpty()) {
                bw.write(right.pop());
            }
            bw.write('\n');
        }

        bw.flush();
        bw.close();
    }

}
