import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();
        String prefix = br.readLine();

        for (char c: prefix.toCharArray()) {
            if (!isOperator(c)) {
                sb.append(c);
            } else {
                if (c == '(') {
                    stack.push(c);
                } else if (c == ')') {
                    // 여는 괄호가 나올 때까지 제거
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop(); // 여는 괄호 제거
                } else {
                    // 우선 순위가 동일하거나 스택이 빌 때까지 pop
                    while (!stack.isEmpty() && (priority(stack.peek()) >= priority(c))) {
                        sb.append(stack.pop());
                    }
                    stack.push(c);
                }
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

    }

    private static boolean isOperator(char c) {
        char[] operator = new char[]{'+', '-', '*', '/', '(', ')'};

        for (char o : operator) {
            if (c == o) {
                return true;
            }
        }
        return false;
    }

    private static int priority(char c) {
        if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return 0;
    }

}