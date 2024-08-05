package week6.BOJ5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Seorim {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(phoneNumberList(n) ? "YES" : "NO");
        }
    }

    static boolean phoneNumberList(int n) throws IOException {
        Node trie = new Node(null);
        String[] phones = new String[n];

        for (int i=0; i<n; i++) {
            phones[i] = br.readLine();
        }
        Arrays.sort(phones, (s1, s2) -> Integer.compare(s2.length(), s1.length()));

        for (String phone: phones) {
            int visited = 0;
            Node curr = trie;

            for (int level = 0; level < phone.length(); level++) {
                int num = Integer.parseInt(String.valueOf(phone.charAt(level)));

                Optional<Node> optionalNode = curr.child.stream()
                        .filter(node -> node.root == num)
                        .findFirst();

                if (optionalNode.isPresent()) {
                    visited |= 1 << level;
                    curr = optionalNode.get();
                } else {
                    Node newNode = new Node(num);
                    curr.child.add(newNode);
                    curr = newNode;
                }
            }

            if (visited == (1 << phone.length()) - 1) return false;
        }

        return true;
    }

    static class Node {
        Integer root;
        List<Node> child;

        public Node(Integer root) {
            this.root = root;
            this.child = new ArrayList<>();
        }
    }
}
